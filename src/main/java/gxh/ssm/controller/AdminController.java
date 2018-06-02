package gxh.ssm.controller;

import gxh.ssm.po.Admin;
import gxh.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String findpswByNumber(HttpSession session, String name, String password) {
        Admin admin=adminService.selectByExample(name);
        if (admin.getName().equals(name)&&admin.getPassword().equals(password)) {
                session.setAttribute("adminName", name);
                //return "redirect:/operator/selectAll";
            return "adminHoutai";
            }
        return "index";
    }
}
