package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
import DBUtils.*;

public class loginController extends DBUtils {
    public PasswordField pwd;
    public TextField uname;
    public Button loginButton;
    private int attmpt = 0;
    private boolean indicator = false;
    private String login;
    private String pass;

    public void attempt(ActionEvent event) throws Exception {
        login = uname.getText();
        pass = pwd.getText();
            try {
                DBUtils.dbConnect(login, pass);
                System.out.println("connected to database");
                indicator = true;
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("connection failed!");
                showAlert();
                attmpt++;
                if (attmpt ==3) loginButton.setDisable(true);
            }
            if (indicator) {
                ((Node) event.getSource()).getScene().getWindow().hide();
                start();
                setData(login,pass);
            }
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Failed!");
        alert.setHeaderText(null);
        alert.setContentText("USERNAME OR PASSWORD INCORRECT!!!");
        alert.showAndWait();    }

    public void start() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/mainapp/mainWindow.fxml"));
        primaryStage.setTitle("Database Application");
        primaryStage.setScene(new Scene(root, 990, 607));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
