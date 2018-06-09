package gxh.ssm.service;

import gxh.ssm.po.Schoolcar;

import java.util.List;


public interface SchoolcarService {
    Schoolcar selectByExample(String example) throws Exception;
    void deleteByPrimaryKey(Integer id);
    void insert(Schoolcar record);
    void updateByPrimaryKey(Schoolcar record);
    List<Schoolcar> selectAll();
    Schoolcar selectByPrimaryKey(Integer id) throws Exception;
    Schoolcar selectByp(String p);
}
