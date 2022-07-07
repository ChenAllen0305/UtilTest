package StringTest;

/**
 * @className: StringFromat
 * @author: ChenLun
 * @date: 2022/7/4 17:28
 * @description:
 */
public class StringFromat {
    public static void main(String[] args) {
        String command = "mqadmin updateAclConfig -n %s -c %s -a %s -s %s -i SUB -u SUB -t %s";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("subscribe.getTopic1()").append("=SUB,");
        stringBuilder.append("subscribe.getTopic2()").append("=SUB,");
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        String tihuancommand = String.format(command, "rocketMqAddress", "rocketMqClusterName", "subscribeConfig.getMqAccount()", "subscribeConfig.getMqPassword()", stringBuilder);
        System.out.println(tihuancommand);
    }
}
