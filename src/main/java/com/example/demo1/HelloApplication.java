//package com.example.demo1;
//
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXMLLoader;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) {
//
//        NameService nameService = new NameService();
//
//        // SOL HİSSƏ
//
//        Label titleLabel = new Label("Tələbə əlavə et");
//        titleLabel.getStyleClass().add("title-label");
//
//        Label descriptionLabel =
//                new Label("Yeni tələbənin adını daxil edin");
//        descriptionLabel.getStyleClass().add("description-label");
//
//        TextField nameField = new TextField();
//        nameField.setPromptText("Tələbənin adı");
//        nameField.getStyleClass().add("name-field");
//
//        Button saveButton = new Button("Əlavə et");
//        saveButton.getStyleClass().add("save-button");
//
//        Label resultLabel = new Label();
//        resultLabel.getStyleClass().add("result-label");
//
//        VBox leftSide = new VBox(15);
//        leftSide.setAlignment(Pos.CENTER_LEFT);
//        leftSide.setPadding(new Insets(35));
//        leftSide.getStyleClass().add("left-panel");
//
//        leftSide.getChildren().addAll(
//                titleLabel,
//                descriptionLabel,
//                nameField,
//                saveButton,
//                resultLabel
//        );
//
//        // SAĞ HİSSƏ
//
//        Label namesLabel = new Label("Tələbələrin siyahısı");
//        namesLabel.getStyleClass().add("title-label");
//
//        Label countLabel = new Label();
//        countLabel.getStyleClass().add("count-label");
//
//        ObservableList<String> observableNames =
//                FXCollections.observableArrayList(nameService.getNames());
//
//        ListView<String> namesListView = new ListView<>();
//        namesListView.setItems(observableNames);
//        namesListView.getStyleClass().add("names-list");
//
//        updateCountLabel(countLabel, observableNames.size());
//
//        VBox rightSide = new VBox(15);
//        rightSide.setAlignment(Pos.TOP_LEFT);
//        rightSide.setPadding(new Insets(35));
//        rightSide.getStyleClass().add("right-panel");
//
//        rightSide.getChildren().addAll(
//                namesLabel,
//                countLabel,
//                namesListView
//        );
//
//        // ƏLAVƏ ET DÜYMƏSİ
//
//        saveButton.setOnAction(event -> {
//
//            String name = nameField.getText().trim();
//
//            if (name.isBlank()) {
//                resultLabel.setText("Ad boş ola bilməz");
//                resultLabel.getStyleClass().remove("success-message");
//
//                if (!resultLabel.getStyleClass().contains("error-message")) {
//                    resultLabel.getStyleClass().add("error-message");
//                }
//
//                return;
//            }
//
//            nameService.addNewName(name);
//
//            observableNames.setAll(nameService.getNames());
//
//            updateCountLabel(countLabel, observableNames.size());
//
//            resultLabel.setText(name + " uğurla əlavə edildi");
//
//            resultLabel.getStyleClass().remove("error-message");
//
//            if (!resultLabel.getStyleClass().contains("success-message")) {
//                resultLabel.getStyleClass().add("success-message");
//            }
//
//            nameField.clear();
//        });
//
//        // ENTER BASILDIQDA DA ƏLAVƏ ET
//
//        nameField.setOnAction(event -> saveButton.fire());
//
//        // ƏSAS LAYOUT
//
//        HBox root = new HBox();
//        root.setAlignment(Pos.CENTER);
//        root.setPadding(new Insets(30));
//        root.getStyleClass().add("root-container");
//
//        leftSide.setPrefWidth(380);
//        rightSide.setPrefWidth(380);
//
//        root.getChildren().addAll(leftSide, rightSide);
//
//        Scene scene = new Scene(root, 850, 500);
//
//        // CSS FAYLINI QOŞURUQ
//        scene.getStylesheets().add(
//                getClass()
//                        .getResource("/style.css")
//                        .toExternalForm()
//        );
//
//        stage.setTitle("Tələbə idarəetmə sistemi");
//        stage.setScene(scene);
//        stage.setMinWidth(750);
//        stage.setMinHeight(450);
//        stage.show();
//    }
//
//    private void updateCountLabel(Label countLabel, int count) {
//        countLabel.setText("Ümumi tələbə sayı: " + count);
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}