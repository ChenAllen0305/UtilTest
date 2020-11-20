//package com.wanke.dsp.util;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.net.URLEncoder;
//import java.util.*;
//
//public class CsvUtil {
//
//    /**
//     * CSV文件列分隔符
//     */
//    private static final String CSV_COLUMN_SEPARATOR = ",";
//
//    /**
//     * CSV文件行分隔符
//     */
//    private static final String CSV_ROW_SEPARATOR = "\r\n";
//
//    public static List<List<String>> readCsv(MultipartFile file) throws IOException {
//        InputStream inputStream = file.getInputStream();
//        InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
//        BufferedReader br = new BufferedReader(isr);
//        String str;
//        List<List<String>> result = new ArrayList<>();
//        while ((str = br.readLine()) != null) {
//            List<String> list = new ArrayList<>();
//            Collections.addAll(list, str.split(","));
//            result.add(list);
//        }
//        return result;
//    }
//
//    public static List<List<String>> readCsv(File file) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String str;
//        List<List<String>> result = new ArrayList<>();
//        while ((str = br.readLine()) != null) {
//            List<String> list = new ArrayList<>();
//            Collections.addAll(list, str.split(","));
//            result.add(list);
//        }
//        return result;
//    }
//
//    /**
//     * @param dataList 集合数据
//     * @param titles   表头部数据
//     * @param keys     表内容的键值
//     * @param os       输出流
//     */
//    public static void exportCsv(List<Map<String, Object>> dataList, String titles, String keys, OutputStream os) throws Exception {
//        StringBuilder sb1 = new StringBuilder();
//        String[] titleArr;
//        String[] keyArr;
//        titleArr = titles.split(",");
//        keyArr = keys.split(",");
//        // 组装表头
//        for (String title : titleArr) {
//            sb1.append(title).append(CSV_COLUMN_SEPARATOR);
//        }
//        sb1.append(CSV_ROW_SEPARATOR);
//        os.write(sb1.toString().getBytes("UTF-8"));
//        // 组装数据
//        if (CollectionUtils.isNotEmpty(dataList)) {
//            int num = 0;
//            for (Map<String, Object> data : dataList) {
//                num++;
//                StringBuilder sb2 = new StringBuilder();
//                for (String key : keyArr) {
//                    Object value = data.get(key);
//                    sb2.append(value == null ? "" : value.toString().replaceAll("\r|\n", "")).append(CSV_COLUMN_SEPARATOR);
//                }
//                sb2.append(CSV_ROW_SEPARATOR);
//                os.write(sb2.toString().getBytes("UTF-8"));
//                if (num % 5000 == 0) {
//                    os.flush();
//                }
//            }
//        }
//        os.flush();
//    }
//
//    /**
//     * 设置Header
//     * @param fileName
//     * @param response
//     * @throws UnsupportedEncodingException
//     */
//    public static void responseSetProperties(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
//        // 设置文件后缀
//        String fn = fileName + ".csv";
//        // 读取字符编码
//        String utf = "UTF-8";
//        // 设置响应
//        response.setContentType("application/ms-txt.numberformat");
//        response.setCharacterEncoding(utf);
//        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fn, utf));
//    }
//}