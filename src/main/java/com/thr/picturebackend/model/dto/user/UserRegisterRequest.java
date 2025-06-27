package com.thr.picturebackend.model.dto.user;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserRegisterRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5498382949642273975L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;

}
