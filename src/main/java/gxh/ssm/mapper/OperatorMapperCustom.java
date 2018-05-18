package gxh.ssm.mapper;

import gxh.ssm.po.Operator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperatorMapperCustom {
    List<Operator> getAll();
//    void delete(Integer op_number);
//    void update(@Param("op_number") Integer op_number,
//                @Param("password") String password);
//    void insert(Operator operator);
}
