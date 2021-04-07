package Constant;

/**
 * @title: OpticalConsts
 * @Author Chen Lun
 * @Date: 2021/3/29
 */
public class OpticalConsts {

    public enum ADVANCED_OPTION {
        BALANCED("Balanced", "平衡模式"),
        COSTSAVING("CostSaving", "节约模式");
        private String value;
        private String title;
        ADVANCED_OPTION(String value, String title) {
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

    public enum PUSH_RECORD_TYPE {
        ALERT("Alert", "告警"),
        NOTICE("Notice", "通知");
        private String value;
        private String title;
        PUSH_RECORD_TYPE(String value, String title) {
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

    public enum PUSH_RECORD_STATUS {
        READ("Read", "已读"),
        UNREAD("Unread", "未读");
        private String value;
        private String title;
        PUSH_RECORD_STATUS(String value, String title) {
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
     * 推送记录类型枚举
     */
    public enum PUSH_RECORD_NOTICE_TYPE {
        SITE_SHARING_TO("Site Sharing To", "持有者分享消息"),
        SITE_SHARING_FROM("Site Sharing From", "接收者分享消息"),
        SITE_SHARING_CANCEL_TO("Site Sharing Cancel To", "持有者取消消息"),
        SITE_SHARING_CANCEL_FROM("Site Sharing Cancel From", "接收者被取消消息"),
        SITE_SHARING_CANCEL_INITIATIVE("Site Sharing Cancel Initiative", "接收者主动取消消息"),
        SITE_CREATE("Site Creation", "电站创建"),
        SITE_DELETE("Site Modification", "电站修改"),
        SITE_MODIFY("Site Deletion", "电站删除");
        private String value;
        private String title;
        PUSH_RECORD_NOTICE_TYPE(String value, String title) {
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
}
