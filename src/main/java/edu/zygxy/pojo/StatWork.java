package edu.zygxy.pojo;

public class StatWork {

    private long id;

    private String time;  // 日期 yy-mm-dd

    private String name;  // 姓名

    private int workDay;  // 出勤

    private int leaveDay;  // 请假

    private int businessDay;  // 出差

    private int overtimeDay;  // 加班

    private int overtime;

    private int lateDay;  // 迟到

    private int earlyDay;  // 早退

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public int getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(int leaveDay) {
        this.leaveDay = leaveDay;
    }

    public int getBusinessDay() {
        return businessDay;
    }

    public void setBusinessDay(int businessDay) {
        this.businessDay = businessDay;
    }

    public int getOvertimeDay() {
        return overtimeDay;
    }

    public void setOvertimeDay(int overtimeDay) {
        this.overtimeDay = overtimeDay;
    }

    public int getLateDay() {
        return lateDay;
    }

    public void setLateDay(int lateDay) {
        this.lateDay = lateDay;
    }

    public int getEarlyDay() {
        return earlyDay;
    }

    public void setEarlyDay(int earlyDay) {
        this.earlyDay = earlyDay;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
