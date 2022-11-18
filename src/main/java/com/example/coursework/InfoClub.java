package com.example.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class InfoClub {

    @FXML
    private Button exitButton;

    @FXML
    private Label textLabel;


    @FXML
    void initialize() throws SQLException {
        ClubInfoPage.getField(textLabel);
        exitButton.setOnAction(actionEvent -> {
            exitButton.getScene().getWindow().hide();
        });
    }

}
