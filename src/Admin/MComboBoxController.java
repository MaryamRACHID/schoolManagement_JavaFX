package Admin;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import classes.Access;
import classes.Niveau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;



public class MComboBoxController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private Button ajout;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button menu;
    @FXML
    private Button service;
    @FXML
    private Button liste;
    @FXML
    private TextField idModule;
    @FXML
    private TextField titreModule;
    @FXML
    private TextField codeModule;
    @FXML
    private ComboBox<String> comboBox ;
    @FXML
    private TextField id;

    
    

    List<String> CNiveau = new ArrayList<>();   
	ObservableList<Niveau>  NiveauListe = FXCollections.observableArrayList();    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try (Connection conn = Access.connectDB("javaprojet");) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Niveau");
			
			while(rs.next()) {
				CNiveau.add(rs.getString("titre"));
				}
    	} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No filiere was inserted!");
			e.printStackTrace();}

        comboBox.setItems(FXCollections.observableArrayList(CNiveau));
		
	}
	
	
    //Ajouter
    public void ajouterModule(ActionEvent event) throws IOException, ClassNotFoundException {
        checkModule();

    }
    
    public void checkModule() throws ClassNotFoundException, IOException {
    	
    	String id = idModule.getText().toString();
    	String titre = titreModule.getText().toString();
    	String code = codeModule.getText().toString();
    	String da = comboBox.getValue().toString();
    	String idNiveau = null;
    	
    	String sql="INSERT into module(idModule, idNiveau, titre, code) VALUES (?,?,?,?)";
    	
		try (Connection conn = Access.connectDB("javaprojet");) {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM niveau where titre=?");
			stmnt.setString(1, da);
			ResultSet rst = stmnt.executeQuery();
			if(!rst.next()) {
				System.out.println("Erreur s'est produit");
			}else {
				idNiveau = rst.getString("idNiveau");
			}
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, idNiveau);
			statement.setString(3, titre);
			statement.setString(4, code);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new niv was inserted successfully!");
		        MainAd m = new MainAd();
		        m.changeScene("AjouterModule.fxml");
				
			}
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("No Module was inserted!");
			e.printStackTrace();
		}

    }
    

	
	
    //Modifier
    public void modifierModule(ActionEvent event) throws IOException, ClassNotFoundException {
        modModule();

    }
    
    public void modModule() throws ClassNotFoundException, IOException {
    	
    	String id0 = id.getText().toString();
    	String idM = idModule.getText().toString();
    	String titre = titreModule.getText().toString();
    	String code = codeModule.getText().toString();
    	String da = comboBox.getValue().toString();
    	String idNiveau = null;
    	
		try (Connection conn = Access.connectDB("javaprojet");) {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM niveau where titre=?");
			stmnt.setString(1, da);
			ResultSet rst = stmnt.executeQuery();
			if(!rst.next()) {
				System.out.println("Erreur s'est produit");
			}else {
				idNiveau = rst.getString("idNiveau");
			}
			
			String sql="update module set idModule=?, idNiveau=?, titre=?, code=? where idModule=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, idM);
			statement.setString(2, idNiveau);
			statement.setString(3, titre);
			statement.setString(4, code);
			statement.setString(5, id0);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Module was inserted successfully!");
		        MainAd m = new MainAd();
		        m.changeScene("AjouterModule.fxml"); }
			
			else{
				
			}
			statement.close();
			conn.close(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    
    
	

    
    
    
    	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public void ajouter(ActionEvent event2) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("AjouterModule.fxml");

    }
    
    public void modifier(ActionEvent event3) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("ModifierModule.fxml");

    }
    
    public void supprimer(ActionEvent event4) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("SupprimerModule.fxml");

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
        m.changeScene("ListeModule.fxml");

    }


}