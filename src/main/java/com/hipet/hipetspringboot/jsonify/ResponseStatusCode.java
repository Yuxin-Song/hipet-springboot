package com.hipet.hipetspringboot.jsonify;


public enum ResponseStatusCode {
    /**
     * The request succeed, normal response can be sent.
     * */
    SUCCESS(200, "SUCCESS"),

    /**
     * POST request succeed.
     * */
    CREATED(201, "CREATE SUCCESS"),

    /**
     * Missing some attribute needed.
     * */
    BAD_REQUEST(400, "MISSING REQUIRED ATTRIBUTE"),

    /**
     * The User is not authenticated.
     * */
    UNAUTHORIZED(401, "USER IS NOT AUTHENTICATED"),

    /**
     * This requirement is forbidden.
     * */
    FORBIDDEN(403, "THIS REQUIREMENT IS FORBIDDEN"),

    /**
     * 404 Not Found.
     * */
    NOT_FOUND(404, "RESOURCE NOT FOUND"),

    /**
     * Some error occurs in springboot server.
     * */
    ERROR(500, "SERVER ERROR")
    ;

    /**
     * Status Code: listed above
     * */
    private int statusCode;

    /**
     * Some message explains the situation and may be useful.
     * */
    private String msg;

    /**
     * Constructor of the enum class
     * */
    ResponseStatusCode(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    /**
     * Getter and Setter
     * */
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
