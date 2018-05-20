package gxh.ssm.service.impl;

import gxh.ssm.mapper.SchoolcarMapper;
import gxh.ssm.po.Schoolcar;
import gxh.ssm.po.SchoolcarExample;
import gxh.ssm.service.SchoolcarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SchoolcarServiceImpl implements SchoolcarService {

    @Autowired
    private SchoolcarMapper schoolcarMapper;

    @Override
    public Schoolcar selectByPrimaryKey(Integer id) throws Exception {
        Schoolcar schoolcar=schoolcarMapper.selectByPrimaryKey(id);
        return schoolcar;
    }

    @Override
    public List<Schoolcar> selectByExample(String example)throws Exception {
        SchoolcarExample schoolcarExample=new SchoolcarExample();
        SchoolcarExample.Criteria criteria=schoolcarExample.createCriteria();
        criteria.andPlatenumberEqualTo("example");
        return  schoolcarMapper.selectByExample(schoolcarExample);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        schoolcarMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void insert(Schoolcar record) {
        schoolcarMapper.insert(record);
        
    }

    @Override
    public void updateByPrimaryKey(Schoolcar record) {
        schoolcarMapper.updateByPrimaryKey(record);
        
    }

    @Override
    public List<Schoolcar> selectAll() {
        List<Schoolcar> schoolcarList=schoolcarMapper.selectAll();
        return schoolcarList;
    }
}
