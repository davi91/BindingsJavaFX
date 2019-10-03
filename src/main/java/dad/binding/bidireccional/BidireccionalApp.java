package dad.binding.bidireccional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BidireccionalApp extends Application {

	private TextField text1, text2;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		text1 = new TextField();
		text2 = new TextField();

		VBox root = new VBox(5, text1, text2);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);
		
		// Bindings, ahora los dos están unidos, por tanto los cambio de uno se reflejan en el otro
		text1.textProperty().bindBidirectional(text2.textProperty());
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Ejemplo binding bidireccional");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
