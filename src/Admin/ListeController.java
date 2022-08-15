package Admin;



import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;





public class ListeController implements Initializable {
	
	
	
	
	
	@FXML
    private TableView<Filiere> Table;
    @FXML
    private TableColumn<Filiere, String> idCol;
    @FXML
    private TableColumn<Filiere, String> nameCol;
    @FXML
    private TableColumn<Filiere, String> codeCol;
    @FXML
    private TableColumn<Filiere, String> daCol;
    @FXML
    private TableColumn<Filiere, String> dfaCol;
   

    
    
    @FXML
    private Button ajoutN;
    @FXML
    private Button modifierN;
    @FXML
    private Button supprimerN;
    @FXML
    private Button listeN;
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
    private ComboBox<String> comboBox ;

	ObservableList<Filiere>  FiliereListe = FXCollections.observableArrayList();    

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try (Connection conn = Access.connectDB("javaprojet");) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM filiere");
			
			while(rs.next()) {
				FiliereListe.add(new Filiere(rs.getString("idFiliere"), rs.getString("titreFiliere"),
						rs.getString("codeFiliere"), rs.getString("anneeaccreditation"), 
						rs.getString("anneeFinaccreditation")));}
    	} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No filiere was inserted!");
			e.printStackTrace();}
			
        idCol.setCellValueFactory(new PropertyValueFactory<>("idFiliere"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("titreFiliere"));
        codeCol.setCellValueFactory(new PropertyValueFactory<>("codeFiliere"));
        daCol.setCellValueFactory(new PropertyValueFactory<>("anneeaccreditation"));
        dfaCol.setCellValueFactory(new PropertyValueFactory<>("anneeFinaccreditation"));
        
        Table.setItems(FiliereListe);		
	}	
		
	
	

	
	
    public void ajouter(ActionEvent event2) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("AjouterFiliere.fxml");

    }
    
    public void modifier(ActionEvent event3) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("ModifierFiliere.fxml");

    }
    
    public void supprimer(ActionEvent event4) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("SupprimerFiliere.fxml");

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
        m.changeScene("Liste.fxml");

    }

}
