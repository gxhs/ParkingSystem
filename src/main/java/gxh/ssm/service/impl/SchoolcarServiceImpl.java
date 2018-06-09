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
    public Schoolcar selectByExample(String example)throws Exception {
        SchoolcarExample schoolcarExample=new SchoolcarExample();
        SchoolcarExample.Criteria criteria=schoolcarExample.createCriteria();
        criteria.andPlatenumberEqualTo("example");
        Schoolcar schoolcar=schoolcarMapper.selectByExample(schoolcarExample);
        System.out.println(schoolcar.getPlatenumber());
        return schoolcar;
    }

    @Override
    public Schoolcar selectByp(String p) {
        Schoolcar schoolcar=schoolcarMapper.selectByp(p);
//        System.out.println(schoolcar.getPlatenumber());
        return schoolcar;
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
