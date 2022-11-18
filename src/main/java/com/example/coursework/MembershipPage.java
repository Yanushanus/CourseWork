package com.example.coursework;

import com.example.coursework.configs.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.example.coursework.userClasses.UserOffer;
import com.example.coursework.userClasses.clubs.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class MembershipPage {
    public static String getOfferInfo;
    @FXML
    private Button infoButton;

    @FXML
    private Button submitButton;



    @FXML
    private Button boxButton;

    @FXML
    private Button gymButton;

    @FXML
    private Button massageButton;

    @FXML
    private Button poolButton;

    @FXML
    private Button saunaButton;

    @FXML
    private Label sumLabel;

    @FXML
    private Button tennisButton;

    @FXML
    private Label userInfoLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Button yogaButton;

    @FXML
    void initialize() {
        AtomicBoolean yogaBool = new AtomicBoolean(false);
        AtomicBoolean boxBool = new AtomicBoolean(false);
        AtomicBoolean gymBool = new AtomicBoolean(false);
        AtomicBoolean tennisBool = new AtomicBoolean(false);
        AtomicBoolean poolBool = new AtomicBoolean(false);
        AtomicBoolean saunaBool = new AtomicBoolean(false);
        AtomicBoolean massageBool = new AtomicBoolean(false);
        ArrayList<Club> clubs = new ArrayList<>();
        UserOffer userOffer = new UserOffer(HelloController.getName(), HelloController.getSurname(), clubs);
        boxButton.setOnAction(event -> {
            try {
                setInfo(boxBool, userOffer, new Box(),boxButton);
                getOfferInfo = "Your list of clubs:" + userOffer.getNameList() + "\n Your sum:" + userOffer.getSumString();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        yogaButton.setOnAction(event -> {
            try {
                setInfo(yogaBool, userOffer, new Yoga(),yogaButton);
                getOfferInfo = "Your list of clubs:" + userOffer.getNameList() + "\n Your sum:" + userOffer.getSumString();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        saunaButton.setOnAction(event -> {
            try {
                setInfo(saunaBool, userOffer, new Sauna(),saunaButton);
                getOfferInfo = "Your list of clubs:" + userOffer.getNameList() + "\n Your sum:" + userOffer.getSumString();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        gymButton.setOnAction(event -> {
            try {
                setInfo(gymBool, userOffer, new Gym(),gymButton);
                getOfferInfo = "Your list of clubs:" + userOffer.getNameList() + "\n Your sum:" + userOffer.getSumString();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        tennisButton.setOnAction(event -> {
            try {
                setInfo(tennisBool, userOffer, new Tennis(),tennisButton);
                getOfferInfo = "Your list of clubs:" + userOffer.getNameList() + "\n Your sum:" + userOffer.getSumString();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        massageButton.setOnAction(event -> {
            try {
                setInfo(massageBool, userOffer, new Massage(),massageButton);
                getOfferInfo = "Your list of clubs:" + userOffer.getNameList() + "\n Your sum:" + userOffer.getSumString();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        poolButton.setOnAction(event -> {
            try {
                setInfo(poolBool, userOffer, new Pool(),poolButton);
                getOfferInfo = "Your list of clubs:" + userOffer.getNameList() + "\n Your sum:" + userOffer.getSumString();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        infoButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("infoOffer.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        submitButton.setOnAction(event -> {
            addOffer(userOffer);
        });
        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
        });

    }

    public static Label info(Label label) {
        label.setText(getOfferInfo);
        return label;
    }

    private void setInfo(AtomicBoolean bool, UserOffer userOffer, Club club,Button button) {
        if (bool.get() == false) {
            bool.set(true);
            userOffer.addClub(club);
            button.setStyle("-fx-background-color: #fa4e94;");
        } else if (bool.get() == true) {
            bool.set(false);
            userOffer.deleteClub(club);
            button.setStyle("-fx-background-color: #8df702;");

        }
        System.out.println(userOffer.getNameList() + userOffer.getSumString());
    }

    private void addOffer(UserOffer userOffer) {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        try {
            if(userOffer.getNameList()!=" "){
                dataBaseHandler.addOffer(userOffer);
            }
            else System.out.println("You need to choose");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
