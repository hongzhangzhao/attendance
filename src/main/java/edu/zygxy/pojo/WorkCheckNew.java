package edu.zygxy.pojo;

import java.sql.Time;
import java.sql.Timestamp;

public class WorkCheckNew {
    private Long id;
    private Timestamp time;
    private Integer type; //0假期 1工作日 2出差 3请假
    private Time start;
    private Time end;
    private Time startCheck;
    private Time endCheck;
    private Integer workTime;
    private String remark;
    private Long userId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String name;
    private Integer status;
    private Integer scheduleType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Time getStartCheck() {
        return startCheck;
    }

    public void setStartCheck(Time startCheck) {
        this.startCheck = startCheck;
    }

    public Time getEndCheck() {
        return endCheck;
    }

    public void setEndCheck(Time endCheck) {
        this.endCheck = endCheck;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(Integer scheduleType) {
        this.scheduleType = scheduleType;
    }
}
