# duckManagementSystem 双鸭山教务管理系统

First of all, thanks for reading.

首先，感谢阅读。（中文版请往下看）



## Introduction

This project is the final assignment of my Java course in the second year of college.

A management system related to the school curriculum that is not separated from the front and back
duckManagementSystem full name：Sun Yat-sen Management System

## Tech stack

- Compiler: idea
- Database: MySQL
- Front-end: HTML、CSS and JavaScript, Vue , Bootstrap
- Backend: Springboot, MyBatis, SpringMVC
- JDK：jdk1.8

## Please prepare before you get started

- initialize

1. Maven has been configured
2. The MySQL database has been configured
   2.1. In the local Mysql, create a database with the database name duck_management_system and import the .sql file I provided.
3. Change the password to your own MySQL password in the 'application.yml' file
4. Run

-landing

1. Administrator: admin
2. Teacher: TEAC
3. Students: STU
4. The password is 123

## Implement features

- ps：
  - The administrator permission level is 1, 2 for teachers and 3 for students
  - When adding a new user, the initial password is 123.
- Login screen
-administrator
  -landing
  - Personal interface
  - Administrator Table
  - Add, delete, and modify administrator tables
-teacher
  -landing
  - Personal interface
  - Teacher Table
  - Additions, deletions and changes to the teacher's list
-student
  -landing
  - Personal interface
  - Student Sheets
  - Additions, deletions and changes to the student table
-course
  - Full schedule of courses
  - Permissions management
- Course enrollment
  - Student course selection
  - Permissions management
  - The course enrollment limit has been reached
  - Duplicate course selection questions
- Return to the login screen

---

## 简介

这是本人于大二编写的Java基础课程的期末大作业。

一个前后端不分离的与学校课程相关的管理系统
duckManagementSystem全名：双鸭山管理系统

## 技术栈

- 编译器：idea
- 数据库：MySQL
- 前端：前端三件套、vue框架、bootstrap模板
- 后端：Springboot、MyBatis、SpringMVC
- JDK版本：jdk1.8

## 上手前请准备

- 初始化

1. 已经配置maven
2. 已经配置mysql数据库
   2.1. 在本地的Mysql中，创建一个数据库名称为 duck_management_system 的数据库，并导入我提供的 .sql 文件,
3. 在`application.yml`文件中将密码改成自己mysql的密码
4. 运行

- 登陆

1. 管理员：admin
2. 教师：teac
3. 学生：stu
4. 密码均为123

## 实现功能

- ps：
  - 管理员权限等级为1，教师2，学生3
  - 新增用户时，初始密码“123”
- 登陆界面
- 管理员
  - 登陆
  - 个人界面
  - 管理员表
  - 管理员表增删改
- 教师
  - 登陆
  - 个人界面
  - 教师表
  - 教师表增删改
- 学生
  - 登陆
  - 个人界面
  - 学生表
  - 学生表增删改
- 课程
  - 课程全表
  - 权限管理
- 选课
  - 学生选课
  - 权限管理
  - 选课达到上限
  - 重复选课问题
- 退回登陆界面
