package dad.javafx.binding.custom;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Main {

	public static void main(String[] args) {
		DoubleProperty a = new SimpleDoubleProperty(3);
		DoubleProperty b = new SimpleDoubleProperty(2);
		DoubleProperty c = new SimpleDoubleProperty();
		
		// c = a^2 + b
		//c.bind(new PowBinding(a, new SimpleDoubleProperty(2)).add(b)); <- Old method
		c.bind(UtilBinding.Pow(a, 2.0).add(b)); // <- Using custom libraries
		System.out.println(c.get());
		
		a.set(5);
		System.out.println(c.get());	
		
		// Ahora con la raiz cuadrada
		c.unbind();
		c.bind(UtilBinding.Sqrt(a).add(b)); // Así podemos usar las expresiones más directamente
		System.out.println(c.get());
		
		a.set(4); // Vuelve a cambiar
		System.out.println(c.get());	
		
		// Para los string
		StringProperty myStr = new SimpleStringProperty("   Hola");
		StringProperty str = new SimpleStringProperty("");
		
		str.bind(UtilBinding.trim(myStr));
		
		System.out.println(str.get());
		
		myStr.set("  Vaya!        ");
		System.out.println(str.get());
	}

}
