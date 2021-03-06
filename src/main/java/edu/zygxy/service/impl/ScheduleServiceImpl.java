package edu.zygxy.service.impl;

import edu.zygxy.dao.ScheduleMapper;
import edu.zygxy.pojo.Schedule;
import edu.zygxy.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guofumei on 2019/11/4.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public void insertLeave(Schedule schedule) {
        if (schedule != null) {
            schedule.setType(0);
            scheduleMapper.insertSchedule(schedule);
        }
    }

    @Override
    public void insertBuzz(Schedule schedule) {
        if (schedule != null) {
            schedule.setType(1);
            scheduleMapper.insertSchedule(schedule);
        }
    }

    @Override
    public void deleteSchedule(long id) {
        scheduleMapper.deleteSchedule(id);
    }

    @Override
    public List<Schedule> listLeaves(long userId) {
        return scheduleMapper.listSchedulesByUserIdAndType(userId,0);
    }

    @Override
    public List<Schedule> listLeaves() {
        return scheduleMapper.listShcedulesByType(0);
    }

    @Override
    public List<Schedule> listLeavesNew(long roleId) {
        if (roleId == 2) {
            return scheduleMapper.listShcedulesByType(0);
        }
        return scheduleMapper.listShcedulesByTypeNew(0, roleId);
    }

    @Override
    public List<Schedule> listBuzzsNew(long roleId) {
        if (roleId == 2) {
            return scheduleMapper.listShcedulesByType(1);
        }
        return scheduleMapper.listShcedulesByTypeNew(1, roleId);
    }

    @Override
    public List<Schedule> listBuzzs(long userId) {
        return scheduleMapper.listSchedulesByUserIdAndType(userId,1);
    }

    @Override
    public List<Schedule> listBuzzs() {
        return scheduleMapper.listShcedulesByType(1);
    }

    @Override
    public void acceptSchedule(long id) {
        scheduleMapper.updateScheduleStatus(id,1);
    }

    @Override
    public void rejectSchedule(long id) {
        scheduleMapper.updateScheduleStatus(id,-1);
    }

    @Override
    public void rejectScheduleNew(long id, String rejectReason) {
        scheduleMapper.updateScheduleStatusNew(id, rejectReason, -1);
    }

    @Override
    public Schedule get(long id) {
        return scheduleMapper.selectById(id);
    }

    @Override
    public List<Schedule> selectByDate(String createTime, long userId) {
        return scheduleMapper.selectByDate(createTime, userId);
    }
}
