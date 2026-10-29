package calculadora.avaluadorExpressio;

import java.util.List;

public interface AvaluadorExpr {
	
	/**
	 * converteix una cadena a una llista de tokens
	 * @param expr
	 * @return
	 * @throws TokenException
	 */
	List<String> aTokens(String expr) throws ExpressioException;

	/**
	 * converteix una expressio infix a postfix
	 * 
	 * @param expr
	 * @return
	 */
	List<String> aPostfix(List<String> infix) throws ExpressioException;

	/**
	 * avalua una expressio postfix
	 * 
	 * @param infix
	 * @return
	 */
	double avalua(List<String> postfix) throws ExpressioException;
}
