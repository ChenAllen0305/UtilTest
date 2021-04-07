package JPushUtilTest;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.*;

public class JPushUtil {

    //云能
    private static String APP_KEY = "d4f5597e2edd8096c9b40c55";
    private static String MASTER_SECRET = "0ab8b608aeab27769df240cf";

    //PowerPlus
//    private static String APP_KEY = "8c737d47b7257dcf2a545ab8";
//    private static String MASTER_SECRET = "73bcf9e8ec19e3dd95b6de29";

    public static void push(Map<String, String> parm, List<String> list) {
        jpushAndroid(parm, list);
//        jpushAll(parm);
    }

    public static void push(Map<String, String> parm, String tag) {
//        jpushAndroid(parm, tag);
        jpushAll(parm, tag);
    }

    public static void jpushAndroid(Map<String, String> parm, List<String> list) {

        //创建JPushClient(极光推送的实例)
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //推送的关键,构造一个payload
        PushPayload payload = PushPayload.newBuilder()
                //指定android平台的用户
                .setPlatform(Platform.android())
                //你项目中的所有用户
                .setAudience(Audience.alias(list))
                .setNotification(Notification.android(parm.get("msg"), parm.get("title"), parm))
                //发送内容
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                //这里是指定开发环境,不用设置也没关系
                .setMessage(Message.content(parm.get("msg")))
                .build();
        try {
            payload.resetOptionsTimeToLive(100000);
            PushResult pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static void jpushAndroid(Map<String, String> parm, String tag) {
        //创建JPushClient(极光推送的实例)
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //推送的关键,构造一个payload
        PushPayload payload = PushPayload.newBuilder()
                //指定android平台的用户
                .setPlatform(Platform.android())
                //你项目中的所有用户
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.android(parm.get("msg"), parm.get("title"), parm))
                //发送内容
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                //这里是指定开发环境,不用设置也没关系
                .setMessage(Message.content(parm.get("msg")))
                .build();
        try {
            payload.resetOptionsTimeToLive(100000);
            PushResult pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static void jpushAll(Map<String, String> parm) {
        //创建JPushClient
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //创建option
        PushPayload payload = PushPayload.newBuilder()
                //所有平台的用户
                .setPlatform(Platform.all())
                //registrationId指定用户
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        //发送ios
                        .addPlatformNotification(IosNotification.newBuilder()
                                //消息体
                                .setAlert(parm.get("msg"))
                                .setBadge(+1)
                                //ios提示音
                                .setSound("happy")
                                //附加参数
                                .addExtras(parm)
                                .build())
                        //发送android
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                //附加参数
                                .addExtras(parm)
                                //消息体
                                .setAlert(parm.get("msg"))
                                .build())
                        .build())
                //指定开发环境 true为生产模式 false 为测试模式 (android不区分模式,ios区分模式)
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                //自定义信息
                .setMessage(Message.newBuilder().setMsgContent(parm.get("msg")).addExtras(parm).build())
                .build();
        try {
            payload.resetOptionsTimeToLive(100000);
            PushResult pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static void jpushAll(Map<String, String> parm, String tag) {
        //创建JPushClient
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //创建option
        Audience audience = Audience.tag(tag);
//        System.out.println(audience.toJSON());
        PushPayload payload = PushPayload.newBuilder()
                //所有平台的用户
                .setPlatform(Platform.all())
                //registrationId指定用户
                .setAudience(Audience.tag(tag))
//                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        //发送ios
                        .addPlatformNotification(IosNotification.newBuilder()
                                //消息体
                                .setAlert(parm.get("msg"))
                                //ios提示音
                                .setSound("happy")
                                //附加参数
                                .addExtras(parm)
                                .build())
                        //发送android
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                //附加参数
                                .addExtras(parm)
                                //消息体
                                .setAlert(parm.get("msg"))
                                .build())
                        .build())
                //指定开发环境 true为生产模式 false 为测试模式 (android不区分模式,ios区分模式)
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                //自定义信息
                .setMessage(Message.newBuilder().setMsgContent(parm.get("msg")).addExtras(parm).build())
                .build();
        try {
            payload.resetOptionsTimeToLive(15);
//            System.out.println(payload.toJSON());
            PushResult pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }
}
