package com.example.demo1;

import com.example.demo1.model.Student;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StApplication extends Application {

    @Override
    public void start(Stage stage) {

        ObservableList<Student> students =
                FXCollections.observableArrayList(
                        new Student(1, "Ali", "ali@gmail.com", 20),
                        new Student(2, "Nigar", "nigar@gmail.com", 22),
                        new Student(3, "Murad", "murad@gmail.com", 19)
                );

        TableView<Student> tableView = new TableView<>();


        // ID column
        TableColumn<Student, Integer> idColumn =
                new TableColumn<>("ID");

        idColumn.setCellValueFactory(data ->
                new ReadOnlyObjectWrapper<>(
                        data.getValue().getId()
                )
        );


        // Name column
        TableColumn<Student, String> nameColumn =
                new TableColumn<>("Name");

        nameColumn.setCellValueFactory(data ->
                new ReadOnlyStringWrapper(
                        data.getValue().getName()
                )
        );


        // Email column
        TableColumn<Student, String> emailColumn =
                new TableColumn<>("Email");

        emailColumn.setCellValueFactory(data ->
                new ReadOnlyStringWrapper(
                        data.getValue().getEmail()
                )
        );


        // Age column
        TableColumn<Student, Integer> ageColumn =
                new TableColumn<>("Age");

        ageColumn.setCellValueFactory(data ->
                new ReadOnlyObjectWrapper<>(
                        data.getValue().getAge()
                )
        );


        tableView.getColumns().addAll(
                idColumn,
                nameColumn,
                emailColumn,
                ageColumn
        );

        tableView.setItems(students);


        VBox root = new VBox(10);

        root.getChildren().add(tableView);

        Scene scene = new Scene(root, 600, 400);

        stage.setScene(scene);
        stage.setTitle("Students");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}