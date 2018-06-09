package gxh.ssm.mapper;

import gxh.ssm.po.Schoolcar;
import gxh.ssm.po.SchoolcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolcarMapper {
    int countByExample(SchoolcarExample example);

    int deleteByExample(SchoolcarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Schoolcar record);

    int insertSelective(Schoolcar record);

    Schoolcar selectByExample(SchoolcarExample example);

    Schoolcar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Schoolcar record, @Param("example") SchoolcarExample example);

    int updateByExample(@Param("record") Schoolcar record, @Param("example") SchoolcarExample example);

    int updateByPrimaryKeySelective(Schoolcar record);

    int updateByPrimaryKey(Schoolcar record);

    List<Schoolcar> selectAll();
     Schoolcar selectByp(String p);
}