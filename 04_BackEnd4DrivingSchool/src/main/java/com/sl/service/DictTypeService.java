package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.DictType;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.DictTypeVo;
import com.sl.pojo.vo.req.page.DictTypePageReqVo;

public interface DictTypeService extends IService<DictType> {
    PageVo<DictTypeVo> list(DictTypePageReqVo reqVo);
}
