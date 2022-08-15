package Admin;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import classes.Access;
import classes.Filiere;
import classes.Role;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class compteController implements Initializable {

	
    @FXML
    private Label wrong;
    @FXML
    private Button ajouter;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField idUtilisateur;
    @FXML
    private TextField email;
    @FXML
    private TextField telephone;
    @FXML
    private TextField grade;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField pass;
    @FXML
    private ComboBox<String> comboBox ;
    @FXML
    private ComboBox<String> comboBoxGender;
    @FXML
    private TextField id;
    @FXML
    private TextField idRef;


    
    

    List<String> Role = new ArrayList<>();   
    List<String> Gender = new ArrayList<>();  
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try (Connection conn = Access.connectDB("javaprojet");) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM role");
			Gender.add("Femme");
			Gender.add("Homme");
			while(rs.next()) {
				Role.add(rs.getString("nomRole"));
				
				}
    	} catch (SQLException | ClassNotFoundException e) {
			System.out.println("!!!!!!!!!!!!!");
			e.printStackTrace();}

//        comboBox.setItems(FXCollections.observableArrayList(Role));
        comboBoxGender.setItems(FXCollections.observableArrayList(Gender));

		
	}
	
	
    //Ajouter
    public void ajouterUtilisateur(ActionEvent event) throws IOException, ClassNotFoundException {
        checkUtilisateur();

    }
    
    public void checkUtilisateur() throws ClassNotFoundException, IOException {
    	
    	String id = idUtilisateur.getText().toString();
    	String Nom = nom.getText().toString();
    	String Prenom = prenom.getText().toString();
    	String gender = comboBoxGender.getValue().toString();
    	String tele = telephone.getText().toString();
    	String Email = email.getText().toString();
//    	String role = comboBox.getValue().toString();
//    	String idRole = null;
    	
    	String sql="INSERT into utilisateur(idUtilisateur, nom, prenom, sexe, email, telephone) VALUES (?,?,?,?,?,?)";
		try (Connection conn = Access.connectDB("javaprojet");) {
//			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM role where nomRole=?");
//			stmnt.setString(1, role);
//			ResultSet rst = stmnt.executeQuery();
//			if(!rst.next()) {
//				System.out.println("Erreur s'est produit");
//			}else {
//				idRole = rst.getString("idRole");
//			}
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, Nom);
			statement.setString(3, Prenom);
			statement.setString(4, gender);
			statement.setString(5, Email);
			statement.setString(6, tele);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new niv was inserted successfully!");
		        MainAd m = new MainAd();
		        m.changeScene("AjouterNiveau.fxml");
				
			}
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("No Niveau was inserted!");
			e.printStackTrace();
		}

    }
    

	
	
    //Modifier
    public void modifierUtilisateur(ActionEvent event) throws IOException, ClassNotFoundException {
        modUtilisateur();

    }
    
    public void modUtilisateur() throws ClassNotFoundException, IOException {
    	
    	String id = idUtilisateur.getText().toString();
    	String Nom = nom.getText().toString();
    	String Prenom = prenom.getText().toString();
    	String gender = comboBoxGender.getValue().toString();
    	String tele = telephone.getText().toString();
    	String Email = email.getText().toString();
    	String id0 = idRef.getText().toString();
    	
		try (Connection conn = Access.connectDB("javaprojet");) {

			String sql="update utilisateur set idUtilisateur=?, nom=?, prenom=?, sexe=?, email=?, telephone=? where idUtilisateur=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, Nom);
			statement.setString(3, Prenom);
			statement.setString(4, gender);
			statement.setString(5, Email);
			statement.setString(6, tele);
			statement.setString(7, id0);
			

			statement.close();
			conn.close(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    
    
	

    
    
    
    	
    //Ajouter
    public void ajouterAdmin(ActionEvent event) throws IOException, ClassNotFoundException {
        checkAdmin();

    }
    
    public void checkAdmin() throws ClassNotFoundException, IOException {
    	String id = idUtilisateur.getText().toString();
    	String Grade = grade.getText().toString();
    	String password = Password.getText().toString();
    	String password2 = pass.getText().toString();

    	String sql="INSERT into compte(idRole, idUtilisateur, password) VALUES (?,?,?)";
    	String sql2="INSERT into administrateur(idUtilisateur, grade)";
		try (Connection conn = Access.connectDB("javaprojet");) {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM utilisateur where idUtilisateur=?");
			stmnt.setString(1, id);
			ResultSet rst = stmnt.executeQuery();
			if(!rst.next()) {
				System.out.println("Erreur s'est produit");
			}else {
				if(password.equals(password2)) {
				PreparedStatement statement = conn.prepareStatement(sql);
				PreparedStatement statement2 = conn.prepareStatement(sql2);
				statement.setString(1, "1");
				statement.setString(2, id);
				statement.setString(3, password);
				statement2.setString(1, id);
				statement2.setString(2, Grade);
				int rowsInserted = statement.executeUpdate();
				int rowsInserted2 = statement2.executeUpdate();
				if (rowsInserted > 0 && rowsInserted2> 0) {
					System.out.println("A new niv was inserted successfully!");
			        MainAd m = new MainAd();
			        m.changeScene("Admin.fxml");
					
				}}else {
					wrong.setText("Le mot de passe est incorrecte");
				}
			}
			rst.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("No Niveau was inserted!");
			e.printStackTrace();
		}

    }
    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public void ajouter(ActionEvent event2) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("AjouterNiveau.fxml");

    }
    
    public void modifier(ActionEvent event3) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("ModifierNiveau.fxml");

    }
    
    public void supprimer(ActionEvent event4) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("SupprimerNiveau.fxml");

    }
    
    
    public void menu(ActionEvent event5) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("Admin.fxml");

    }
    
    public void service(ActionEvent event6) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("Service.fxml");

    } 
    
    public void liste(ActionEvent event7) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("ListeNiveau.fxml");

    }


}