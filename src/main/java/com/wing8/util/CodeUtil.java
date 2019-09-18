package com.wing8.util;

/**
 * Created by wzw on 2019/8/6
 *
 * @Author wzw
 */

import java.util.UUID;

public class CodeUtil {
    //生成唯一的激活码
    public static String generateUniqueCode(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
