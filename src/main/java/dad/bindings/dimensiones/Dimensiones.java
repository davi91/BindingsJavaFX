package dad.bindings.dimensiones;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Dimensiones extends Application {

	private Label xLabel, yLabel, areaLabel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		xLabel = new Label("-");
		
		yLabel = new Label("-");
		
		areaLabel = new Label("-");
		
		VBox root = new VBox(5, xLabel, yLabel, areaLabel);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 320, 200);
		
		// Primero cargarmos nuestras property
		DoubleProperty xSize = new SimpleDoubleProperty(scene.getWidth());
		DoubleProperty ySize = new SimpleDoubleProperty(scene.getHeight());
		
		// Ahora las enlazamos con el scene, de manera que se adaptan a cualquier cambio
		xSize.bind(scene.widthProperty());
		ySize.bind(scene.heightProperty());
		
		// El label nos muestra el resultado en formato texto
		xLabel.textProperty().bind(Bindings.concat("DimX: ", xSize));
		yLabel.textProperty().bind(Bindings.concat("DimY: ", ySize));
		
		// Lo mismo con el área, sólo que con la multiplicación de uno con otro
		DoubleBinding area = xSize.multiply(ySize);
		areaLabel.textProperty().bind(Bindings.concat("Area: ", area)); // Cada vez que cambie el area, cambia el texto
		
		primaryStage.setTitle("Bindings con dimensiones");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
