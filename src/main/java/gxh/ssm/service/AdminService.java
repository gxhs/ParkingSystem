package gxh.ssm.service;

import gxh.ssm.po.Admin;

import java.util.List;

public interface AdminService {
    Admin selectByExample(String example);
}
