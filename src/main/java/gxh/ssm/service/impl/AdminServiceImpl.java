package gxh.ssm.service.impl;

import gxh.ssm.mapper.AdminMapper;
import gxh.ssm.po.Admin;
import gxh.ssm.po.AdminExample;
import gxh.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin selectByExample(String example) {
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria=adminExample.createCriteria();
        criteria.andNameEqualTo(example);
        return adminMapper.selectByExample(adminExample);
    }
}
