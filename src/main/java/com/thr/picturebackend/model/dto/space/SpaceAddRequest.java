package com.thr.picturebackend.model.dto.space;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SpaceAddRequest implements Serializable {

    /**
     * 空间名称
     */
    private String spaceName;

    /**
     * 空间级别：0-普通版 1-专业版 2-旗舰版
     */
    private Integer spaceLevel;

    @Serial
    private static final long serialVersionUID = 1L;
}
