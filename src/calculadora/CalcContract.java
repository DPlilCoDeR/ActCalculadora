package calculadora;

import calculadora.avaluadorExpressio.AvaluadorExpr;



public interface CalcContract {

    interface CalcView {

        void setPresenter(CalcPresenter p);

        // methods called by presenter:
        String getInput();

        void setInput(String input);

        String getOutput();

        void setOutput(String output);
    }

    interface CalcPresenter {
        void setModel(AvaluadorExpr m);

        void setView(CalcView v);

        // methods called by view:
        void expressionChar(char c);

        void deleteChar();

        void clear();
    }

   
}
