package gxh.ssm.service;

import gxh.ssm.po.Operator;
import gxh.ssm.po.OperatorExample;

import java.util.List;

public interface OperatorService {
    Operator selectByPrimaryKey(Integer opNumber);
    List<Operator> select();
    int deleteByPrimaryKey(Integer id);
    int insert(Operator record);
    int updateByPrimaryKey(Operator record);
}
