package Calculator;

public class Calculadora {
    private Stack memory;
    private Stack notation;   // non-printable element
    private String _notation; // printable elements

    public Calculadora(int memorySize){
        this.memory = new Stack(memorySize);
        this.notation = new Stack(memorySize);
        this._notation = "";
    }
    public Calculadora(){
        this.memory = new Stack();
        this.notation = new Stack();
        this._notation = "";
    }

    public void InsertNotation(String newNotation) throws Exception{
        Clear();
        Element element = null;

        for (String s : newNotation.split(" ")){
            switch (TypeOf(s)){
                case 0: element = new Operando(s); break;
                case 1: element = new Separador(s); break;
                case 2: element = new Operador(s); break;
                case -1: throw new Exception("Invalid Element!");
            }
            this.notation.Add(element);
            this._notation+=s+" ";
        }
        System.out.println(this._notation);
    }

    public String GetNotation(){
        return this._notation;
    }

    private Operando ExecuteOperation(){
        return new Operando(0.0);
    }

    public double Calculate(){
        Operando r = ExecuteOperation();
        return r.GetOperando();
    }

    private void Clear(){
        this._notation = "";
        while (!this.memory.Empty()){
            try{
                this.memory.Remove();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
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
            Operando operando = new Operando(s);
            return 0;
        }catch (Exception a){
            try{
                Separador separador = new Separador(s);
                return 1;
            }catch (Exception ne){
                try {
                    Operador operador = new Operador(s);
                    return 2;
                }catch (Exception f){
                    f.printStackTrace();
                }
            }
        }
        return -1;
    }

}
