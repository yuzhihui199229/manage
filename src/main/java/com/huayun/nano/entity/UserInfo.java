package com.huayun.nano.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuzh
 * @since 2021-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("USER_INFO")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("USER_NAME")
    private String userName;

    @TableField("USER_PWD")
    private String userPwd;

    @TableField("USER_STATUS")
    private Integer userStatus;

    @TableField("MARKET_PERMISSION")
    private Integer marketPermission;

    @TableField("LOGIN_NUM_PREMSSION")
    private Integer loginNumPremssion;

    @TableField("EXPIRE_DATE")
    private Integer expireDate;

    @TableField("INVESTOR_NAME")
    private String investorName;

}
