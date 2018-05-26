package gxh.ssm.service.impl;

import gxh.ssm.mapper.ParkrecordMapper;
import gxh.ssm.mapper.ParkrecordMapperCustom;
import gxh.ssm.plugin.params.PageParams;
import gxh.ssm.po.Parkrecord;
import gxh.ssm.po.ParkrecordExample;
import gxh.ssm.service.ParkrecordService;
import org.apache.ibatis.session.RowBounds;
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

    //增删改查
    @Override
    public List<Parkrecord> selectAllList() {
        return parkrecordMapperCustom.selectAllList();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        parkrecordMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public List<Parkrecord> selectAllListPage(int page,int size) {
        PageParams pageParams = new PageParams();
        pageParams.setPage(page);
       return parkrecordMapperCustom.selectAllList(pageParams);
    }
}
