package calculadora.avaluadorExpressio;

import java.util.Enumeration;

public class ExprTokenizer implements Enumeration<String> {

	int pos;
	char[] expression;

	ExprTokenizer(String expression) {
		this.expression = expression.toCharArray();
		this.pos = 0;
	}

	private enum Type {
		OPERATOR, NUMBER, UNKNOWN
	}

	@Override
	public String nextElement() {
		StringBuilder token = new StringBuilder();
		boolean endOfToken = false;
		Type type = Type.UNKNOWN;
		while (!endOfToken && hasMoreElements()) {
			while (expression[pos] == ' ' && hasMoreElements())
				pos++;
			switch (expression[pos]) {
			case '(':
			case ')':
			case '+':
			case '-':
			case '*':
			case '/':
				if (type != Type.NUMBER) {
					type = Type.OPERATOR;
					token.append(expression[pos]);
					pos++;
				}
				endOfToken = true;
				break;
			case ' ':
				endOfToken = true;
				pos++;
				break;
			default:
				if (Character.isDigit(expression[pos]) || expression[pos] == '.') {
					token.append(expression[pos]);
					type = Type.NUMBER;
				} else {
					throw new MyTokenizerException("not a number: " + expression[pos]);
				}
				pos++;
				break;
			}
		}
		return token.toString();
	}

	@Override
	public boolean hasMoreElements() {
		return pos < expression.length;
	}

	static class MyTokenizerException extends RuntimeException {

		private static final long serialVersionUID = 7602387935898437038L;

		public MyTokenizerException(String message) {
			super(message);
		}
	}
}
