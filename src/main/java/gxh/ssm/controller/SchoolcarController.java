package gxh.ssm.controller;

import gxh.ssm.po.Schoolcar;
import gxh.ssm.service.SchoolcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Schoolcar")
public class SchoolcarController {
    @Autowired
    private SchoolcarService schoolcarService;

    private Schoolcar schoolcar;

    @RequestMapping("/selectByplatenumber")
    public Schoolcar selectByplatenumber(String platenumber) throws Exception {
        Schoolcar schoolcar= (Schoolcar) schoolcarService.selectByExample(platenumber);
        return schoolcar;
    }
   //增删改查
    @RequestMapping("selectAll")
    public String selectAll(Model model) throws Exception {
        List<Schoolcar>schoolcarList=schoolcarService.selectByExample(null);
        model.addAttribute("schoolcarList",schoolcarList);
        return "operator";
    }
    @RequestMapping("/insert")
    public void insert(Schoolcar schoolcar){
        schoolcarService.insert(schoolcar);
    }
    @RequestMapping("/delete")
    public void delete(Integer id){
        schoolcarService.deleteByPrimaryKey(id);

    }
    @RequestMapping("/update")
    public void update(Schoolcar schoolcar){
        schoolcarService.updateByPrimaryKey(schoolcar);
    }
}
