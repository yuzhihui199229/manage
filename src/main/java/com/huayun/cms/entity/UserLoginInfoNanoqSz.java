package com.huayun.cms.entity;

import java.math.BigDecimal;
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
public class UserLoginInfoNanoqSz implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("LOGIN_ID")
    private Integer loginId;

    @TableField("USER_NAME")
    private String userName;

    @TableField("LOGIN_STATUS")
    private Integer loginStatus;

    @TableField("SESSION_ID")
    private BigDecimal sessionId;

    @TableField("CLIENT_INFO")
    private String clientInfo;

    @TableField("ACCESS_IP")
    private String accessIp;

    @TableField("LOGIN_TIME")
    private LocalDateTime loginTime;

    @TableField("REMARK")
    private String remark;


}
