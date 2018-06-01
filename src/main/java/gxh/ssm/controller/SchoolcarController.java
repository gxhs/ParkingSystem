package gxh.ssm.controller;


import gxh.ssm.po.Schoolcar;
import gxh.ssm.service.SchoolcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/schoolcar")
public class SchoolcarController {
    @Autowired
    private SchoolcarService schoolcarService;

    private Schoolcar schoolcar;

//    public Schoolcar selectSchoolcar(Model model, Integer id) throws Exception {
//        Schoolcar schoolcar = schoolcarService.selectByPrimaryKey(id);
//        System.out.println(schoolcar.getId());
//        System.out.println(schoolcar.getName());
//        System.out.println(schoolcar.getPlatenumber());
//        return schoolcar;
//    }

    @RequestMapping("/selectByid")
    public String selectByplatenumber(Model model, Integer id) throws Exception {
        Schoolcar schoolcar = schoolcarService.selectByPrimaryKey(id);
        System.out.println(schoolcar.getId());
        System.out.println(schoolcar.getName());
        System.out.println(schoolcar.getPlatenumber());
        model.addAttribute("schoolcar1", schoolcar);
        return "updateSchoolcar";
    }

    //增删改查
    @RequestMapping("selectAll")
    public String selectAll(Model model) throws Exception {
        List<Schoolcar> schoolcarList = schoolcarService.selectAll();
        model.addAttribute("schoolcarList", schoolcarList);
        return "schoolcar";
    }
    @RequestMapping("/insert")
    public String insert(Schoolcar schoolcar) {
        schoolcarService.insert(schoolcar);
        return "redirect:/schoolcar/selectAll";
    }
    @RequestMapping("/delete")
    public String delete(Integer id) {
        schoolcarService.deleteByPrimaryKey(id);
        return "redirect:/schoolcar/selectAll";
    }
    @RequestMapping("/update")
    public String update(Schoolcar schoolcar) {
        schoolcarService.updateByPrimaryKey(schoolcar);
        return "redirect:/schoolcar/selectAll";
    }
}
