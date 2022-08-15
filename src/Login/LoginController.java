package Login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Admin.MainAd;

import java.sql.*;

import classes.Access;

public class LoginController {

    public LoginController() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;



    public void userLogIn(ActionEvent event) throws IOException, ClassNotFoundException {
        checkLogin();

    }

    private void checkLogin() throws ClassNotFoundException, IOException  {
    	
    	String user = username.getText().toString();
    	String pass = password.getText().toString();
    	
    	String sql="SELECT * FROM compte WHERE idUtilisateur=? AND password=?";
        
		try (Connection conn = Access.connectDB("javaprojet");) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,user);
			statement.setString(2,pass);
			ResultSet rs = statement.executeQuery();
			if (!rs.next()) {
				wrongLogIn.setText("Wrong username or password!");
//				wrongLogIn.setText("Compte n'existe pas!");
//				m.changeScene("Home/Home.fxml");
			}
			else {
//				String sql2="SELECT idRole FROM compte WHERE idUtilisateur=?";
//				statement = conn.prepareStatement(sql2);
//				statement.setString(1, username.getText().toString());
//	            wrongLogIn.setText("Success!");
				int role = rs.getInt("idRole");
				if(role==1) {
					MainAd m = new MainAd();
					m.changeScene("../Admin/Admin.fxml");
				}
				else if (role==2) {
					MainAd m = new MainAd();
					m.changeScene("/Etudiant/Etudiant.fxml");
				}
				else {
					wrongLogIn.setText("Wrong username or password!");
				}
				

			}
			rs.close();
			conn.close();
            
        } catch (SQLException e) {
			e.printStackTrace();
		}
    }


}
