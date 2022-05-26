package com.hipet.hipetspringboot.jsonify;

import lombok.Data;

@Data
public class ResultJson {
    private Integer statusCode;
    private String msg;
    private Object data;

    /**
     * The func that form a ResultJson.
     * Standard that can be used in every func then.
     * */

    public static ResultJson returnResult(Integer statusCode, String msg, Object data) {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatusCode(statusCode);
        resultJson.setMsg(msg);
        resultJson.setData(data);
        return resultJson;
    }
}
