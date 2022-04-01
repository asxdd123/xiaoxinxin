package com.hehe;

import java.io.Serializable;

/**
 * 如果这个类想要被序列化,必须实现Serializable序列接口
 */
public class User implements Serializable {
    //手动创建序列号,以后更改被序列化后的JavaBean不会报错
    private static final long serialVersionUID = 1L;

    // transient关键字   如果某个成员变量不想被序列化,前面加transient关键字
//    private transient String username;
    private  String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
