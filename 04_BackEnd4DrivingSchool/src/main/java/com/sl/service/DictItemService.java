package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.DictItem;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.DictItemVo;
import com.sl.pojo.vo.req.page.DictItemPageReqVo;

public interface DictItemService extends IService<DictItem> {
    PageVo<DictItemVo> list(DictItemPageReqVo pageReqVo);
}
