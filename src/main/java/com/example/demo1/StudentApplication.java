package com.example.demo1;

import com.example.demo1.lesson18.Bean;
import com.example.demo1.lesson18.Student;
import com.example.demo1.lesson18.Validator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class StudentApplication extends Application {


    private final ObservableList<String> studentItems =
            FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {

        // =========================
        // INPUTLAR
        // =========================

        TextField nameField = new TextField();
        nameField.setPromptText("Enter name");

        TextField surnameField = new TextField();
        surnameField.setPromptText("Enter surname");

        TextField ageField = new TextField();
        ageField.setPromptText("Enter age");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter email");


        // =========================
        // LABEL-LAR
        // =========================

        Label titleLabel = new Label("Student Registration");

        Label nameLabel = new Label("Name:");
        Label surnameLabel = new Label("Surname:");
        Label ageLabel = new Label("Age:");
        Label emailLabel = new Label("Email:");


        // =========================
        // BUTTON-LAR
        // =========================

        Button clearButton = new Button("Clear");
        Button saveButton = new Button("Save");


        // =========================
        // SOL TƏRƏF - GRIDPANE
        // =========================

        GridPane formGrid = new GridPane();

        formGrid.setHgap(10);
        formGrid.setVgap(15);

        formGrid.add(nameLabel, 0, 0);
        formGrid.add(nameField, 1, 0);

        formGrid.add(surnameLabel, 0, 1);
        formGrid.add(surnameField, 1, 1);

        formGrid.add(ageLabel, 0, 2);
        formGrid.add(ageField, 1, 2);

        formGrid.add(emailLabel, 0, 3);
        formGrid.add(emailField, 1, 3);


        // =========================
        // BUTTON HBOX
        // =========================

        HBox buttonBox = new HBox(10);

        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(
                clearButton,
                saveButton
        );


        // =========================
        // SOL VBOX
        // =========================

        VBox leftBox = new VBox(20);

        leftBox.setPadding(new Insets(20));
        leftBox.setPrefWidth(350);

        leftBox.getChildren().addAll(
                titleLabel,
                formGrid,
                buttonBox
        );


        // =========================
        // SAĞ TƏRƏF
        // =========================

        Label listTitle = new Label("Student List");

        ListView<String> studentListView =
                new ListView<>(studentItems);

        studentListView.setPrefWidth(450);
        studentListView.setPrefHeight(350);

        VBox rightBox = new VBox(15);

        rightBox.setPadding(new Insets(20));

        rightBox.getChildren().addAll(
                listTitle,
                studentListView
        );


        // =========================
        // CLEAR BUTTON
        // =========================

        clearButton.setOnAction(event -> {

            nameField.clear();
            surnameField.clear();
            ageField.clear();
            emailField.clear();

            nameField.requestFocus();
        });


        // =========================
        // SAVE BUTTON
        // =========================

        saveButton.setOnAction(event -> {

            String name = nameField.getText().trim();
            String surname = surnameField.getText().trim();
            String ageText = ageField.getText().trim();
            String email = emailField.getText().trim();


            // =========================
            // BOŞ FIELD VALIDATION
            // =========================

            if (name.isBlank()
                    || surname.isBlank()
                    || ageText.isBlank()
                    || email.isBlank()) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Validation Error",
                        "All fields are required!"
                );

                return;
            }


            // =========================
            // NAME VALIDATION
            // =========================

            if (!Validator.isValidName(name)) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Invalid Name",
                        "Name is not valid!"
                );

                return;
            }


            // =========================
            // SURNAME VALIDATION
            // =========================

            if (!Validator.isValidSurname(surname)) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Invalid Surname",
                        "Surname is not valid!"
                );

                return;
            }


            // =========================
            // AGE INTEGER VALIDATION
            // =========================

            int age;

            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException e) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Invalid Age",
                        "Age must be a number!"
                );

                return;
            }


            // =========================
            // AGE VALIDATION METHOD
            // =========================

            if (!Validator.isValidAge(age)) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Invalid Age",
                        "Age is not valid!"
                );

                return;
            }


            // =========================
            // EMAIL VALIDATION
            // =========================

            if (!Validator.isValidEmail(email)) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Invalid Email",
                        "Email is not valid!"
                );

                return;
            }


            // =========================
            // STUDENT CREATE
            // =========================

            String fullName = name + " " + surname;

            Student student =
                    new Student(fullName, email, age);


            // Normal List<Student>
            Bean.students.add(student.toString());


            // ListView<String>
            // toString() avtomatik çağırılır
            studentItems.add(student.toString());


            // =========================
            // SUCCESS ALERT
            // =========================

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Success",
                    "Student saved successfully!"
            );


            // =========================
            // INPUTLARI TƏMİZLƏ
            // =========================

            nameField.clear();
            surnameField.clear();
            ageField.clear();
            emailField.clear();

            nameField.requestFocus();
        });


        // =========================
        // ƏSAS GRIDPANE
        // =========================

        GridPane root = new GridPane();

        root.setPadding(new Insets(20));
        root.setHgap(30);

        root.add(leftBox, 0, 0);
        root.add(rightBox, 1, 0);


        // =========================
        // SCENE
        // =========================

        Scene scene = new Scene(
                root,
                900,
                450
        );

        stage.setTitle("Student Management");
        stage.setScene(scene);
        stage.show();
    }


    // =========================
    // ALERT METHOD
    // =========================

    private void showAlert(
            Alert.AlertType type,
            String title,
            String message
    ) {

        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}