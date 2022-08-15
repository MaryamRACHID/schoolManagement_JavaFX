package Admin;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import classes.Access;
import classes.Filiere;
import classes.Module;
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



public class ListeMController  implements Initializable {

    
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
    
    
    
	@FXML
    private TableView<Module> TableN;
    @FXML
    private TableColumn<Filiere, String> idColN;
    @FXML
    private TableColumn<Filiere, String> nameColN;
    @FXML
    private TableColumn<Filiere, String> codeColN;
    @FXML
    private TableColumn<Filiere, String> daColN;

    
    
    
    
	ObservableList<Module>  ModuleListe = FXCollections.observableArrayList();   
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
 
			try (Connection conn = Access.connectDB("javaprojet");) {
				ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM module");
				
				while(rs.next()) {
					ModuleListe.add(new Module(rs.getString("idModule"), rs.getString("idNiveau"),
							rs.getString("titre"), rs.getString("code")));}
	    	} catch (SQLException | ClassNotFoundException e) {
				System.out.println("No filiere was inserted!");
				e.printStackTrace();}
				
	        idColN.setCellValueFactory(new PropertyValueFactory<>("idModule"));
	        nameColN.setCellValueFactory(new PropertyValueFactory<>("idNiveau"));
	        codeColN.setCellValueFactory(new PropertyValueFactory<>("titre"));
	        daColN.setCellValueFactory(new PropertyValueFactory<>("code"));
	        
	        TableN.setItems(ModuleListe);		
		}
	
	
	
	
	
	   public void ajouterN(ActionEvent event2) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("AjouterModule.fxml");

	    }
	    
	    public void modifierN(ActionEvent event3) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("ModifierModule.fxml");

	    }
	    
	    public void supprimerN(ActionEvent event4) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("SupprimerModule.fxml");

	    }
	    
	    public void listeM(ActionEvent event7) throws IOException {
	        MainAd m = new MainAd();
	        m.changeScene("ListeModule.fxml");

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


