package dad.binding.celsius2farenheit;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CFApp extends Application {

	private TextField celsiusText;
	private Label farLabel;
	
	private DoubleProperty celsius = new SimpleDoubleProperty(0);
	private DoubleProperty far = new SimpleDoubleProperty(0);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		

		celsiusText = new TextField();
		celsiusText.setPrefWidth(50);
		
		farLabel = new Label();
		
		HBox root = new HBox(5, celsiusText, new Label(" C ="), farLabel);
		root.setFillHeight(false);
		root.setAlignment(Pos.CENTER);
		
		// Ahora aplicaremos bindings aplicando cambios en el campo	: de string a número y otro parámetro que nos sirve de conversión
		Bindings.bindBidirectional(celsiusText.textProperty(), celsius, new NumberStringConverter());	
		
		/* 
		 * Aunque tembién lo podemos hacer así, los textProperty tienens esa capacidad
		 * celsiusText.textProperty().bindBidirectional(celsius, new NumberStringConverter());	
		 */
		far.bind(celsius.multiply(9.0/5.0).add(32)); // Usamos las propiedades del DoubleProperty
		
		farLabel.textProperty().bind(far.asString().concat(" F")); // Casi todos los properties tienen la función para pasarlo a StringBinding(String dinámico)
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Cambio C-F");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
