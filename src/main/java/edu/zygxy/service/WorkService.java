package edu.zygxy.service;

import edu.zygxy.pojo.Config;
import edu.zygxy.pojo.Holiday;
import edu.zygxy.pojo.WorkCheck;
import edu.zygxy.pojo.WorkCheckNew;

import java.util.List;

/**
 * Created by guofumei on 2019/11/3.
 */
public interface WorkService {

    Holiday getHolidayById(long id);

    List<Holiday> listHolidays();

    void insertHoliday(Holiday holiday);

    void deleteHolidayById(long id);

    void insertConfig(Config config);

    Config getConfig();

    boolean insertWorkCheck(WorkCheck workCheck);

    boolean updateEndCheck(long userId);

    List<WorkCheck> listWorkChecksByUserId(long userId);

    List<WorkCheck> listWorkChecks();

    List<WorkCheckNew> getAll();
}
