package com.huayun.cms.service;

import com.huayun.cms.entity.TbLoginInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-20
 */
public interface ITbLoginInfoService extends IService<TbLoginInfo> {
    List<TbLoginInfo> selectList(Map<String, Object> map);

    void  syncUserLoginInfo();
}
