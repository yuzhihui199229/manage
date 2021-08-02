package com.huayun.cms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-07-27
 */
@Data
public class TbDataSync implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 解码系统名
     */
    @TableId("SYS_NAME")
    private String sysName;

    /**
     * 机房
     */
    @TableField("CENTER")
    private String center;

    /**
     * 同步日期yyyy-mm-dd
     */
    @TableField("SYNC_DATE")
    private String syncDate;

    /**
     * 同步时间HH:MM:SS
     */
    @TableField("SYNC_TIME")
    private String syncTime;

    /**
     * 同步数据库用户
     */
    @TableField("DB_USER")
    private String dbUser;

    /**
     * 同步数据库密码
     */
    @TableField("DB_PWD")
    private String dbPwd;

    /**
     * 数据库连接
     */
    @TableField("DB_CONN")
    private String dbConn;

    /**
     * 数据库连接
     */
    @TableField("DRIVER")
    private String driver;


}
