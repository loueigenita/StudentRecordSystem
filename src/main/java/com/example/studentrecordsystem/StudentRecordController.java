package com.example.studentrecordsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class StudentRecordController {
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> addressColumn;
    @FXML
    private TableColumn<Student, String> contactNoColumn;
    @FXML
    private TableColumn<Student, String> courseColumn;
    @FXML
    private TableColumn<Student, String> yearColumn;
    @FXML
    private TableColumn<Student, String> adviserColumn;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Void> editColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField contactNoField;
    @FXML
    private TextField yearField;
    @FXML
    private ComboBox<String> courseComboBox;
    @FXML
    private TextField adviserField;
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;

    private StudentData studentData;
    private Student selectedStudent;

    public void initialize() {
        studentData = new StudentData();
        studentTable.setItems(studentData.getStudentList());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        contactNoColumn.setCellValueFactory(cellData -> cellData.getValue().contactNoProperty());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().courseProperty());
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
        adviserColumn.setCellValueFactory(cellData -> cellData.getValue().adviserProperty());


        studentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedStudent = newValue;
            if (selectedStudent != null) {
                populateFields(selectedStudent);
            } else {
                clearFields();
            }
        });
    }

    @FXML
    private void handleAddStudent() {
        String name = nameField.getText();
        String address = addressField.getText();
        String contactNo = contactNoField.getText();
        String course = courseComboBox.getValue();
        String year = yearField.getText();
        String adviser = adviserField.getText();

        if (name.isEmpty() || address.isEmpty() || contactNo.isEmpty() || course == null || year.isEmpty() || adviser.isEmpty()) {
            showAlert("Error", "All fields must be filled in.");
            return;
        }

        Student newStudent = new Student(name, address, contactNo, course, year, adviser);
        studentData.addStudent(newStudent);

        clearFields();
    }

    @FXML
    private void handleUpdateStudent() {
        if (selectedStudent != null) {
            String name = nameField.getText();
            String address = addressField.getText();
            String contactNo = contactNoField.getText();
            String course = courseComboBox.getValue();
            String year = yearField.getText();
            String adviser = adviserField.getText();

            if (name.isEmpty() || address.isEmpty() || contactNo.isEmpty() || course == null || year.isEmpty() || adviser.isEmpty()) {
                showAlert("Error", "All fields must be filled in.");
                return;
            }

            selectedStudent.setName(name);
            selectedStudent.setAddress(address);
            selectedStudent.setContactNo(contactNo);
            selectedStudent.setCourse(course);
            selectedStudent.setYear(year);
            selectedStudent.setAdviser(adviser);

            studentData.updateStudent(selectedStudent);

            clearFields();
        } else {
            showAlert("Error", "Please select a student to edit.");
        }
    }

    @FXML
    private void handleDeleteStudent() {
        if (selectedStudent != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete the selected student?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                studentData.deleteStudent(selectedStudent);
                clearFields();
            }
        } else {
            showAlert("Error", "Please select a student to delete.");
        }
    }


    private void populateFields(Student student) {
        nameField.setText(student.getName());
        addressField.setText(student.getAddress());
        contactNoField.setText(student.getContactNo());
        courseComboBox.setValue(student.getCourse());
        yearField.setText(student.getYear());
        adviserField.setText(student.getAdviser());
    }

    private void clearFields() {
        nameField.clear();
        addressField.clear();
        contactNoField.clear();
        courseComboBox.getSelectionModel().clearSelection();
        yearField.clear();
        adviserField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}