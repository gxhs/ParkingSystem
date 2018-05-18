package gxh.ssm.controller;

import gxh.ssm.po.IdandTime;
import gxh.ssm.po.Parkrecord;
import gxh.ssm.service.ParkrecordService;
import gxh.ssm.service.SchoolcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/ps")
public class ParkrecordController {

    @Autowired
    private ParkrecordService parkrecordService;
    @Autowired
    private SchoolcarService schoolcarService;

    private SchoolcarController schoolcarController;

    @RequestMapping("/showListByintime")
    public String parkrecordShowList(Model model) throws Exception {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // System.out.println(sdf.format(date));
        List<Parkrecord> parkrecordList = parkrecordService.findListByintimeLike(sdf.format(date));
        System.out.println(parkrecordList);
        model.addAttribute("parkrecordList", parkrecordList);
        return "/right";
    }
    @RequestMapping("/inSchool")
    //车辆入校
    public String InSchool(HttpServletRequest request, String platenumber) {
        HttpSession session = request.getSession();
        Integer o_id = (Integer) session.getAttribute("opNumber");
        //获取当前时间
        Timestamp intime = new Timestamp(System.currentTimeMillis());

        Parkrecord parkrecord = new Parkrecord();

        parkrecord.setoId(o_id);
        parkrecord.setPlatenumber(platenumber);
        parkrecord.setIntime(intime);
        parkrecordService.insertSelective(parkrecord);
        return "redirect:showListByintime.action";
    }

    @RequestMapping("/outSchool")
    //车辆出校
    public String OutSchool(HttpServletRequest request, String platenumber) throws Exception {
        //时间
        Timestamp outtime = new Timestamp(System.currentTimeMillis());
        IdandTime idandTime = parkrecordId(platenumber);
        Date intime = idandTime.getTime();
        Integer id = idandTime.getId();
//       System.out.println(intime);
        int money;
        long temp = outtime.getTime() - intime.getTime();    //相差毫秒数
        long hours = temp / 1000 / 3600;                //相差小时数
        long temp2 = temp % (1000 * 3600);
        long mins = temp2 / 1000 / 60;                    //相差分钟数
        String time = hours + "小时" + mins + "分钟";
//       System.out.println("小时"+hours);
        if (school(platenumber)) {
            money = (int) (2 * (hours + 1));
        } else {
            money = 0;
        }
        //System.out.println(money);
        Parkrecord parkrecord = new Parkrecord();
        parkrecord.setId(id);
        parkrecord.setOuttime(outtime);
        parkrecord.setTime(time);
        parkrecord.setMoney(money);
        parkrecordService.updateByPrimaryKeySelective(parkrecord);
        return "redirect:showListByintime.action";
    }

    //判断是否为校内车辆
    public boolean school(String platenumber) throws Exception {
        if (schoolcarService.selectByExample(platenumber) != null) {
            return true;
        } else
            return false;
    }

    //获取进入校园的车辆的id和进入时间
    public IdandTime parkrecordId(String platenumber) {
        IdandTime idandTime = new IdandTime();
        Map<Date, Integer> map = new HashMap<Date, Integer>();
        List<Parkrecord> parkrecordList = parkrecordService.selectByExample(platenumber);
        System.out.println("----------" + parkrecordList);
        for (Parkrecord parkrecord : parkrecordList) {
            if (parkrecord.getOuttime() == null) {
                Date inttime = parkrecord.getIntime();
                Integer id = parkrecord.getId();
                idandTime.setTime(inttime);
                idandTime.setId(id);
            }
        }
        return idandTime;
    }

    //增删改查
    //停车记录表
    @RequestMapping("/showAllList")
    public String showAllList(Model model) {
        List<Parkrecord> parkrecordAllList = parkrecordService.selectAllList();
        model.addAttribute("parkrecordAllList", parkrecordAllList);
        return "AdminShow";
    }
    //删除
    public void deletedById(Integer id) {
    }

    //通过车牌查询
    public List<Parkrecord> selectByPlatenumber(String platenumber) {
        return null;
    }
}
