package Util;

import Util.StringUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实际开发中比较常用时间日期的各种转换
 *
 * @author diaoshili
 */
public class DateTimeUtils {


    /**
     * 默认的时间日期样式
     */
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final TimeZone defaultTimeZone = TimeZone.getDefault();

    /**
     * 格式化字符串枚举
     */
    public enum PATTERN {
        DATETIME("yyyy-MM-dd HH:mm:ss", "日期时间"),
        DATE("yyyy-MM-dd", "日期"),
        TIME("HH:mm:ss", "时间"),
        DATETIME_SPACE("yyyy MM dd HH mm ss", "空格间隔的日期时间"),
        DATETIME_MILLI("yyyy-MM-dd HH:mm:ss.SSS", "日期时间毫秒");
        private String value;
        private String title;
        PATTERN(String value, String title) {
            this.value = value;
            this.title = title;
        }
        public String value() {
            return value;
        }
        public String title() {
            return title;
        }
    }

    /**
     * 系统默认的时区
     */
    private static final ZoneId ZONE_ID = ZoneId.systemDefault();

//    private static Logger logger = LoggerFactory.getLogger(DateTimeUtils.class);

    private static Map<String, DateTimeFormatter> patternFormatterMap = new ConcurrentHashMap<>();
    private static Map<String, ZoneId> idZoneMap = new ConcurrentHashMap<>();

    static {
        patternFormatterMap.put(PATTERN.DATETIME.value(), DateTimeFormatter.ofPattern(PATTERN.DATETIME.value()));
        patternFormatterMap.put(PATTERN.DATE.value(), DateTimeFormatter.ofPattern(PATTERN.DATE.value()));
        patternFormatterMap.put(PATTERN.TIME.value(), DateTimeFormatter.ofPattern(PATTERN.TIME.value()));
        patternFormatterMap.put(PATTERN.DATETIME_SPACE.value(), DateTimeFormatter.ofPattern(PATTERN.DATETIME_SPACE.value()));
    }

    /**
     * 根据时区ID获得相应的ZoneId对象
     *
     * @param timeZoneId 时区ID
     * @return ZoneId对象
     */
    public static ZoneId getZoneId(String timeZoneId) {
        if (StringUtil.isEmpty(timeZoneId)) {
            timeZoneId = defaultTimeZone.getID();
        }
        ZoneId zoneId = idZoneMap.get(timeZoneId);
        if (zoneId == null) {
            zoneId = TimeZone.getTimeZone(timeZoneId).toZoneId();
            idZoneMap.put(timeZoneId, zoneId);
        }
        return zoneId;
    }

    /**
     * 根据格式化字符串获得formatter对象
     *
     * @param pattern 格式化字符串
     * @return formatter对象
     */
    private static DateTimeFormatter getFormatter(String pattern) {
        return patternFormatterMap.computeIfAbsent(pattern, DateTimeFormatter::ofPattern);
    }

    /**
     * 根据时间戳和时区ID获得日期字符串
     *
     * @param timestamp  时间戳
     * @param timeZoneId 时区ID
     * @return 日期字符串
     */
    public static String getDateString(Long timestamp, String timeZoneId) {
        return getDateString(timestamp, timeZoneId, PATTERN.DATETIME.value());
    }

    /**
     * 根据时间戳和时区ID获得日期字符串
     *
     * @param timestamp  时间戳
     * @param timeZoneId 时区ID
     * @param pattern    格式化字符串
     * @return 日期字符串
     */
    public static String getDateString(Long timestamp, String timeZoneId, String pattern) {
        if (timestamp != null) {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), getZoneId(timeZoneId));
            return getFormatter(pattern).format(localDateTime);
        } else {
            return null;
        }
    }

    /**
     * 根据日期字符串和时区ID获得时间戳
     *
     * @param dateString 日期字符串
     * @param timeZoneId 时区ID
     * @return 时间戳
     */
    public static Long getTimestamp(String dateString, String timeZoneId) {
        return getTimestamp(dateString, timeZoneId, PATTERN.DATETIME.value());
    }

    /**
     * 根据日期字符串和时区ID获得时间戳
     *
     * @param dateString 日期字符串
     * @param timeZoneId 时区ID
     * @param pattern    格式化字符串
     * @return 时间戳
     */
    private static Long getTimestamp(String dateString, String timeZoneId, String pattern) {
        long timestamp = 0L;
        if (!StringUtil.isEmpty(dateString)) {
            LocalDateTime localDateTime = LocalDateTime.parse(dateString, getFormatter(pattern));
            return localDateTime.atZone(getZoneId(timeZoneId)).toInstant().toEpochMilli();
        }
        return timestamp;
    }

    /**
     * 对日期对象进行时区偏移
     * 一般情况下不会用到该方法，只适用于从前端获取过来的本身是Date对象，希望转成服务器对应的正确时间对象
     * @param date 日期
     * @param timeZoneId 时区
     */
    public static void updateTimeZoneDate(Date date, String timeZoneId) {
        if (date != null) {
            date.setTime(date.getTime() - TimeZone.getTimeZone(timeZoneId).getOffset(date.getTime()) + defaultTimeZone.getOffset(date.getTime()));
        }
    }

    /**
     * 获得时区偏移后的新的日期对象
     * 一般情况下不会用到该方法，只适用于从前端获取过来的本身是Date对象，希望转成服务器希望的正确的时间对象
     * @param date 日期
     * @param timeZoneId 时区
     * @return 偏移后的日期对象
     */
    public static Date getTimeZoneDate(Date date, String timeZoneId) {
        if (date != null) {
            return new Date(date.getTime() - TimeZone.getTimeZone(timeZoneId).getOffset(date.getTime()) + defaultTimeZone.getOffset(date.getTime()));
        } else {
            return null;
        }
    }

    /**
     * 按照默认的模板将时间戳转换为时间日期的字符串形式
     *
     * @param epochSecond 时间戳 1525767228
     * @return 返回时间日期的字符串形式 2018-05-08 16:13:48
     */
    public static String DefaultFormatEpochSecond(long epochSecond) {
        System.out.println(epochSecond);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond),
                ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN));
    }

    /**
     * 按照默认的模板将时间戳转换为时间日期的字符串形式
     *
     * @param epochMilli 时间戳 1525767228000
     * @return 返回时间日期的字符串形式 2018-05-08 16:13:48
     */
    public static String DefaultFormatEpochMilli(long epochMilli) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli),
                ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN));
    }


    /**
     * 按照给定的时间日期模版，将时间戳转换成字符串形式
     *
     * @param pattern     模版，例如"yyyy-MM-dd HH:mm:ss"
     * @param epochSecond 时间戳 1525767228
     * @return 转换后的字符串 2018-05-08 16:13:48
     */


    public static String formatEpochSecond(String pattern, long epochSecond) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond),
                ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * 按照给定的时间日期模版，将时间戳转换成字符串形式
     *
     * @param dateTimeFormatter 模版
     * @param epochSecond       时间戳
     * @return 转换后的字符串
     */
    public static String formatEpochSecond(DateTimeFormatter dateTimeFormatter, long epochSecond) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond),
                ZoneId.systemDefault());
        return localDateTime.format(dateTimeFormatter);
    }


    /**
     * 将一种时间日期字符串转换成另外一种形式
     *
     * @param oldPattern  旧的时间日期字符串样式 "yyyy-MM-dd HH:mm:ss"
     * @param oldDateTime 旧的时间日期字符串 2018-05-08 16:13:48
     * @param newPattern  新的时间日期字符串样式 "MM-dd"
     * @return 转换后的字符串 05-08
     */
    public static String parseStrToNewStr(String oldPattern, String oldDateTime, String newPattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(oldDateTime, DateTimeFormatter.ofPattern(oldPattern));
        return localDateTime.format(DateTimeFormatter.ofPattern(newPattern));
    }


    /**
     * 将一种时间日期字符串转换成另外一种形式
     *
     * @param oldDateTimeFormatter 旧的时间日期字符串样式
     * @param oldDateTime          旧的时间日期字符串
     * @param newDateTimeFormatter 新的时间日期字符串样
     * @return 转换后的字符串
     */
    public static String parseStrToNewStr(DateTimeFormatter oldDateTimeFormatter, String oldDateTime,
                                          DateTimeFormatter newDateTimeFormatter) {
        LocalDateTime localDateTime = LocalDateTime.parse(oldDateTime, oldDateTimeFormatter);
        return localDateTime.format(newDateTimeFormatter);
    }


    /**
     * 将给定的时间日期字符串按照指定的模版解析成时间戳
     *
     * @param pattern  模版，例如"yyyy-MM-dd HH:mm:ss"
     * @param dateTime 时间日期字符串 2018-05-08 16:13:48
     * @return 时间戳 1525767228000
     */
    public static long parseDateTime(String pattern, String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
        Instant instant = localDateTime.atZone(ZONE_ID).toInstant();
        return instant.toEpochMilli();
    }


    /**
     * 将给定的时间日期字符串按照指定的模版解析成时间戳
     *
     * @param dateTimeFormatter 模版
     * @param dateTime          时间日期字符串
     * @return 时间戳
     */
    public static long parseDateTime(DateTimeFormatter dateTimeFormatter, String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
        Instant instant = localDateTime.atZone(ZONE_ID).toInstant();
        return instant.toEpochMilli();
    }


    /**
     * 将给定的时间日期字符串按照默认的模版解析成时间戳 "yyyy-MM-dd HH:mm:ss"
     *
     * @param dateTime 2018-05-08 16:13:48
     * @return 时间戳 1525767228000
     */
    public static long DefaultParseDateTime(String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(DEFAULT_PATTERN));
        Instant instant = localDateTime.atZone(ZONE_ID).toInstant();
        return instant.toEpochMilli();
    }


    /**
     * 按照给定的格式获取昨天这个时候的时间日期字符串
     *
     * @param dateTimeFormatter 时间日期格式
     * @return
     */
    public static String yesterdayStr(DateTimeFormatter dateTimeFormatter) {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(-1);
        return localDateTime.format(dateTimeFormatter);
    }


    /**
     * 按照给定的格式获取昨天这个时候的时间日期字符串
     *
     * @param pattern 时间日期格式
     * @return
     */
    public static String yesterdayStr(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(-1);
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * 按照格式生成时间
     *
     * @param dateTime 时间日期格式
     * @return
     */
    public static String format(LocalDateTime dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        return dateTimeFormatter.format(dateTime);
    }

    /**
     * 按照格式生成时间
     *
     * @param dateTime 时间日期格式
     * @return
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(dateTime);
    }


    public static Date formatToDate(String dateTime, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormat.parse(dateTime);
        } catch (ParseException e) {
//            logger.error("解析时间失败", e);
        }
        return date;
    }

    /**
     * 按照格式生成时间
     *
     * @param dateTime 时间日期格式
     * @return
     */
    public static String format(OffsetDateTime dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        return dateTimeFormatter.format(dateTime);
    }

    /**
     * 按照格式生成时间
     *
     * @param dateTime 时间日期格式
     * @return
     */
    public static String format(OffsetDateTime dateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(dateTime);
    }

    /**
     * 将日期格式化为字符串
     *
     * @param dateTime
     * @return
     */
    public static String format(Date dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        return dateTimeFormatter.format(dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }


    /**
     * 按照给定的格式获取昨天这个时候的时间日期字符串
     *
     * @param dateTime 时间日期格式
     * @return
     */
    public static LocalDateTime format(String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(DEFAULT_PATTERN));
    }


    /**
     * 按照给定的格式获取昨天这个时候的时间日期字符串
     *
     * @param dateTime 时间日期格式
     * @return
     */
    public static LocalDateTime format(String dateTime, String pattern) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern)).plusHours(8);
    }

    /**
     * 按照给定的格式获取昨天这个时候的时间日期字符串
     *
     * @param dateTime 时间日期格式
     * @return
     */
    public static Date formatToDate(String dateTime) {
        return asDate(LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(DEFAULT_PATTERN)));
    }

    /**
     * 将DATE按照格式转为string
     *
     * @param pattern
     * @return
     */
    public static String format(String pattern, Date date) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        return dateTimeFormatter.format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    /**
     * 将时间格式化15分钟整
     *
     * @param pattern
     * @param min
     * @return
     */
    public static LocalDateTime format(String pattern, int min) {
        return format(pattern).truncatedTo(ChronoUnit.HOURS).plusMinutes(min * (DateTimeUtils.format(pattern).getMinute() / min));
    }


    /**
     * 按照给定的格式获取当前时间日期字符串
     *
     * @param pattern 时间日期格式
     * @return
     */
    public static String todayStr(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * 按照给定的格式获取当前时间日期字符串
     *
     * @param dateTimeFormatter 时间日期格式
     * @return
     */
    public static String todayStr(DateTimeFormatter dateTimeFormatter) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(dateTimeFormatter);
    }


    /**
     * 获取昨天这个时间的时间戳
     *
     * @return 时间戳
     */
    public static long yesterday() {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(-1);
        return localDateTime.atZone(ZONE_ID).toInstant().toEpochMilli();
    }

    /**
     * 将localdate 转换为 date
     *
     * @param localDate
     * @return
     */
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将localDateTime 转换为 date
     *
     * @param localDateTime
     * @return
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * date 转换为 LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * date 转换为 LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * date 转换为 LocalDateTime
     *
     * @param date
     * @return
     */
    public static OffsetDateTime asOffsetDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toOffsetDateTime();
    }

    /**
     * 按照给定的格式获取当前时间日期字符串
     *
     * @param time 时间日期格式 格式"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static LocalDateTime parseLocalDatetime(String time) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(DEFAULT_PATTERN));
    }

    /**
     * 获取当前时间
     *
     * @return 时间戳
     */
    public static Instant time() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.atZone(ZONE_ID).toInstant();
    }

    /**
     * 获取当前时间
     *
     * @return date
     */
    public static LocalDateTime currentDateTime() {
        return LocalDateTime.ofInstant(time(), ZONE_ID);
    }

    /**
     * 获得不包含时间的UTC秒数
     *
     * @return
     */
    public static OffsetDateTime currentUtcZeroTime() {
        return OffsetDateTime.now(ZoneOffset.UTC);
    }

    /**
     * 获取当前时间
     *
     * @return date
     */
    public static List<Date> asDate(LocalDateTime start, LocalDateTime end) {
        LinkedList<Date> objects = new LinkedList<>();
        objects.add(asDate(start));
        objects.add(asDate(end));
        return objects;
    }

    public static String format(ZonedDateTime zonedDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        return dateTimeFormatter.format(zonedDateTime);
    }


    public static String format(ZonedDateTime zonedDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(zonedDateTime);
    }

    public static LocalDateTime updateTimeZoneDate(LocalDateTime of, String timeZoneId) {
        ZoneOffset from = ZoneOffset.systemDefault().getRules().getOffset(of);
        Instant instant = of.toInstant(from);
        of = LocalDateTime.ofInstant(instant, ZoneId.of(timeZoneId).getRules().getOffset(of));
        return of;
    }

    public static String getTimeZoneIdByDtimeAndRtime(String dtime, Long rtime) {
        String[] timeZoneIds = TimeZone.getAvailableIDs();
        for (String timeZoneId : timeZoneIds) {
            if (getDateString(rtime, timeZoneId).equals(dtime)) {
                return timeZoneId;
            }
        }
        return null;
    }

    /**
     * 处理15分钟时间对象
     * @param minute
     * @param localDateTime
     * @return
     */
    public static LocalDateTime timeHandle(int minute, LocalDateTime localDateTime) {
        if (minute >= 45) {
            localDateTime = localDateTime.withMinute(45);
        } else if (minute >= 30) {
            localDateTime = localDateTime.withMinute(30);
        } else if (minute >= 15) {
            localDateTime = localDateTime.withMinute(15);
        } else  if (minute >= 0) {
            localDateTime = localDateTime.withMinute(0);
        }
        return localDateTime;
    }

    /**
     * 生成时间范围字段
     * @param start
     * @param end
     * @return
     */
    public static String asDateString(LocalDateTime start, LocalDateTime end) {
        return DateTimeUtils.format(start) + "," + DateTimeUtils.format(end);
    }
}