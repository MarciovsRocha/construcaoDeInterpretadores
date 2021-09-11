package Calculator;

public class Operador extends Element{
    private char op;

    public Operador(char c) throws Exception {
        if (ValidChar(c))
            this.op = c;
        else
            throw new Exception("Invalid operator!");
    }
    public Operador(String c) throws Exception{
        if (ValidChar(c.charAt(0)))
            this.op = c.charAt(0);
        else
            throw new Exception("Invalid operator!");
    }

    public char GetOperator(){
        return this.op;
    }

    private boolean ValidChar(char c){
        char[] validChars = {'+','-','*','/','|','&'};
        for (byte i=0; i < validChars.length; i++){
            if (c == validChars[i]) return true;
        }
        return false;
    }
}
