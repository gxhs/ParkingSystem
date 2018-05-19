package gxh.ssm.service;

import gxh.ssm.po.Parksystem;

public interface ParksystemSevice {
    int updateByPrimaryKey(Parksystem record);
    Parksystem selectByPrimaryKey(Integer id);
}
