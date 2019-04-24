package com.zowoyoo.kintetsu.tools;

import com.zowoyoo.kintetsu.application.KintetsuApplication;

/**
 * 用于处理R文件中的字符串，主要是多语言版用到
 */
public class RStringUtils {

    public static String getStringFromR(int intR) {
        return KintetsuApplication.getContext().getResources().getString(intR);
    }

}
