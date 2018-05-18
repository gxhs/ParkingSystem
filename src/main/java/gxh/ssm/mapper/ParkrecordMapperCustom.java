package gxh.ssm.mapper;

import gxh.ssm.po.Parkrecord;

import java.util.Date;
import java.util.List;

public interface ParkrecordMapperCustom {
        List<Parkrecord> findListByintimeLike(String intime)throws Exception;
        List<Parkrecord> selectAllList();
}
