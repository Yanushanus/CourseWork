package com.example.coursework;

import com.example.coursework.animations.Shake;
import com.example.coursework.configs.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.coursework.userClasses.User;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {
    private static String name;
    private static String surname;
    @FXML
    private Button authorizationButton;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registrationButton;

    @FXML
    void initialize() {

        registrationButton.setOnAction(actionEvent -> {
            registrationButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("registrationPage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Registration Page");
            stage.showAndWait();
        });
        authorizationButton.setOnAction(actionEvent -> {
            String loginText = loginTextField.getText().trim();
            String passwordText = passwordTextField.getText().trim();
            if (!loginText.equals("") && !passwordText.equals("")) {
                try {
                    loginUser(loginText, passwordText);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else System.out.println("Login or password is empty");
        });

    }

    private void loginUser(String loginText, String passwordText) throws SQLException {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        ResultSet resultSet = dataBaseHandler.getUser(user);

        int counter = 0;
        while (resultSet.next()) {
            name = resultSet.getString("firstname");
            surname = resultSet.getString("secondname");
            counter++;
        }
        if (counter >= 1) {
            authorizationButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("mainPage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Home Page");
            stage.showAndWait();
        } else {
            Shake userLogin = new Shake(loginTextField);
            Shake userPassword = new Shake(passwordTextField);
            userLogin.playAnimation();
            userPassword.playAnimation();
        }
    }

    public static Label getInfoAboutUser(Label label) {
        label.setText("Welcome back " + getName() + " " + getSurname());
        return label;
    }

    public static String getName() {
        return name;
    }

    public static String getSurname() {
        return surname;
    }
}