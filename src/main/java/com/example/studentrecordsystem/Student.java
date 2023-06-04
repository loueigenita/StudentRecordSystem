package com.example.studentrecordsystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty name;
    private final StringProperty address;
    private final StringProperty contactNo;
    private final StringProperty course;
    private final StringProperty year;
    private final StringProperty adviser;

    public Student(String name, String address, String contactNo, String course, String year, String adviser) {
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.contactNo = new SimpleStringProperty(contactNo);
        this.course = new SimpleStringProperty(course);
        this.year = new SimpleStringProperty(year);
        this.adviser = new SimpleStringProperty(adviser);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getContactNo() {
        return contactNo.get();
    }

    public void setContactNo(String contactNo) {
        this.contactNo.set(contactNo);
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public String getYear() {
        return year.get();
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getAdviser() {
        return adviser.get();
    }

    public void setAdviser(String adviser) {
        this.adviser.set(adviser);
    }

    // Property getters
    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public StringProperty contactNoProperty() {
        return contactNo;
    }

    public StringProperty courseProperty() {
        return course;
    }

    public StringProperty yearProperty() {
        return year;
    }

    public StringProperty adviserProperty() {
        return adviser;
    }
}
