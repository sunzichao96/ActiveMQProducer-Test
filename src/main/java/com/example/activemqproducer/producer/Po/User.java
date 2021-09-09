package com.example.activemqproducer.producer.Po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private Float physics;
    private Float math;
    private Date createTime;
    private Date updateTime;
    private String email;
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", physics=" + physics +
                ", math=" + math +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
