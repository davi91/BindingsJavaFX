package dad.javafx.binding.custom;

import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;

public class TrimBinding extends StringBinding {

	private StringExpression str;
	
	public TrimBinding(StringExpression str) {
		super();
		this.str = str;
		bind(str);
	}
	
	@Override
	protected String computeValue() {
		return str.get().trim();
	}

}
