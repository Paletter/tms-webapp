package com.palette.busi.project.tms.common.util;

import org.springframework.beans.BeanUtils;

public class BeanUtilsExt extends BeanUtils {

    public static void copyPropertiesIgnoreDefault(Object source, Object target) {
        BeanUtils.copyProperties(source, target,
                "recordVersion",
                "createUserCode",
                "createTimeZone",
                "createDateTime",
                "updateUserCode",
                "updateDateTime",
                "updateTimeZone");
    }
}
