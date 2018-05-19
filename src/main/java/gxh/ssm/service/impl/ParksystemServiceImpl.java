package gxh.ssm.service.impl;

import gxh.ssm.mapper.ParkrecordMapper;
import gxh.ssm.mapper.ParksystemMapper;
import gxh.ssm.po.Parksystem;
import gxh.ssm.service.ParksystemSevice;
import org.springframework.beans.factory.annotation.Autowired;

public class ParksystemServiceImpl implements ParksystemSevice {

    @Autowired
    ParksystemMapper parksystemMapper;
    @Override
    public int updateByPrimaryKey(Parksystem record) {
        parksystemMapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public Parksystem selectByPrimaryKey(Integer id) {
        Parksystem parksystem=parksystemMapper.selectByPrimaryKey(id);
        return parksystem;
    }
}
