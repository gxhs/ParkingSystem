package gxh.ssm.controller;

import gxh.ssm.plugin.params.PageParams;
import gxh.ssm.po.IdandTime;
import gxh.ssm.po.Parkrecord;
import gxh.ssm.po.Parksystem;
import gxh.ssm.po.Schoolcar;
import gxh.ssm.service.ParkrecordService;
import gxh.ssm.service.ParksystemSevice;
import gxh.ssm.service.SchoolcarService;
import gxh.ssm.view.ExcelExportService;
import gxh.ssm.view.ParkrecordExcleView;
import org.apache.ibatis.session.RowBounds;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
    @Autowired
    private ParksystemSevice parksystemSevice;

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
    public String InSchool(Model model, HttpServletRequest request, String platenumber) throws IOException {
        HttpSession session = request.getSession();
        Integer o_id = (Integer) session.getAttribute("opNumber");
        //获取当前时间
        Timestamp intime = new Timestamp(System.currentTimeMillis());
        Parkrecord parkrecord = new Parkrecord();
        parkrecord.setoId(o_id);
        parkrecord.setPlatenumber(platenumber);
        parkrecord.setIntime(intime);
        parkrecordService.insertSelective(parkrecord);
        List<Parkrecord> parkrecordList1 = parkrecordService.selectByExample(platenumber);
        System.out.println(parkrecordList1.size());
        model.addAttribute("parkrecordList1", parkrecordList1);
        return "rightTwo";
    }

    @RequestMapping("/outSchool")
    //车辆出校
    public String OutSchool(Model model, HttpServletRequest request, String platenumber) throws Exception {
        //时间
        Timestamp outtime = new Timestamp(System.currentTimeMillis());
        IdandTime idandTime = parkrecordId(platenumber);
        Date intime = idandTime.getTime();
        Integer id = idandTime.getId();
        int money;
        long temp = outtime.getTime() - intime.getTime();    //相差毫秒数
        long hours = temp / 1000 / 3600;                //相差小时数
        long temp2 = temp % (1000 * 3600);
        long mins = temp2 / 1000 / 60;                    //相差分钟数
        System.out.println(school(platenumber));
        String time = hours + "hour" + mins + "min";
        if (school(platenumber)) {
            money =0;
        } else {
            money =(int) (select() * (hours + 1));
        }
        System.out.println("金钱"+money);
        Parkrecord parkrecord = new Parkrecord();
        parkrecord.setId(id);
        parkrecord.setOuttime(outtime);
        parkrecord.setTime(time);
        parkrecord.setMoney(money);
        parkrecordService.updateByPrimaryKeySelective(parkrecord);
        List<Parkrecord> parkrecordList2 = parkrecordService.selectByExample(platenumber);
        model.addAttribute("parkrecordList2", parkrecordList2);
        return "rightThree";
    }

    //判断是否为校内车辆
    public boolean school(String platenumber) throws Exception {
        Schoolcar schoolcar=schoolcarService.selectByp(platenumber);
        if (schoolcar== null) {
            return false;
        } else
            return true;
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

    //获取停车费用
    public Double select() {
        Parksystem parksystem = parksystemSevice.selectByPrimaryKey(1);
        Double b = parksystem.getFeesscale();
        return b;
    }

    //增删改查
    //停车记录表
    @RequestMapping("/showAllList/{page}")
    public String showAllList(Model model, @PathVariable("page") int page) {
        //分页
        int size = 5;
        List<Parkrecord> parkrecordList = parkrecordService.selectAllListPage(page, size);
        PageParams pageParams = new PageParams();
        model.addAttribute("parkrecordList", parkrecordList);
        model.addAttribute("page", page);
        return "parkrecord";
    }

    @RequestMapping("/showAllListDelete")
    public String showAllListDelete(Model model) {
        List<Parkrecord> parkrecordList = parkrecordService.selectAllList();
        model.addAttribute("parkrecordList", parkrecordList);
        return "parkrecord";
    }

    //删除
    @RequestMapping("/deletedById")
    public String deletedById(Integer id) {
        parkrecordService.deleteByPrimaryKey(id);
        return "redirect:/ps/showAllListDelete.action";
    }

    //通过车牌查询
    @RequestMapping("/selectByPlatenumber")
    public String selectByPlatenumber(Model model, String platenumber) {
        List<Parkrecord> parkrecordList = parkrecordService.selectByExample(platenumber);
        model.addAttribute("parkrecordList", parkrecordList);
        return "parkrecord";
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView export() {
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //Excel视图，并设置自定义导出接口
        ParkrecordExcleView ev = new ParkrecordExcleView(exportService());
        //文件名
        ev.setFilename("停车记录.xls");
        //设置SQL后台参数
        Parkrecord parkrecord = new Parkrecord();
        //限制1万条
//        PageParams page = new PageParams();
//        page.setStart(0);
//        page.setLimit(10000);习近平新时代中国特色社会主义思想
//        roleParams.setPageParams(page);
        //查询
        List<Parkrecord> parkrecordList = parkrecordService.selectAllList();
        //加入数据模型
        mv.addObject("parkrecordList", parkrecordList);
        mv.setView(ev);
        return mv;
    }

    @SuppressWarnings({"unchecked"})
    private ExcelExportService exportService() {
        //使用Lambda表达式自定义导出excel规则
        return (Map<String, Object> model, Workbook workbook) -> {
            //获取用户列表
            List<Parkrecord> parkrecordList = (List<Parkrecord>) model.get("parkrecordList");
            //生成Sheet
            Sheet sheet = workbook.createSheet("停车记录");
            //加载标题
            Row title = sheet.createRow(0);
            title.createCell(0).setCellValue("编号");
            title.createCell(1).setCellValue("操作员");
            title.createCell(2).setCellValue("车牌号");
            title.createCell(3).setCellValue("入校时间");
            title.createCell(4).setCellValue("出校时间");
            title.createCell(5).setCellValue("停车时间");
            title.createCell(6).setCellValue("费用");
            //便利角色列表，生成一行行的数据
            for (int i = 0; i < parkrecordList.size(); i++) {
                Parkrecord parkrecord = parkrecordList.get(i);
                int rowIdx = i + 1;
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(parkrecord.getId());
                row.createCell(1).setCellValue(parkrecord.getoId());
                row.createCell(2).setCellValue(parkrecord.getPlatenumber());
                row.createCell(3).setCellValue(parkrecord.getIntime());
                row.createCell(4).setCellValue(parkrecord.getOuttime());
                row.createCell(5).setCellValue(parkrecord.getTime());
                row.createCell(6).setCellValue(parkrecord.getMoney());
            }
        };
    }
}
