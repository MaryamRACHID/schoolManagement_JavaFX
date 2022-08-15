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
import classes.Filiere;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;



public class ComboBoxController implements Initializable {

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
    private TextField idNiveau;
    @FXML
    private TextField titreNiveau;
    @FXML
    private TextField alias;
    @FXML
    private ComboBox<String> comboBox ;
    @FXML
    private TextField id;

    
    

    List<String> CFiliere = new ArrayList<>();   
	ObservableList<Filiere>  FiliereListe = FXCollections.observableArrayList();    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try (Connection conn = Access.connectDB("javaprojet");) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM filiere");
			
			while(rs.next()) {
				CFiliere.add(rs.getString("titreFiliere"));
				}
    	} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No filiere was inserted!");
			e.printStackTrace();}

        comboBox.setItems(FXCollections.observableArrayList(CFiliere));
		
	}
	
	
    //Ajouter
    public void ajouterNiveau(ActionEvent event) throws IOException, ClassNotFoundException {
        checkNiveau();

    }
    
    public void checkNiveau() throws ClassNotFoundException, IOException {
    	
    	String id = idNiveau.getText().toString();
    	String titre = titreNiveau.getText().toString();
    	String code = alias.getText().toString();
    	String da = comboBox.getValue().toString();
    	String idFiliere = null;
    	
    	String sql="INSERT into niveau(idNiveau, idFiliere, titre, alias) VALUES (?,?,?,?)";
    	
		try (Connection conn = Access.connectDB("javaprojet");) {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM filiere where titreFiliere=?");
			stmnt.setString(1, da);
			ResultSet rst = stmnt.executeQuery();
			if(!rst.next()) {
				System.out.println("Erreur s'est produit");
			}else {
				idFiliere = rst.getString("idFiliere");
			}
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, idFiliere);
			statement.setString(3, titre);
			statement.setString(4, code);

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
    public void modifierNiveau(ActionEvent event) throws IOException, ClassNotFoundException {
        modNiveau();

    }
    
    public void modNiveau() throws ClassNotFoundException, IOException {
    	
    	String id0 = id.getText().toString();
    	String idN = idNiveau.getText().toString();
    	String titre = titreNiveau.getText().toString();
    	String code = alias.getText().toString();
    	String da = comboBox.getValue().toString();
    	String idFiliere = null;
    	
		try (Connection conn = Access.connectDB("javaprojet");) {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM filiere where titreFiliere=?");
			stmnt.setString(1, da);
			ResultSet rst = stmnt.executeQuery();
			if(!rst.next()) {
				System.out.println("Erreur s'est produit");
			}else {
				idFiliere = rst.getString("idFiliere");
			}
			
			String sql="update niveau set idNiveau=?, idFiliere=?, titre=?, alias=? where idNiveau=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,idN);
			statement.setString(2,idFiliere);
			statement.setString(3, titre);
			statement.setString(4, code);
			statement.setString(5, id0);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new filiere was inserted successfully!");
		        MainAd m = new MainAd();
		        m.changeScene("AjouterNiveau.fxml"); }
			
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