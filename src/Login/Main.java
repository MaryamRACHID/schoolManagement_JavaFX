package Login;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage s;
	@Override
	public void start(Stage primaryStage) {
		try {
			s = primaryStage;
			primaryStage.setResizable(false);
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Admin/Admin.fxml"));
			Scene scene = new Scene(root,1000,660);
			primaryStage.setTitle("Bienvenue !");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        s.getScene().setRoot(pane);
    } 
	
	public static void main(String[] args) {
		launch(args);
	}
}
