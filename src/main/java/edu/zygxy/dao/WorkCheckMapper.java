package edu.zygxy.dao;

import edu.zygxy.pojo.WorkCheck;
import edu.zygxy.pojo.WorkCheckNew;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by guofumei on 2019/11/4.
 */
@Mapper
public interface WorkCheckMapper {

    int insertWorkCheck(WorkCheck workCheck);

    int updateWorkCheckEndCheck(@Param("userId") long userId, @Param("workTime") double workTime);

    List<WorkCheck> listWorkChecksByUserId(long userId);

    List<WorkCheck> listWorkChecks();

    List<WorkCheckNew> getAll();

    WorkCheck getWorkCheckByUserIdAndTime(long userId);
}
