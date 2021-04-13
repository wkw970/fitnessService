package com.atguigu.fit.bean;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class User {

    public String getNickname() {
        return nickname;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public double getBmi() {
        return bmi;
    }

    public String getTel() {
        return tel;
    }

    public String getGender() {
        return gender;
    }


    public String getIcon() {
        return icon;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String nickname;
    private Integer height;
    private Integer weight;
    private double  bmi;
    private String  tel;
    private String gender;
    private String icon;

}
