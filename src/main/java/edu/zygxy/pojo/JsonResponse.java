package edu.zygxy.pojo;


/**
 * Created by guofumei on 2019/11/11.
 */
public class JsonResponse {

    private Integer code;

    private String message;

    private Object data;

    public JsonResponse(Object data) {
        this.data = data;
        this.code = 200;
        this.message = "success";
    }

    public JsonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
