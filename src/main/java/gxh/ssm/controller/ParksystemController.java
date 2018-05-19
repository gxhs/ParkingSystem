package gxh.ssm.controller;

import gxh.ssm.po.Parksystem;
import gxh.ssm.service.ParksystemSevice;
import org.springframework.beans.factory.annotation.Autowired;

public class ParksystemController {

    @Autowired
    private  ParksystemSevice parksystemService;

   public void updateByPrimaryKey(Parksystem record){
        parksystemService.updateByPrimaryKey(record);
    }
    public Parksystem selectByPrimaryKey(){
        Parksystem parksystem =parksystemService.selectByPrimaryKey(1);
        return parksystem;
    }
}
