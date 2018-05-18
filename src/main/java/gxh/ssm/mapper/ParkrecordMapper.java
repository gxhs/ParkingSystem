package gxh.ssm.mapper;

import gxh.ssm.po.Parkrecord;
import gxh.ssm.po.ParkrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkrecordMapper {
    int countByExample(ParkrecordExample example);

    int deleteByExample(ParkrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Parkrecord record);

    int insertSelective(Parkrecord record);

    List<Parkrecord> selectByExample(ParkrecordExample example);

    Parkrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Parkrecord record, @Param("example") ParkrecordExample example);

    int updateByExample(@Param("record") Parkrecord record, @Param("example") ParkrecordExample example);

    int updateByPrimaryKeySelective(Parkrecord record);

    int updateByPrimaryKey(Parkrecord record);
}