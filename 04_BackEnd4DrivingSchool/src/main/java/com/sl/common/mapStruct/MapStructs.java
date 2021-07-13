package com.sl.common.mapStruct;

import com.sl.pojo.po.*;
import com.sl.pojo.vo.LoginVo;
import com.sl.pojo.vo.list.*;
import com.sl.pojo.vo.req.save.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * ReqVo -> Po
 * Po    -> Vo
 */
@Mapper(uses = {
        MapStructFormatter.class
})
public interface MapStructs {
    MapStructs INSTANCE = Mappers.getMapper(MapStructs.class);

     DictItem reqVo2po(DictItemReqVo reqVo);
     DictType reqVo2po(DictTypeReqVo reqVo);
     PlateRegion reqVo2po(PlateRegionReqVo reqVo);
     ExamPlace reqVo2po(ExamPlaceReqVo reqVo);
     ExamPlaceCourse reqVo2po(ExamPlaceCourseReqVo reqVo);
     SysRole reqVo2po(SysRoleReqVo reqVo);
     SysUser reqVo2po(SysUserReqVo reqVo);

     DictItemVo po2vo(DictItem po);
     DictTypeVo po2vo(DictType po);
     PlateRegionVo po2vo(PlateRegion po);
     ExamPlaceVo po2vo(ExamPlace po);
     SysRoleVo po2vo(SysRole po);
     @Mapping(
             source = "loginTime",
             target = "loginTime",
             qualifiedBy = MapStructFormatter.Date2Millis.class
     )
     SysUserVo po2vo(SysUser po);
     LoginVo po2loginVo(SysUser po);
}
