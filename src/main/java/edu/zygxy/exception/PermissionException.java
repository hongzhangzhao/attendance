package edu.zygxy.exception;

/**
 * Created by guofumei on 2019/11/5.
 */
public class PermissionException extends BaseException {
    public PermissionException() {
        super(404, "权限不足", null);
    }
}
