package net.study.com.user.domain;

import java.util.Date;

public class User {
    private int user_num;
    private String user_id;
    private String login_id;
    private String password;
    private String user_nickname;
    private String user_name;
    private String user_email;
    private String user_birth;
    private String user_phonenumber;
    private String login_type;
    private String use_yn;
    private Date reg_date;
    private String update_date;



    public int getUser_num() {
        return user_num;
    }

    public void setUser_num(int user_num) {
        this.user_num = user_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_phonenumber() {
        return user_phonenumber;
    }

    public void setUser_phonenumber(String user_phonenumber) {
        this.user_phonenumber = user_phonenumber;
    }

    public String getLogin_type() {
        return login_type;
    }

    public void setLogin_type(String login_type) {
        this.login_type = login_type;
    }

    public String getUse_yn() {
        return use_yn;
    }

    public void setUse_yn(String use_yn) {
        this.use_yn = use_yn;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_num=" + user_num +
                ", user_id='" + user_id + '\'' +
                ", login_id='" + login_id + '\'' +
                ", password='" + password + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_birth='" + user_birth + '\'' +
                ", user_phonenumber='" + user_phonenumber + '\'' +
                ", logintype='" + login_type + '\'' +
                ", use_yn='" + use_yn + '\'' +
                ", reg_date=" + reg_date +
                ", update_date='" + update_date + '\'' +
                '}';
    }
}
