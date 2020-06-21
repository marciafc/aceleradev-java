package com.challenge.endpoints.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private Long timeStamp;
    private String msg;

    private StandardError(Integer status, Long timeStamp, String msg) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.msg = msg;
    }

    public static StandardError of(Integer status, Long timeStamp, String msg) {
        return new StandardError(status,timeStamp,msg);
    }

}