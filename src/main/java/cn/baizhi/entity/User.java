package cn.baizhi.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String trustname;
    private String password;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", trustname='" + trustname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTrustname() {
        return trustname;
    }

    public void setTrustname(String trustname) {
        this.trustname = trustname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(String username, String trustname, String password, String sex) {
        this.username = username;
        this.trustname = trustname;
        this.password = password;
        this.sex = sex;
    }

    public User() {
    }
}
