package RestTemplateTest.body;

import lombok.Data;

import java.util.Date;

/**
 * @className: User
 * @author: puzhiqiang
 * @date: 2021-12-2
 * @description:
 */
@Data
public class User {

    /**
     * ID
     **/
    private String id;

    /**
     * 用户名
     **/
    private String username;

    /**
     * 密码
     **/
    private String password;

    /**
     * 名称
     **/
    private String name;

    /**
     * 手机号
     **/
    private String mobilePhone;

    /**
     * 邮箱
     **/
    private String email;

    /**
     * 状态（0为系统内置保留，1为手动添加用户，2认证，3锁定，100黑名单）
     **/
    private Integer status;

    /**
     * 头像
     **/
    private String headImage;

    /**
     * 描述
     **/
    private String description;

    /**
     * 添加时间
     **/
    private Date crtTime;

    /**
     * 添加者
     **/
    private String crtUser;

    /**
     * IP
     **/
    private String crtHost;

    /**
     * 预留字段
     **/
    private String attr;

    /**
     * 卡号
     **/
    private String cardId;


    private String certificateNo;


    /**
     * 微信号
     **/
    private String weChat;

    private Boolean state;

    /**
     * ldap路径
     **/
    private String distinguishedName;

    /**
     * 昵称
     **/
    private String nickname;

    /**
     * 上次登录时间
     **/
    private Date lastLoginTime;

    /**
     * 来源
     **/
    private String source;

    /**
     * 身份证正面
     **/
    private String positive;

    /**
     * 身份证反面
     **/
    private String reverse;

    /**
     * 证件
     **/
    private String certificate;

    private Date statusTime;

    private Date authTime;

    private String authStatus;

    /**
     * 原因
     **/
    private String reason;

    /**
     * 用户的真实姓名
     */
    private String realName;

    private String usedLog;

    private Boolean enable;


    /**
     * 验证码
     **/
    private String code;
    /**
     * 类型 1-手机号 2-邮箱
     **/
    private String type;

    public User() {
    }

    public User(String crtUser) {
        this.crtUser = crtUser;
    }

    public Date getCrtTime() {
        return crtTime == null ? null : (Date) crtTime.clone();
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime == null ? null : (Date) crtTime.clone();
    }

}
