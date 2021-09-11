package Calculator;

public class Operando extends Element{
    private final double num;

    public Operando(double number){
        this.num = number;
    }
    public Operando(String number){
        this.num = Double.parseDouble(number);
    }
    public Operando(char number){
        this.num = Character.getNumericValue(number);
    }
    public double GetOperando(){
        return this.num;
    }
}
