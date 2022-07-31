package me.lcc.carrent.web;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * @author lcc
 * @version 2022/7/31
 */
public class LogInContext {

    private static final ThreadLocal<String> USER_ID_LOCAL = new ThreadLocal<>();
    private static final Cache<String, String> IP_USER_CACHE = Caffeine.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(30, TimeUnit.MINUTES)
            .build();

    public static void setUserId(String userId) {
        USER_ID_LOCAL.set(userId);
    }

    public static void setUserId(String userId, String remoteAddr) {
        setUserId(userId);
        IP_USER_CACHE.put(remoteAddr, userId);
    }

    public static String getUserId() {
        return USER_ID_LOCAL.get();
    }

    public static String getUserId(String ipAddress) {
        return IP_USER_CACHE.get(ipAddress, z -> null);
    }
}
