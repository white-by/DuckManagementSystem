package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "teacher_info")
public class TeacherInfo extends Account{
    @Column(name = "title")
    private String title;
    @Column(name = "major")
    private String major;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
