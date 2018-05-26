package gxh.ssm.mapper;

import gxh.ssm.plugin.params.PageParams;
import gxh.ssm.po.Parkrecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

public interface ParkrecordMapperCustom {
        List<Parkrecord> findListByintimeLike(String intime)throws Exception;
        List<Parkrecord> selectAllList();
        List<Parkrecord> selectAllList(@Param("pageParams") PageParams pageParams);
}
