package edu.zygxy.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by guofumei on 2019/11/8.
 */
@Mapper
public interface SystemMapper {

    void initialization();

    void deleteDepartment();
    void deleteHoliday();
    void deleteSchedule();
    void deleteUser();
    void deleteWorkCheck();
    void backup();
}
