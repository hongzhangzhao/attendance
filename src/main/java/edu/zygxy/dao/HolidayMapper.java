package edu.zygxy.dao;

import edu.zygxy.pojo.Holiday;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Created by guofumei on 2019/11/11.
 */
@Mapper
public interface HolidayMapper {

    List<Holiday> listHolidays();

    Holiday getHolidayById(long id);

    int insertHoliday(Holiday holiday);

    int deleteHolidayById(long id);
}
