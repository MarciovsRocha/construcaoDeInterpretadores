import Calculator.*;

public class Main {
    public static void main(String[] args){
        // esta calculadora possui uma memoria com 100 posicoes
        // para aumentar ou diminuir a capacidade indique
        // a mesma no construtor, tal que: 0 < capacidade
        Calculadora calculadora = new Calculadora();
        System.out.println("Acuracidade: " + validarCalculadora(calculadora));
    }

    public static double validarCalculadora(Calculadora c){
        String[] teste = {
                "( 2 3 + )",        // 3+2
                "( 2 3 4 * )",      // 4*3*2
                "( 4 2 2 / )",      // 4/2/2
                "( 4 2 | )",        // 4^2
                "( 4 & )",          // 4^(1/2)
                "( ( 4 2 + ) 3 * )", // 3*(4+2)
                "( ( 3 4 + ) ( 4 ( 1 1 + ) / ) * )"
        };
        double[] resultados = {5.0,24.0,1.0, 16.0, 2.0, 18.0,14.0};
        int acertos = 0;
        for (byte aux=0; aux < teste.length; aux++){
            try{
                if (c.InsertNotation(teste[aux]) == resultados[aux])
                    acertos++;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ((acertos*100)/ resultados.length);
    }
}
