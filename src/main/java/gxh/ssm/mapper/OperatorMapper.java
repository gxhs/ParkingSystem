package gxh.ssm.mapper;

import gxh.ssm.po.Operator;
import gxh.ssm.po.OperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperatorMapper {
    int countByExample(OperatorExample example);

    int deleteByExample(OperatorExample example);

    int deleteByPrimaryKey(Integer opNumber);

    int insert(Operator record);

    int insertSelective(Operator record);

    List<Operator> selectByExample(OperatorExample example);

    Operator selectByPrimaryKey(Integer opNumber);

    int updateByExampleSelective(@Param("record") Operator record, @Param("example") OperatorExample example);

    int updateByExample(@Param("record") Operator record, @Param("example") OperatorExample example);

    int updateByPrimaryKeySelective(Operator record);

    int updateByPrimaryKey(Operator record);
}