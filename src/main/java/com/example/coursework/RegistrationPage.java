package com.example.coursework;

import com.example.coursework.configs.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.coursework.userClasses.User;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationPage {

    @FXML
    private Button goBackButton;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField surnameField;
    @FXML
    void initialize() {
        goBackButton.setOnAction(actionEvent -> {
            goBackButton.getScene().getWindow().hide();
        });

        registerButton.setOnAction(actionEvent -> {
            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        String name=nameField.getText();
        String surname=surnameField.getText();
        String login=loginTextField.getText();
        String password=passwordTextField.getText();
        User user=new User(name,surname,login,password);
        try {
            ResultSet resultSet= dataBaseHandler.getExistUser(user);
            int counter=0;
            while (resultSet.next()) counter++;
            if (counter>=1) {
                loginTextField.clear();
                passwordTextField.clear();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("errorMessage.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            else dataBaseHandler.signUpUser(user);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static String setMessage(){
        String message="There are already exists user with this login";
        return message;
    }
}
