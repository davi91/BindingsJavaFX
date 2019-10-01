package dad.binding.hola;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HolaApp extends Application {

	/*
	 * Los cambios que se hagan en el nombre
	 * se reflejan en la etiqueta
	 */
	private TextField nameText;
	private Label helloLabel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		nameText = new TextField();
		nameText.setPromptText("Introduzca su nombre");
		nameText.setPrefColumnCount(10); // Tamaño de W mayúscula
		helloLabel = new Label("-");
		
		VBox root = new VBox(5, nameText, helloLabel);
		root.setAlignment(Pos.CENTER);
		root.setFillWidth(false); // Una alternativa para evitar el maxWidth, no expande los componentes a lo ancho, utliza el prefferedWidth
		
		// Ahora los bindings, aprovechamos la clase Bindings
		helloLabel.textProperty().bind(Bindings.concat("Hola ", nameText.textProperty(), " !"));
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Ejemplo de bindings");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
