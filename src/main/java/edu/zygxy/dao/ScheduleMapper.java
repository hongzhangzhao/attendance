package edu.zygxy.dao;

import edu.zygxy.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by guofumei on 2019/11/4.
 */
@Mapper
public interface ScheduleMapper {

    List<Schedule> listSchedulesByUserIdAndType(@Param("userId") long userId, @Param("type") int type);

    List<Schedule> listShcedulesByType(int type);

    int insertSchedule(Schedule schedule);

    int deleteSchedule(long id);

    int updateScheduleStatus(@Param("id") long id, @Param("status") int status);

    int updateScheduleStatusNew(@Param("id") long id, @Param("rejectReason") String rejectReason, @Param("status") int status);

    Schedule selectById(long id);

    List<Schedule> selectByDate(@Param("createTime") String createTime, @Param("userId") long userId);
}
