package Calculator;

public class Calculadora {
    private Stack notation;   // non-printable element
    private String _notation; // printable string elements

    public Calculadora(int memorySize){
        this.notation = new Stack(memorySize);
        this._notation = "";
    }
    public Calculadora(){
        this.notation = new Stack();
        this._notation = "";
    }

    public double InsertNotation(String newNotation) throws Exception{
        System.out.print("\n\n===============================\n");
        System.out.println(newNotation + " = ?");
        System.out.println("Calculating...");
        Clear();
        Element element = null;
        boolean subcalc;
        for (String s : newNotation.split(" ")){
            subcalc=false;
            switch (TypeOf(s)){
                case 0: element = new Operando(s); break;
                case 1: element = new Separador(s);
                    subcalc = (s.equals(")"));
                    break;
                case 2: element = new Operador(s); break;
                case -1: throw new Exception("Invalid Element!");
            }
            this.notation.Add(element);
            this._notation+=s+" ";
            if (subcalc) this.notation.Add(new Operando(Calculate()));
        }

        Operando result = (Operando) this.notation.Remove();

        /*
         * Only for debug
         * */
        this._notation += " = " + result.GetOperando();
        System.out.println(_notation);
        /*
         * Only for debug
         * */

        return result.GetOperando();
    }

    public String GetNotation(){
        return this._notation;
    }

    private double ExecuteOperation(Operador operador, Operando[] numeros, int index){
        double result = numeros[index].GetOperando();
        index--;
        switch (operador.GetOperator()){
            case '+': //adicao
                while (0 <= index){
                    result += numeros[index].GetOperando();
                    index--;
                }
                break;
            case '-': //subtracao
                while (0 <= index){
                    result -= numeros[index].GetOperando();
                    index--;
                }
                break;
            case '*': // multiplicacao
                while (0<= index){
                    result *= numeros[index].GetOperando();
                    index--;
                }
                break;
            case '/': // divisao
                while (0<= index){
                    result /= numeros[index].GetOperando();
                    index--;
                }
                break;
            case '|': // exponenciacao
                while (0<= index){
                    result = Math.pow(result,numeros[index].GetOperando());
                    index--;
                }
                break;
            case '&':
                result = Math.pow(result,0.5);
                break;
        }
        return result;
    }

    private double Calculate(){
        Operador operacao = null; // operacao a ser realizada
        Operando[] numeros = new Operando[(this.notation.GetTop()+1)]; // lista de elementos para realizar a operacao
        int index = 0; // index para percorrer o array numeros
        // variaveis utilizadas dentro do laco while que remove elementos da stack
        String removedElementType = "";
        Element removedElement = null;
        // monta a lista de operacao na ordem correta
        try{
            // discards fisrt close statement
            if (this.notation.TopType().equals("Separador.Close"))
                removedElement = this.notation.Remove();
            // get operation
            if (this.notation.TopType().equals("Operador"))
                operacao = (Operador) this.notation.Remove();
            // prepare number list
            while (! removedElementType.equals("Separador.Open")){
                removedElementType = this.notation.TopType();
                removedElement = this.notation.Remove();
                // caso o elemento do topo seja um operando adiciona ele no array
                if (removedElementType.equals("Operando")){
                    numeros[index] = (Operando)removedElement;
                    index++;
                }
            }
            index--; // move index to last element into numbers
        }catch (Exception e){
            e.printStackTrace();
        }

        /*
        * Only for debug
        * */
        int aux = index;
        while (0 <= aux){
            System.out.print(numeros[aux].GetOperando());
            if (0 != aux) System.out.print(operacao.GetOperator());
            aux--;
        }
        System.out.print("\n");
        /*
         * Only for debug
         * */

        return ExecuteOperation(operacao,numeros,index);
    }

    private void Clear(){
        this._notation = "";
        while (!this.notation.Empty()){
            try{
                this.notation.Remove();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private byte TypeOf(String s){
        try{
            new Operando(s);
            return 0;
        }catch (Exception a){
            try{
                new Separador(s);
                return 1;
            }catch (Exception ne){
                try {
                    new Operador(s);
                    return 2;
                }catch (Exception f){
                    f.printStackTrace();
                }
            }
        }
        return -1;
    }

}
