package edu.zygxy.dao;

import edu.zygxy.pojo.Config;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by guofumei on 2019/11/3.
 */
@Mapper
public interface ConfigMapper {

    Config getConfig();

    int deleteConfig();

    int insertConfig(Config config);
}
