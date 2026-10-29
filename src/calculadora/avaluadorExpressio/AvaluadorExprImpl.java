package calculadora.avaluadorExpressio;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;





public class AvaluadorExprImpl implements AvaluadorExpr {

	private enum Operator {
		ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);

		final int precedence;

		Operator(int p) {
			precedence = p;
		}
	}

	private static Map<String, Operator> ops = new HashMap<String, Operator>() {

		private static final long serialVersionUID = 595108312229711621L;

		{
			put("+", Operator.ADD);
			put("-", Operator.SUBTRACT);
			put("*", Operator.MULTIPLY);
			put("/", Operator.DIVIDE);
		}
	};

	private static boolean isHigerPrec(String op, String sub) {
		return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(op).precedence);
	}

	@Override
	public List<String> aTokens(String expr) throws ExpressioException {

		List<String> output = new ArrayList<>();

		ExprTokenizer tokenizer = new ExprTokenizer(expr);
		while (tokenizer.hasMoreElements()) {
			try {
				output.add(tokenizer.nextElement());
			} catch (ExprTokenizer.MyTokenizerException e) {
				throw new ExpressioException("processant " + expr, e);
			}
		}

		return output;
	}

	@Override
	public List<String> aPostfix(List<String> tokens) throws ExpressioException {

		Deque<String> stack = new LinkedList<>();
		List<String> output = new ArrayList<>();

		for (String token : tokens) {
			// operator
			if (ops.containsKey(token)) {
				while (!stack.isEmpty() && isHigerPrec(token, stack.peek())) {
					output.add(stack.pop());
				}
				stack.push(token);

				// left parenthesis
			} else if (token.equals("(")) {
				stack.push(token);

				// right parenthesis
			} else if (token.equals(")")) {

				while (true) {
					String item = stack.peek();
					if (item == null) {
						throw new ExpressioException("no s'ha trobat (");
					} else if (item.equals("(")) {
						stack.pop();
						break;
					} else {
						output.add(stack.pop());
					}
				}

				// digit
			} else {
				output.add(token);
			}

			// System.out.println(token + ": " + output + " <====> " + stack);
		}

		while (!stack.isEmpty()) {
			output.add(stack.pop());
		}

		return output;
	}

	@Override
	public double avalua(List<String> infix) throws ExpressioException {

		Deque<Double> stack = new LinkedList<>();
		for (String token : infix) {

			double result;
			if ("+".equals(token)) {
				result = pop(stack) + pop(stack);
				stack.push(result);
			} else if ("-".equals(token)) {
				result = -pop(stack) + pop(stack);
				stack.push(result);
			} else if ("*".equals(token)) {
				result = pop(stack) * pop(stack);
				stack.push(result);
			} else if ("/".equals(token)) {
				result = 1 / (pop(stack) / pop(stack));
				if (Double.isInfinite(result)) {
					throw new ArithmeticException("divisió per zero!");
				} else if (Double.isNaN(result)) {
					throw new ArithmeticException("divisió de zero per zero!");
				}

				stack.push(result);
			} else {
				try {
					stack.push(Double.parseDouble(token));
				} catch (NumberFormatException e) {
					throw new ExpressioException("no és un double: " + token);
				}
			}
		}

		return stack.pop();
	}

	private double pop(Deque<Double> stack) throws ExpressioException {

		if (stack.isEmpty()) {
			throw new ExpressioException("stack buida!");
		}

		return stack.pop();
	}

}
