package Admin;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import classes.Access;
import classes.Filiere;
import classes.Niveau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class ListeNController  implements Initializable {
	
	
	@FXML
    private TableView<Niveau> TableN;
    @FXML
    private TableColumn<Filiere, String> idColN;
    @FXML
    private TableColumn<Filiere, String> nameColN;
    @FXML
    private TableColumn<Filiere, String> codeColN;
    @FXML
    private TableColumn<Filiere, String> daColN;
    
    @FXML
    private Button ajoutN;
    @FXML
    private Button modifierN;
    @FXML
    private Button supprimerN;
    @FXML
    private Button listeN;
    @FXML
    private Button menu;
    
    
	ObservableList<Niveau>  NiveauListe = FXCollections.observableArrayList();   
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
 
			try (Connection conn = Access.connectDB("javaprojet");) {
				ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM niveau");
				
				while(rs.next()) {
					NiveauListe.add(new Niveau(rs.getString("idNiveau"), rs.getString("idFiliere"),
							rs.getString("titre"), rs.getString("alias")));}
	    	} catch (SQLException | ClassNotFoundException e) {
				System.out.println("No filiere was inserted!");
				e.printStackTrace();}
				
	        idColN.setCellValueFactory(new PropertyValueFactory<>("idNiveau"));
	        nameColN.setCellValueFactory(new PropertyValueFactory<>("idFiliere"));
	        codeColN.setCellValueFactory(new PropertyValueFactory<>("titre"));
	        daColN.setCellValueFactory(new PropertyValueFactory<>("alias"));
	        
	        TableN.setItems(NiveauListe);		
		}
	
	
	
	
	
	   public void ajouterN(ActionEvent event2) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("AjouterNiveau.fxml");

	    }
	    
	    public void modifierN(ActionEvent event3) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("ModifierNiveau.fxml");

	    }
	    
	    public void supprimerN(ActionEvent event4) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("SupprimerNiveau.fxml");

	    }
	    
	    public void listeN(ActionEvent event7) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("ListeNiveau.fxml");

	    }
	    
	    public void menu(ActionEvent event5) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("Admin.fxml");

	    }
	    
	    public void service(ActionEvent event6) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("Service.fxml");

	    } 
	    
	   
		
	}


