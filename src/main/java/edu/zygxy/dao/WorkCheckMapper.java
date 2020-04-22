package edu.zygxy.dao;

import edu.zygxy.pojo.WorkCheck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liangjiateng on 2017/5/4.
 */
@Mapper
public interface WorkCheckMapper {

    int insertWorkCheck(WorkCheck workCheck);

    int updateWorkCheckEndCheck(@Param("userId") long userId, @Param("workTime") double workTime);

    List<WorkCheck> listWorkChecksByUserId(long userId);

    List<WorkCheck> listWorkChecks();

    WorkCheck getWorkCheckByUserIdAndTime(long userId);
}
