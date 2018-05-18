package gxh.ssm.service;

import gxh.ssm.po.Schoolcar;
import gxh.ssm.po.SchoolcarExample;

import java.util.List;


public interface SchoolcarService {
    List<Schoolcar> selectByExample(String example) throws Exception;
    void deleteByPrimaryKey(Integer id);
    void insert(Schoolcar record);
    void updateByPrimaryKey(Schoolcar record);
    List<Schoolcar> selectAll();
}
