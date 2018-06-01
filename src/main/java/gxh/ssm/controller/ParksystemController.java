package gxh.ssm.controller;

import gxh.ssm.po.Parksystem;
import gxh.ssm.service.ParksystemSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parksystem")
public class ParksystemController {

    @Autowired
    private ParksystemSevice parksystemService;

    //更新停车费率
    @RequestMapping("/update")
    public String updateByPrimaryKey(Parksystem record) {
        parksystemService.updateByPrimaryKey(record);
        return "redirect:/parksystem/select";
    }
    //查看停车费率
    @RequestMapping("/select")
    public String selectByPrimaryKey(Model model) {
        Parksystem parksystem = parksystemService.selectByPrimaryKey(1);
        model.addAttribute("parksystem", parksystem);
        return "parksystem";
    }
}
