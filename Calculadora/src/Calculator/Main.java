package Calculator;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args){
        // esta calculadora possui uma memoria com 100 posicoes
        // para aumentar ou diminuir a capacidade indique
        // a mesma no construtor, tal que: 0 < capacidade
        Calculadora calculadora = new Calculadora();
        try{
            calculadora.InsertNotation("4 3 + 6 2 - *");
        }catch (Exception e){
            e.printStackTrace();
        }
        calculadora.GetNotation();
        validarCalculadora(calculadora);
    }

    public static void validarCalculadora(Calculadora c){
        String[] teste = {
                "( 2 3 + )",        // 3+2
                "( 2 3 4 * )",      // 4*3*2
                "( 4 2 2 / )",      // 4/2/2
                "( 4 2 | )",        // 4^2
                "( 4 & )",          // 4^(1/2)
                "( ( 4 2 + ) 3 * )" // 3*(4+2)
        };
        double[] resultados = {5.0,24.0,1.0, 16.0, 2.0, 18.0};
        double result = 0.0;
        boolean[] acertos = new boolean[teste.length];
        for (byte aux=0; aux < teste.length; aux++){
            try{
                c.InsertNotation(teste[aux]);
//                result = c.Calculate();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
