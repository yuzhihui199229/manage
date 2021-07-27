package com.huayun.cms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuzh
 * @since 2021-07-21
 */
@Data
public class TbSysUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @TableId("USER_NAME")
    private String userName;

    /**
     * 用户密码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @TableField("USER_PASSWORD")
    private String userPassword;

    /**
     * 0-管理员，1-操作员
     */
    @TableField("USER_ROLE")
    private Integer userRole;
}
