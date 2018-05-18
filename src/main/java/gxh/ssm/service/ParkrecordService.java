package gxh.ssm.service;

import gxh.ssm.po.Parkrecord;
import gxh.ssm.po.ParkrecordExample;

import java.util.Date;
import java.util.List;

public interface ParkrecordService {
    int insertSelective(Parkrecord record);
    int updateByPrimaryKeySelective(Parkrecord record);
    List<Parkrecord> selectByExample(String example);
    List<Parkrecord> findListByintimeLike(String intime) throws Exception;
    List<Parkrecord> selectAllList();
}
