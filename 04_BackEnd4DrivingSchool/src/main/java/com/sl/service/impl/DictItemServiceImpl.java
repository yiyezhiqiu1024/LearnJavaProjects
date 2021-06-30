package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpPage;
import com.sl.common.enhance.MpLambdaQueryWrapper;
import com.sl.common.mapStruct.MapStructs;
import com.sl.mapper.DictItemMapper;
import com.sl.pojo.po.DictItem;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.DictItemVo;
import com.sl.pojo.vo.req.page.DictItemPageReqVo;
import com.sl.service.DictItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<DictItemVo> list(DictItemPageReqVo pageReqVo) {
        // 查询条件
        MpLambdaQueryWrapper<DictItem> queryWrapper = new MpLambdaQueryWrapper<>();
        // 关键字
        queryWrapper.like(pageReqVo.getKeyword(), DictItem::getName, DictItem::getValue);
        Integer typeId = pageReqVo.getTypeId();
        if (typeId != null && typeId > 0) {
            queryWrapper.eq(DictItem::getTypeId, typeId);
        }
        // 按照id降序
        queryWrapper.orderByDesc(DictItem::getId);
        // 分页查询
        return baseMapper.selectPage(new MpPage<>(pageReqVo), queryWrapper).buildVo(MapStructs.INSTANCE::po2vo);
    }

}
