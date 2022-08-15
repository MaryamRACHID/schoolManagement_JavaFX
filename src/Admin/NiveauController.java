package Admin;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class NiveauController  {

	
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
    
    
    
  
    

 

}



