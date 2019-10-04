package dad.javafx.binding.custom;

import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleDoubleProperty;

public class UtilBinding {

	public static PowBinding Pow(DoubleExpression b, DoubleExpression e) {
		return new PowBinding(b,e);
	}
	
	public static PowBinding Pow(DoubleExpression b, Double e) {
		return new PowBinding(b,new SimpleDoubleProperty(e));		
	}
	
	public static PowBinding Pow(Double b, DoubleExpression e) {
		return new PowBinding(new SimpleDoubleProperty(b),e);		
	}
	
	public static SqrtBinding Sqrt(Double n) {
		return new SqrtBinding(new SimpleDoubleProperty(n));
	}
	
	public static SqrtBinding Sqrt(DoubleExpression n) {
		return new SqrtBinding(n);
	}
	
	public static TrimBinding trim(StringExpression str) {
		return new TrimBinding(str);
	}
}
