package io.github.touchsun.tdispatch.core.sso;


/**
 * 线程共享用户
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
public class SsoUserHolder {

    private static final ThreadLocal<SsoUser> LOCAL_USER = new ThreadLocal<>();

    public static void set(SsoUser ssoUser) {
        LOCAL_USER.set(ssoUser);
    }

    public static SsoUser get() {
        if (LOCAL_USER.get() != null) {
            return LOCAL_USER.get();
        } else {
            SsoUser ssoUser = new SsoUser();
            ssoUser.setId(-1);
            ssoUser.setUserName("NoLoginUser");
            return ssoUser;
        }
    }

    public static void clear() {
        LOCAL_USER.remove();
    }
}
