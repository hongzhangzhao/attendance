package edu.zygxy.exception;

/**
 * Created by liangjiateng on 2017/5/5.
 */
public class PermissionException extends BaseException {
    public PermissionException() {
        super(404, "权限不足", null);
    }
}
