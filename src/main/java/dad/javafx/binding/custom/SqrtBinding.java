package dad.javafx.binding.custom;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

public class SqrtBinding extends DoubleBinding {

	private DoubleExpression n;
	
	public SqrtBinding(DoubleExpression n) {
		super();
		this.n = n;
		bind(n);
	}
	
	@Override
	protected double computeValue() {
		return Math.sqrt(n.get());
	}

}
