package com.zowoyoo.kintetsu.exception;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AppException(Object Obj) {
        super(Obj.toString());
    }
}
