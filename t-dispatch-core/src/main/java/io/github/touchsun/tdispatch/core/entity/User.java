package io.github.touchsun.tdispatch.core.entity;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author lee
 * @since 2023/6/1 21:28
 */
public class User {

    private int id;

    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色：0-普通用户、1-管理员
     */
    private int role;
    /**
     * 权限：执行引擎ID列表，多个逗号分割
     */
    private String permission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 权限验证
     *
     * @param engineGroup 执行引擎ID
     * @return 是否含有权限
     */
    public boolean validPermission(int engineGroup) {
        boolean isValid = false;
        if (this.role == 1) {
            isValid = true;
        } else if (StringUtils.hasText(this.permission)) {
            isValid = Arrays.stream(this.permission.split(",")).anyMatch(item -> String.valueOf(engineGroup).equals(item));
        }

        return isValid;

    }


}