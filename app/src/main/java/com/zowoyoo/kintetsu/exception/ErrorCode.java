package com.zowoyoo.kintetsu.exception;

import com.zowoyoo.kintetsu.R;
import com.zowoyoo.kintetsu.tools.RStringUtils;

public enum ErrorCode {

    NOT_RIGHT_CODE(1, RStringUtils.getStringFromR(R.string.error_code_01)),
    UNKNOWN_ERROR(2, RStringUtils.getStringFromR(R.string.error_code_02));

    private int value;
    private String desc;

    private ErrorCode(int key, String desc) {
        this.setValue(key);
        this.setDesc(desc);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "[" + this.value + "]" + this.desc;
    }


}
