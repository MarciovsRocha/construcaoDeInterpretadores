package Calculator;

public class Separador extends Element {
    private char element;

    public Separador(char e) throws Exception {
        if (('(' == e) || (')' == e)){
            this.element = e;
        }else {
            throw new Exception("Invalid element!");
        }
    }
    public Separador(String e) throws Exception{
        if (e.equals("(") || e.equals(")")){
            this.element = e.charAt(0);
        }else {
            throw new Exception("Invalid element!");
        }
    }

    public char GetSeparador(){
        return this.element;
    }
}
