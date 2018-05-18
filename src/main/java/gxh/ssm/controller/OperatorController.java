package gxh.ssm.controller;

import gxh.ssm.po.Operator;
import gxh.ssm.service.OperatorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    private OperatorService operatorService;

    private Operator operator;

    //登录验证密码
    @RequestMapping("/login")
    public String findpswByNumber(HttpSession session, Integer opNumber, String password) {
        Operator operator = operatorService.selectByPrimaryKey(opNumber);
        if (operator.getOpNumber().equals(opNumber) && operator.getPassword().equals(password)) {
            session.setAttribute("opNumber", opNumber);
            return "/houtai";
        }
        return "index";
    }

    //增删改查
    @RequestMapping("/selectAll")
    public String getAll(Model model) {
        List<Operator> operatorList = operatorService.select();
        model.addAttribute("operatorList", operatorList);
        return "operator";
    }

    @RequestMapping("/insert")
    public String insert(Operator operator) {
        operatorService.insert(operator);
        return "redirect:/operator/selectAll";
    }
    @RequestMapping("/delete")
    public String delete(Integer id) {
        operatorService.deleteByPrimaryKey(id);
        return "redirect:/operator/selectAll";
    }

    @RequestMapping("/update")
    public String update(Operator operator) {
        //System.out.println(111111);
        operatorService.updateByPrimaryKey(operator);
        return "redirect:/operator/selectAll";
    }

    @RequestMapping("selectByNumber")
    public String selectByNumber(Model model,
                                 @RequestParam(value = "id", required = true) Integer opNumber) {
        // System.out.println(opNumber);
        Operator operator = operatorService.selectByPrimaryKey(opNumber);
        model.addAttribute("operator", operator);
        return "updateOperator";
    }

}

