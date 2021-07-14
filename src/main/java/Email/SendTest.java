//package Email;
//
//import java.util.Properties;
//
///**
// * ClassName: SendTest
// * Author: ChenLun
// * date: 2021/6/15
// * Description:
// */
//public class SendTest {
//    public static void main(String[] args) {
//        try {
//            Properties prop = new Properties();
//            prop.setProperty("mail.host", "smtp.139.com");  //设置QQ邮件服务器
//            prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
//            prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码
//
//            // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
////        MailSSLSocketFactory sf = new MailSSLSocketFactory();
////        sf.setTrustAllHosts(true);
////        prop.put("mail.smtp.ssl.enable", "true");
////        prop.put("mail.smtp.ssl.socketFactory", sf);
//
//            //使用JavaMail发送邮件的5个步骤
//            //创建定义整个应用程序所需的环境信息的 Session 对象
//
//            Session session = Session.getDefaultInstance(prop, new Authenticator() {
//                @Override
//                public PasswordAuthentication getPasswordAuthentication() {
//                    //发件人邮件用户名、授权码
//                    return new PasswordAuthentication("18395960684@139.com", "1596313ad7b0cd986300");
////                    return new PasswordAuthentication(params.getAccount(), password);
//                }
//            });
//            //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
//            session.setDebug(true);
//            //2、通过session得到transport对象
//            Transport ts = session.getTransport();
//            //3、使用邮箱的用户名和授权码连上邮件服务器
//            ts.connect("smtp.139.com", "18395960684@139.com", "1596313ad7b0cd986300");
//
//            //4、创建邮件
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("18395960684@139.com"));
//
//            //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress("18395960684@139.com"));
//            message.setSubject("测试邮件");
//            message.setContent("ceshiyixia", "text/html;charset=UTF-8");
//            //5、发送邮件
////            测试注解
////            ts.sendMessage(message, message.getAllRecipients());
//            ts.close();
//
//            //修改发送表状态
////            updateSendStausDO.setSendStatus(SendStatusEnum.SENDED);
////            Integer succeedCount = 0;
////            if (updateSendStausDO.getSucceedCount() != null) {
////                succeedCount = updateSendStausDO.getSucceedCount();
////            }
////            updateSendStausDO.setSucceedCount(succeedCount + 1);
////            sendMarketingActivityDao.updateSendMarketingActivityStatus(sendId, updateSendStausDO);
//        } catch (MessagingException e) {
//            //修改发送表状态
//            e.printStackTrace();
////            updateSendStausDO.setSendStatus(SendStatusEnum.SEND_FAIL);
////            sendMarketingActivityDao.updateSendMarketingActivityStatus(sendId, updateSendStausDO);
//        }
//    }
//}
