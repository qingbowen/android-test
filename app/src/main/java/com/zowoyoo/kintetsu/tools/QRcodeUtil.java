package com.zowoyoo.kintetsu.tools;


import android.text.TextUtils;

import com.zowoyoo.kintetsu.config.AppConfig;
import com.zowoyoo.kintetsu.exception.AppException;
import com.zowoyoo.kintetsu.exception.ErrorCode;

/**
 * 扫描二维码获取地址后相关处理
 */
public class QRcodeUtil {

    public static String getCode(String codeUrl) {
        String code = null;
        if (!TextUtils.isEmpty(codeUrl) && codeUrl.contains(AppConfig.CODE_FLAG)) {
            String[] urls = codeUrl.split(AppConfig.CODE_FLAG);
            code = urls.length > 1 ? urls[1] : code;
        } else {
            throw new AppException(ErrorCode.NOT_RIGHT_CODE);
        }
        return code;
    }
}
