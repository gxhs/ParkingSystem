package gxh.ssm.service.impl;

import gxh.ssm.mapper.ParkrecordMapper;
import gxh.ssm.mapper.ParkrecordMapperCustom;
import gxh.ssm.po.Parkrecord;
import gxh.ssm.po.ParkrecordExample;
import gxh.ssm.service.ParkrecordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ParkrecordServiceImpl implements ParkrecordService {
    @Autowired
   private ParkrecordMapper parkrecordMapper;
    @Autowired
    private ParkrecordMapperCustom parkrecordMapperCustom;

    @Override
    public int insertSelective(Parkrecord record) {
        parkrecordMapper.insertSelective(record);
        return 0;
    }
    @Override
    public List<Parkrecord> selectByExample(String example) {
        ParkrecordExample parkrecordExample=new ParkrecordExample();
        ParkrecordExample.Criteria criteria=parkrecordExample.createCriteria();
        criteria.andPlatenumberEqualTo(example);
        return parkrecordMapper.selectByExample(parkrecordExample);
    }

    @Override
    public int updateByPrimaryKeySelective(Parkrecord record) {
        parkrecordMapper.updateByPrimaryKeySelective(record);
        return 0;
    }

    @Override
    public List<Parkrecord> findListByintimeLike(String intime)throws Exception {
        return parkrecordMapperCustom.findListByintimeLike(intime);
    }
    @Override
    public List<Parkrecord> selectAllList() {
        return parkrecordMapperCustom.selectAllList();
    }
}
