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
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController  {

	
	
	
    @FXML
    private Label wrong;
    @FXML
    private TextField idUtilisateur;
    @FXML
    private TextField grade;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField pass;
    @FXML
    private ComboBox<String> comboBoxGender;
    @FXML
    private TextField id;
    @FXML
    private TextField idRef;
    @FXML
    private Button ajouter;
    @FXML
    private Button ajout;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button supp;
    @FXML
    private Button menu;
    @FXML
    private Button service;
    @FXML
    private Button liste;
    @FXML
    private Button ajoutN;
    @FXML
    private Button modifierN;
    @FXML
    private Button supprimerN;
    @FXML
    private Button listeN;
    @FXML
    private Button annuler;
    @FXML
    private TextField idfiliere;
    @FXML
    private TextField idNiveau;
    @FXML
    private TextField idModule;
    @FXML
    private TextField titrefiliere;
    @FXML
    private TextField codefiliere;
    @FXML 
    private TextField anneeaccreditation;
    @FXML
    private TextField anneefinaccreditation;
    
    
    
  
    
    //Ajouter
    public void ajouterFiliere(ActionEvent event) throws IOException, ClassNotFoundException {
        checkFiliere();

    }
    
    public void checkFiliere() throws ClassNotFoundException, IOException {
    	
    	String id = idfiliere.getText().toString();
    	String titre = titrefiliere.getText().toString();
    	String code = codefiliere.getText().toString();
    	String da = anneeaccreditation.getText().toString();
    	String dfa = anneefinaccreditation.getText().toString();
    	
    	String sql="INSERT into filiere(idFiliere, titreFiliere, codeFiliere, anneeaccreditation, anneeFinaccreditation)"
    			+ "VALUES (?,?,?,?,?)";
    	
		try (Connection conn = Access.connectDB("javaprojet");) {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, id);
			statement.setString(2, titre);
			statement.setString(3, code);
			statement.setString(4, da);
			statement.setString(5, dfa);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new filiere was inserted successfully!");
		        MainAd m = new MainAd();
		        m.changeScene("Liste.fxml");

				
			}
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("No filiere was inserted!");
			e.printStackTrace();
		}

    }
    

    
    //Modifier
    public void modifierFiliere(ActionEvent event) throws IOException, ClassNotFoundException {
        modFiliere();

    }
    
    public void modFiliere() throws ClassNotFoundException, IOException {
    	
    	String id0 = id.getText().toString();
    	String id = idfiliere.getText().toString();
    	String titre = titrefiliere.getText().toString();
    	String code = codefiliere.getText().toString();
    	String da = anneeaccreditation.getText().toString();
    	String dfa = anneefinaccreditation.getText().toString();
    	
		try (Connection conn = Access.connectDB("javaprojet");) {

			String sql="update filiere set idFiliere=?, titreFiliere=?, codeFiliere=?, anneeaccreditation=?, anneefinaccreditation=? where idFiliere=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,id);
			statement.setString(2,titre);
			statement.setString(3, code);
			statement.setString(4, da);
			statement.setString(5, dfa);
			statement.setString(6,id0);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new filiere was inserted successfully!");
		        MainAd m = new MainAd();
		        m.changeScene("Liste.fxml"); }
			
			else{
				
			}
			statement.close();
			conn.close(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    
    
    
    //Supprimer
    public void supprimerFiliere(ActionEvent event) throws IOException, ClassNotFoundException {
        suppFiliere();

    }
    
    public void suppFiliere() throws ClassNotFoundException, IOException {

    	String id = idfiliere.getText().toString();

		try (Connection conn = Access.connectDB("javaprojet");) {

			String sql="DELETE FROM filiere where idFiliere=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,id);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new filiere was inserted successfully!");
		        MainAd m = new MainAd();
		        m.changeScene("Liste.fxml"); }
			
			else{
				
			}
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    
    
    
    
    
	
    //Supprimer
      public void supprimerNiveau(ActionEvent event) throws IOException, ClassNotFoundException {
          suppNiveau();

      }
      
      public void suppNiveau() throws ClassNotFoundException, IOException {

      	String id = idNiveau.getText().toString();

  		try (Connection conn = Access.connectDB("javaprojet");) {

  			String sql="DELETE FROM niveau where idNiveau=?";
  			
  			PreparedStatement statement = conn.prepareStatement(sql);
  			statement.setString(1,id);

  			int rowsInserted = statement.executeUpdate();
  			if (rowsInserted > 0) {
  				System.out.println("A new filiere was inserted successfully!");
  		        MainAd m = new MainAd();
  		        m.changeScene("ListeNiveau.fxml"); }
  			
  			else{
  				
  			}
  			statement.close();
  			conn.close();
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}

      }
    
    
    
    
    
    
    
    
      
      
      
      
      
  	
      //Supprimer
        public void supprimerModule(ActionEvent event) throws IOException, ClassNotFoundException {
            suppModule();

        }
        
        public void suppModule() throws ClassNotFoundException, IOException {

			String id = idModule.getText().toString();

    		try (Connection conn = Access.connectDB("javaprojet");) {

    			String sql="DELETE FROM module where idModule=?";
    			
    			PreparedStatement statement = conn.prepareStatement(sql);
    			statement.setString(1,id);

    			int rowsInserted = statement.executeUpdate();
    			if (rowsInserted > 0) {
    				System.out.println("A new filiere was inserted successfully!");
    		        MainAd m = new MainAd();
    		        m.changeScene("ListeModule.fxml"); }
    			
    			else{
    				
    			}
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

        	String sql="INSERT into compte(idRole, idUtilisateur, password) VALUES (?,?,?) AND";
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
    				statement.setString(1, "1");
    				statement.setString(2, id);
    				statement.setString(3, password);
    				
    				int rowsInserted = statement.executeUpdate();
    				if (rowsInserted > 0) {
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
    			System.out.println("!");
    			e.printStackTrace();
    		}

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
    
    
    public void liste(ActionEvent event7) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("Liste.fxml");

    }

    
    
    
    public void ajouterM(ActionEvent event2) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("AjouterNiveau.fxml");

    }
    
    public void modifierM(ActionEvent event3) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("ModifierNiveau.fxml");

    }
    
    public void supprimerM(ActionEvent event4) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("SupprimerNiveau.fxml");

    }
    
    public void listeM(ActionEvent event7) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("ListeModule.fxml");

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
    
    
    public void listeC(ActionEvent event7) throws IOException {
        MainAd m = new MainAd();
        m.changeScene("CompteListe.fxml");

    }
    
    

    
}



