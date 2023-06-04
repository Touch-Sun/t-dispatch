package io.github.touchsun.tdispatch.core.sso;


import io.github.touchsun.tdispatch.core.model.User;

/**
 * 线程共享用户
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
public class UserHolder {

    private static final ThreadLocal<User> LOCAL_USER = new ThreadLocal<>();

    public static void set(User user) {
        LOCAL_USER.set(user);
    }

    public static User get() {
        if (LOCAL_USER.get() != null) {
            return LOCAL_USER.get();
        } else {
            User user = new User();
            user.setId(-1);
            user.setUserName("NoLoginUser");
            return user;
        }
    }

    public static void clear() {
        LOCAL_USER.remove();
    }
}
