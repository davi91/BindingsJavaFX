package dad.javafx.binding.custom;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

public class PowBinding extends DoubleBinding {

	private DoubleExpression b, e;
	
	public PowBinding(DoubleExpression b, DoubleExpression e) {
		super();
		this.b = b;
		this.e = e;
		bind(b,e); // Vinculamos los parámetros, para que se dispare computeValue cuando se modifiquen
	}
	
	@Override
	protected double computeValue() {
		
		return Math.pow(b.get(), e.get());
	}

}
