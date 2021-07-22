package com.huayun.cms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class TbUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 解码系统名
     */
    @TableId("SYS_NAME")
    private String sysName;

    /**
     * 用户名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 密码
     */
    @TableField("USER_PASSWORD")
    private String userPassword;

    /**
     * 机房
     */
    @TableField("CENTER")
    private String center;

    /**
     * 用户状态
     */
    @TableField("USER_STATUS")
    private Integer userStatus;

    /**
     * 用户全称
     */
    @TableField("USER_FULL_NAME")
    private String userFullName;

    /**
     * 用户机器IP
     */
    @TableField("USER_IP")
    private String userIp;

    /**
     * 市场权限
     */
    @TableField("MARKET_PERMISSION")
    private Integer marketPermission;

    /**
     * 行情数据权限
     */
    @TableField("DATA_PERMISSION")
    private Integer dataPermission;

    /**
     * 开始日期
     */
    @TableField("START_DATE")
    private String startDate;

    /**
     * 结束日期
     */
    @TableField("END_DATE")
    private String endDate;


}
