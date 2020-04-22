package edu.zygxy.dao;

import edu.zygxy.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liangjiateng on 2017/5/4.
 */
@Mapper
public interface ScheduleMapper {

    List<Schedule> listSchedulesByUserIdAndType(@Param("userId") long userId, @Param("type") int type);

    List<Schedule> listShcedulesByType(int type);

    int insertSchedule(Schedule schedule);

    int deleteSchedule(long id);

    int updateScheduleStatus(@Param("id") long id, @Param("status") int status);

    Schedule selectById(long id);
}
