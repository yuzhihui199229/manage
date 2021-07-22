package com.huayun.cms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日期
     */
    @TableId("DATE")
    private String date;


}
