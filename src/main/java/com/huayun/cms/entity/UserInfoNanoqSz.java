package com.huayun.cms.entity;

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
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfoNanoqSz implements Serializable {

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

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;
}
