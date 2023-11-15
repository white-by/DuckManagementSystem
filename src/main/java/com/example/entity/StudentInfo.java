package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "student_info")
public class StudentInfo extends Account{
    @Column(name = "uid")
    private String uid;
    @Column(name = "major")
    private String major;
    @Column(name = "score")
    private String score;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
