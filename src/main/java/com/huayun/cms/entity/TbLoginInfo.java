package com.huayun.cms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuzh
 * @since 2021-07-20
 */
@Data
@Accessors(chain = true)
public class TbLoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 解码系统名
     */
    @TableId("SYS_NAME")
    private String sysName;

    /**
     * 系统登录ID
     */
    @TableField("LOGIN_ID")
    private Integer loginId;

    /**
     * 机房
     */
    @TableField("CENTER")
    private String center;

    /**
     * 用户名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 登录状态
     */
    @TableField("LOGIN_STATUS")
    private Integer loginStatus;

    /**
     * 登录日期yyyy-mm-dd
     */
    @TableField("LOGIN_DATE")
    private String loginDate;

    /**
     * 登录时间HH:MM:SS
     */
    @TableField("LOGIN_TIME")
    private String loginTime;

    /**
     * 登录会话
     */
    @TableField("LOGIN_SESSION")
    private Integer loginSession;

    /**
     * 登录IP
     */
    @TableField("LOGIN_IP")
    private String loginIp;

    /**
     * 市场权限
     */
    @TableField("SERVER_IP")
    private String serverIp;

    /**
     * 行情数据权限
     */
    @TableField("REMARK")
    private String remark;


}
