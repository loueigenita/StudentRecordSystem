package com.example.studentrecordsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentData {
    private ObservableList<Student> studentList;

    public StudentData() {
        studentList = FXCollections.observableArrayList();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudent(Student index) {
        studentList.remove(index);
    }

    public void editStudent(int index, Student newStudent) {
        if (index >= 0 && index < studentList.size()) {
            studentList.set(index, newStudent);
        }
    }

    public ObservableList<Student> getStudentList() {
        return studentList;
    }

    public void updateStudent(Student selectedStudent) {
    }
}
