package edu.zygxy.web;

import edu.zygxy.pojo.*;
import edu.zygxy.service.ScheduleService;
import edu.zygxy.service.UserService;
import edu.zygxy.service.WorkService;
import edu.zygxy.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Created by guofumei on 2019/11/5.
 */
@Controller
public class StatController {

    @Autowired
    private WorkService workService;
    @Autowired
    private UserService userService;
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/stat")
    public String stat(HttpServletRequest request, ModelMap modelMap) {

        List<WorkCheck> workChecks = workService.listWorkChecks();
        for (WorkCheck workCheck : workChecks) {
            workCheck.setTimeStr(DateUtil.longToString2(workCheck.getTime().getTime()));
            workCheck.setStartCheckStr(workCheck.getStartCheck().toString());
            if (workCheck.getEndCheck() != null)
                workCheck.setEndCheckStr(workCheck.getEndCheck().toString());
            else
                workCheck.setEndCheckStr("");
            if (workCheck.getType() == 0) {
                workCheck.setTypeStr("节假日");
            } else {
                workCheck.setTypeStr("工作日");
            }
            String remark1 = "";
            String remark2 = "";
            String remark3 = "";
            if (workCheck.getStartCheck().getTime() > workCheck.getStart().getTime()) {
                remark1 = "迟到";
            }
            if (workCheck.getEndCheck().getTime() < workCheck.getEnd().getTime()) {
                remark2 = "早退";
            }
            if (workCheck.getEndCheck().getTime() > workCheck.getEnd().getTime()) {
                remark2 = "加班";
            }
            workCheck.setRemark(remark1 + remark2 + remark3);
            if (userService.getUserById(workCheck.getUserId()) != null)
                workCheck.setName(userService.getUserById(workCheck.getUserId()).getName());
        }

        List<Schedule> leaves = scheduleService.listLeaves();
        for (Schedule schedule : leaves) {
            if (schedule.getStatus() == 0) {
                schedule.setStatusStr("审核中");
            } else if (schedule.getStatus() == -1) {
                schedule.setStatusStr("未批准");
            } else if (schedule.getStatus() == 1) {
                schedule.setStatusStr("已批准");
            }
            if (userService.getUserById(schedule.getUserId()) != null)
                schedule.setName(userService.getUserById(schedule.getUserId()).getName());
            schedule.setStartStr(DateUtil.longToString(schedule.getStart().getTime()));
            schedule.setEndStr(DateUtil.longToString(schedule.getEnd().getTime()));
        }
        modelMap.addAttribute("leaves", leaves);

        List<Schedule> buzzs = scheduleService.listBuzzs();
        for (Schedule schedule : buzzs) {
            if (schedule.getStatus() == 0) {
                schedule.setStatusStr("审核中");
            } else if (schedule.getStatus() == -1) {
                schedule.setStatusStr("未批准");
            } else if (schedule.getStatus() == 1) {
                schedule.setStatusStr("已批准");
            }
            schedule.setStartStr(DateUtil.longToString(schedule.getStart().getTime()));
            schedule.setEndStr(DateUtil.longToString(schedule.getEnd().getTime()));
            if (userService.getUserById(schedule.getUserId()) != null)
                schedule.setName(userService.getUserById(schedule.getUserId()).getName());
        }
        modelMap.addAttribute("buzzs", buzzs);

        List<User> users = userService.listUsers();
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("works", workChecks);

        return "stat";
    }

    @RequestMapping("/attendance/export")
    public JsonResponse export(HttpServletResponse response) throws IOException {
        List<WorkCheck> wcs = workService.listWorkChecks();
        List<String> list = new ArrayList<>();
        String tou = "日期,姓名,类型,上班时间,下班时间,工作时长,备注";
        list.add(tou);
        if (wcs != null && !wcs.isEmpty()) {
            for (WorkCheck workCheck : wcs) {

                workCheck.setTimeStr(DateUtil.longToString2(workCheck.getTime().getTime()));
                workCheck.setStartCheckStr(workCheck.getStartCheck().toString());
                if (workCheck.getEndCheck() != null)
                    workCheck.setEndCheckStr(workCheck.getEndCheck().toString());
                else
                    workCheck.setEndCheckStr("");
                if (workCheck.getType() == 0) {
                    workCheck.setTypeStr("节假日");
                } else {
                    workCheck.setTypeStr("工作日");
                }
                String remark1 = "";
                String remark2 = "";
                String remark3 = "";
                if (workCheck.getStartCheck().getTime() > workCheck.getStart().getTime()) {
                    remark1 = "迟到";
                }
                if (workCheck.getEndCheck().getTime() < workCheck.getEnd().getTime()) {
                    remark2 = "早退";
                }
                if (workCheck.getEndCheck().getTime() > workCheck.getEnd().getTime()) {
                    remark3 = "加班";
                }
                workCheck.setRemark(remark1 + remark2);
                if (userService.getUserById(workCheck.getUserId()) != null)
                    workCheck.setName(userService.getUserById(workCheck.getUserId()).getName());

                String row = workCheck.getTimeStr() + "," + workCheck.getName() + "," + workCheck.getTypeStr() +
                        "," + workCheck.getStartCheckStr() + "," + workCheck.getEndCheckStr() + "," + workCheck.getWorkTime() +
                        "," + workCheck.getRemark();
                list.add(row);
            }
        }
        String r = String.join("\n", list);
        String path = "C:\\tmp\\xxx.csv";
        FileUtils.write(new File(path), r, "gbk");

        File file = new File(path);
        if (file.exists()) {
            response.setContentType("application/force-download");  // 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + file.getName());  // 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("success");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return null;
    }
}
