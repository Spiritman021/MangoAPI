package com.tworoot2.mangoapi.Models;

public class CC_Model {

    String name, exam, college;

    public CC_Model() {
    }

    public CC_Model(String name) {
        this.name = name;

    }

    public CC_Model(String name, String exam, String college) {
        this.name = name;
        this.exam = exam;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
