package calculadora.impl;


import calculadora.CalcContract.CalcPresenter;
import calculadora.CalcContract.CalcView;
import calculadora.avaluadorExpressio.AvaluadorExpr;

public class CalcPresenterImpl implements CalcPresenter {

    private CalcView view;
    private String st;

    @Override
    public void setView(CalcView view) {
        this.view = view;
    }
/*
    private calcula() {
           xxx= Avaluador.aTokens(asdfasdf);
           Avaluador.ePostfix(xxxx);
           Avaluador.avalua(zzzz);


    }
*/


  @Override
    public void setModel(AvaluadorExpr model) {
        throw new RuntimeException("no implementat!");
    }
    @Override
    public void expressionChar(char c) {
        throw new RuntimeException("no implementat!");
    }

    @Override
    public void deleteChar() {
        throw new RuntimeException("no implementat!");
    }

    @Override
    public void clear() {
        throw new RuntimeException("no implementat!");
    }

  

}
