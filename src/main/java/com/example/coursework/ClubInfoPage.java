package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.example.coursework.userClasses.clubs.*;

import java.io.IOException;
import java.sql.SQLException;

public class ClubInfoPage {
    private static String info;
    @FXML
    private Button backButton;

    @FXML
    private Button boxButton;

    @FXML
    private Button gymButton;

    @FXML
    private Button massageButton;
    @FXML
    private Label textLabel;
    @FXML
    private Button poolButton;

    @FXML
    private Button saunaButton;

    @FXML
    private Button tennisButton;

    @FXML
    private Button yogaButton;

    @FXML
    void initialize() {
        gymButton.setOnAction(actionEvent -> {
            try {
                Gym gym = new Gym();
                getInfo(gym);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        boxButton.setOnAction(actionEvent -> {
            try {
                Box box = new Box();
                getInfo(box);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        massageButton.setOnAction(actionEvent -> {
            try {
                Massage massage = new Massage();
                getInfo(massage);
                System.out.println(new Massage().getInfo());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        poolButton.setOnAction(actionEvent -> {
            try {
                Pool pool = new Pool();
                getInfo(pool);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        saunaButton.setOnAction(actionEvent -> {
            try {
                Sauna sauna = new Sauna();
                getInfo(sauna);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        tennisButton.setOnAction(actionEvent -> {
            try {
                Tennis tennis = new Tennis();
                getInfo(tennis);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        yogaButton.setOnAction(actionEvent -> {
            try {
                Yoga yoga = new Yoga();
                getInfo(yoga);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        backButton.setOnAction(actionEvent -> {
            backButton.getScene().getWindow().hide();

        });
    }

    private void getInfo(Club club) {
        try {
            info = club.getInfo();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("infoClub.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Label getField(Label textField) {
        textField.setText(info);
        return textField;
    }
}