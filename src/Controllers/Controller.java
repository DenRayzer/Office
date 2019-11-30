package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DBConnection;
import sample.User;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField pLogin;

    @FXML
    private TextField pPassword;

    @FXML
    private Button pSignInButton;

    @FXML
    private Button singUpButton;

    @FXML
    void initialize() {
        pSignInButton.setOnAction(event -> {
            String login = pLogin.getText().trim();
            String password = pPassword.getText().trim();

            if (!login.equals("") && !password.equals("")) {
                try {
                    loginUser(login, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else System.out.println("Пусто!");
        });


        singUpButton.setOnAction(event -> {
            singUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../FXML/MainWindow.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });
    }



    private void loginUser(String login,String password) throws SQLException {
        DBConnection dbcCon= new DBConnection();
        ResultSet resultSet = dbcCon.GetUser(login,password);
        User user = User.getInstance();
        int counter = 0;
        while (resultSet.next()){
            counter++;
            if (counter==1){
                user.setUserId(resultSet.getInt(1));
                user.setLogin(resultSet.getNString(2));
                user.setPassword(resultSet.getNString(3));
                System.out.println(user.getUserId() + " EAAAAAAAAAAA " + user.getLogin());
            }
        }

    }
}
