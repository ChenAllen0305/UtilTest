package Email;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import java.io.IOException;

/**
 * ClassName: CheckEmail
 * Author: ChenLun
 * date: 2021/6/15
 * Description:
 */
@Slf4j
public class CheckEmail {
//    public static final String SENDER_EMAIL = "tjtbznzz@tbea.com";
    public static final String SENDER_EMAIL = "no-reply@domain.com";
    public static final String SENDER_EMAIL_SERVER = SENDER_EMAIL.split("@")[1];

//    public static final String SENDER_EMAIL = "574484572@qq.com";
//    public static final String SENDER_EMAIL_SERVER = SENDER_EMAIL.split("@")[1];

    /**
     *
     * @param email  The recipient's email address, it need to be validate if it is real exists or doesn't exists.
     * @return True if email is real exists, false if not.
     */
    public boolean checkEmailMethod(String email) {
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            System.err.println("Format error");
            return false;
        }

        String host = "";
        String hostName = email.split("@")[1];
        Record[] result = null;
        SMTPClient client = new SMTPClient();
        //设置连接超时时间,有些服务器比较慢
        client.setConnectTimeout(8000);

        try {
            // 查找MX记录
            Lookup lookup = new Lookup(hostName, Type.MX);
            lookup.run();
            if (lookup.getResult() != Lookup.SUCCESSFUL) {
                log.info("找不到MX记录");
                return false;
            } else {
                result = lookup.getAnswers();
            }
            // 连接到邮箱服务器
//            for (Record record : result) {
//                log.info(record.getAdditionalName().toString());
//                System.out.println(((MXRecord) record).getPriority());
//            }
            int count=0;
            for (Record record : result) {
                host = record.getAdditionalName().toString();
                try {
                    //连接到接收邮箱地址的邮箱服务器
                    client.connect(host);
                } catch (Exception e) {        //捕捉连接超时的抛出的异常
                    count++;
                    //如果由MX得到的result服务器都连接不上，则认定email无效
                    if (count >= result.length) {
                        log.info("Connect mail server timeout...");
                        return false;
                    }
                }
                //服务器通信不成功
                if (!SMTPReply.isPositiveCompletion(client.getReplyCode())) {
                    client.disconnect();
                } else {
                    log.info("Connection succeeded to " + host + " " + client.getReplyString());
                    try {
                        //这一步可能会出现空指针异常
                        client.login(SENDER_EMAIL_SERVER);
                    } catch (Exception e) {
                        return false;
                    }
                    log.info(">HELO " + SENDER_EMAIL_SERVER + "=" + client.getReplyString());

                    client.setSender(SENDER_EMAIL);
                    //为解决hotmail有的MX可能出现=550 OU-001 (SNT004-MC1F43) Unfortunately, messages from 116.246.2.245 weren't sent.
                    if (client.getReplyCode() != 250) {
                        client.disconnect();
                        //把client.login 和client.setSender放在循环体内，这样所有的如果某mx不行就换其他mx，但这样会对无效的邮箱进行所有mx遍历，耗时
                        continue;
                    }
                    log.info(">MAIL FROM: <" + SENDER_EMAIL + "=" + client.getReplyString());
                    try {
                        client.addRecipient(email);
                    } catch (Exception e) {
                        return false;
                    }
                    log.info(">RCPT TO: <" + email + "=" + client.getReplyString());

                    //最后从收件邮箱服务器返回true，说明服务器中能够找到此收件地址，邮箱有效
                    if (250 == client.getReplyCode()) {
                        return true;
                    }
                    client.disconnect();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException ignored) {
            }
            // print log
            System.out.println(log);
        }
        return false;
    }

    /**
     * This method is more accurate than checkEmailMethod(String email);
     *
     * @param email  The recipient's email address, it need to be validate if it is real exists or doesn't exists.
     * @return True if email is real exists, false if not.
     */
    public boolean checkEmail(String email){
        if(email.split("@")[1].equals("qq.com")){
            if( checkEmailMethod(email) && checkEmailMethod(email) && checkEmailMethod(email)){
                return true;
            }else{
                return false;
            }
        }
        return checkEmailMethod(email);
    }


    public static void main(String[] args) {
        CheckEmail ce = new CheckEmail();
        if(ce.checkEmail("tjtbznzz@tbea.com")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

}