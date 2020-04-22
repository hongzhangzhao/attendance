package edu.zygxy.dao;

import edu.zygxy.pojo.Config;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liangjiateng on 2017/5/3.
 */
@Mapper
public interface ConfigMapper {

    Config getConfig();

    int deleteConfig();

    int insertConfig(Config config);
}
