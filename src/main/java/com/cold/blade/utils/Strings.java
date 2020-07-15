package com.cold.blade.utils;

import java.util.Objects;

/**
 * @author cold_blade
 * @version 1.0
 */
public final class Strings {

    private Strings() {
    }

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.trim().length() == 0;
    }
}
