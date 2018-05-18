package gxh.ssm.mapper;

import gxh.ssm.po.Parksystem;
import gxh.ssm.po.ParksystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParksystemMapper {
    int countByExample(ParksystemExample example);

    int deleteByExample(ParksystemExample example);

    int insert(Parksystem record);

    int insertSelective(Parksystem record);

    List<Parksystem> selectByExample(ParksystemExample example);

    int updateByExampleSelective(@Param("record") Parksystem record, @Param("example") ParksystemExample example);

    int updateByExample(@Param("record") Parksystem record, @Param("example") ParksystemExample example);
}