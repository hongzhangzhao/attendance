package edu.zygxy.web;

import edu.zygxy.permission.Role;
import edu.zygxy.pojo.JsonResponse;
import edu.zygxy.pojo.Schedule;
import edu.zygxy.pojo.UserVO;
import edu.zygxy.service.ScheduleService;
import edu.zygxy.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by guofumei on 2019/11/4.
 */
@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Role({"1", "2", "3", "4"})
    @RequestMapping(value = "/api/schedules/leave", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JsonResponse insertLeave(@RequestBody Schedule schedule) {
        scheduleService.insertLeave(schedule);
        return new JsonResponse(null);
    }

    @Role({"1", "2", "3", "4"})
    @RequestMapping(value = "/api/schedules/buzz", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JsonResponse insertBusinessTrip(@RequestBody Schedule schedule) {
        scheduleService.insertBuzz(schedule);
        return new JsonResponse(null);
    }

    @Role({"1", "2", "3"})
    @RequestMapping(value = "/api/schedules/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public JsonResponse deleteSchedule(@PathVariable long id) {
        scheduleService.deleteSchedule(id);
        return new JsonResponse(null);
    }

    @Role({"1", "2", "3"})
    @RequestMapping(value = "/api/schedules/accept/{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public JsonResponse acceptSchedule(@PathVariable long id) {
        scheduleService.acceptSchedule(id);
        return new JsonResponse(null);
    }

    @Role({"1", "2", "3"})
    @RequestMapping(value = "/api/schedules/reject/{id}/{rejectReason}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public JsonResponse rejectSchedule(@PathVariable long id, @PathVariable String rejectReason) {
        System.out.println("---58---: " + rejectReason);
        scheduleService.rejectScheduleNew(id, rejectReason);
        return new JsonResponse(null);
    }

    @RequestMapping("/leave")
    public String leave(ModelMap modelMap, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getAttribute("userInfo");
        if (userVO != null) {
            List<Schedule> leaves = scheduleService.listLeaves(userVO.getId());
            for (Schedule schedule : leaves) {
                if (schedule.getStatus() == 0) {
                    schedule.setStatusStr("审核中");
                } else if (schedule.getStatus() == -1) {
                    schedule.setStatusStr("未批准");
                } else if (schedule.getStatus() == 1) {
                    schedule.setStatusStr("已批准");
                }
                schedule.setStartStr(DateUtil.longToString(schedule.getStart().getTime()));
                schedule.setEndStr(DateUtil.longToString(schedule.getEnd().getTime()));
            }
            modelMap.addAttribute("leaves", leaves);
        }
        return "leave";
    }

    @RequestMapping("/buzz")
    public String buzz(ModelMap modelMap, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getAttribute("userInfo");
        if (userVO != null) {
            List<Schedule> leaves = scheduleService.listBuzzs(userVO.getId());
            for (Schedule schedule : leaves) {
                if (schedule.getStatus() == 0) {
                    schedule.setStatusStr("审核中");
                } else if (schedule.getStatus() == -1) {
                    schedule.setStatusStr("未批准");
                } else if (schedule.getStatus() == 1) {
                    schedule.setStatusStr("已批准");
                }
                schedule.setStartStr(DateUtil.longToString(schedule.getStart().getTime()));
                schedule.setEndStr(DateUtil.longToString(schedule.getEnd().getTime()));
            }
            modelMap.addAttribute("buzzs", leaves);
        }
        return "business_trip";
    }

    @RequestMapping("/leave/update")
    public String updateEmployee(@RequestParam long leaveId, ModelMap modelMap) {
        Schedule s = scheduleService.get(leaveId);
        modelMap.addAttribute("leave", s);
        return "leave_reason";
    }

    @RequestMapping("/leave/update/new")
    public String updateEmployeeNew(@RequestParam long leaveId, ModelMap modelMap) {
        Schedule s = scheduleService.get(leaveId);
        modelMap.addAttribute("leave", s);
        return "buzz_reason";
    }
}
