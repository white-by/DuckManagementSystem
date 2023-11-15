package com.example.entity;

import javax.persistence.*;

@Table(name = "course_select_info")
public class CourseSelectInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "score")
    private Integer score;
    @Column(name = "classOpen")
    private Integer classOpen;
    @Column(name = "classChoose")
    private Integer classChoose;
    @Column(name = "time")
    private String time;
    @Column(name = "location")
    private String location;
    @Column(name = "teacherId")
    private Long teacherId;
    @Column(name = "major")
    private String major;
    @Column(name = "studentId")
    private Long studentId;

    @Transient
    private String teacherName;
    @Transient
    private String studentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getClassOpen() {
        return classOpen;
    }

    public void setClassOpen(Integer classOpen) {
        this.classOpen = classOpen;
    }

    public Integer getClassChoose() {
        return classChoose;
    }

    public void setClassChoose(Integer classChoose) {
        this.classChoose = classChoose;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
