package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPage {

    @FXML
    private Button infoButton;

    @FXML
    private Button membershipButton;
    @FXML
    private Label userInfoLabel;

    @FXML
    void initialize() {
        HelloController.getInfoAboutUser(userInfoLabel);
        infoButton.setOnAction(actionEvent -> {
            infoButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("clubInfoPage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Info Page");
            stage.showAndWait();
        });
        membershipButton.setOnAction(actionEvent -> {
            infoButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("membershipPage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Membership Page");
            stage.showAndWait();
        });
    }
}