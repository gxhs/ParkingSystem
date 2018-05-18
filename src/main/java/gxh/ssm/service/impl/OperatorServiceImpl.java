package gxh.ssm.service.impl;


import gxh.ssm.mapper.OperatorMapper;
import gxh.ssm.mapper.OperatorMapperCustom;
import gxh.ssm.po.Operator;
import gxh.ssm.po.OperatorExample;
import gxh.ssm.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;
    @Autowired
    private OperatorMapperCustom operatorMapperCustom;

    @Override
    public Operator selectByPrimaryKey(Integer opNumber) {
        Operator operator=operatorMapper.selectByPrimaryKey(opNumber);
        return operator;
    }

    @Override
    public List<Operator> select() {
        List<Operator> operatorList=operatorMapperCustom.getAll();
        return operatorList;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        operatorMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(Operator record) {
        operatorMapper.insert(record);
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Operator record) {
        operatorMapper.updateByPrimaryKey(record);
        return 0;
    }
}
