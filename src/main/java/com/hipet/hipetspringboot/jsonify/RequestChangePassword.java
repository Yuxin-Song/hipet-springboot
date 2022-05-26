package com.hipet.hipetspringboot.jsonify;

import lombok.Data;


@Data
public class RequestChangePassword {
    private Integer userid;
    private String oldPassword;
    private String newPassword;
}
