package edu.zygxy.service;

import edu.zygxy.pojo.Schedule;

import java.util.List;

/**
 * Created by liangjiateng on 2017/5/4.
 */
public interface ScheduleService {

    void insertLeave(Schedule schedule);

    void insertBuzz(Schedule schedule);

    void deleteSchedule(long id);

    List<Schedule> listLeaves(long userId);

    List<Schedule> listLeaves();

    List<Schedule> listBuzzs(long userId);

    List<Schedule> listBuzzs();

    void acceptSchedule(long id);

    void rejectSchedule(long id);

    void rejectScheduleNew(long id, String rejectReason);

    Schedule get(long id);
}
