package Calculator;

public class Stack {
    private int top;
    private Element[] myStack;

    public Stack(int tamanho){
        this.top = -1;
        this.myStack = new Element[tamanho];
    }
    public Stack(){
        this.top = -1;
        this.myStack = new Element[100];
    }

    public int Add(Element e) throws Exception{
        if (!Full()){
            this.top++;
            this.myStack[this.top] = e;
            return 0;
        }
        throw new Exception("Stack Overflow");
    }

    public Element Remove() throws Exception{
        if (!Empty()){
            this.top--;
            return this.myStack[(this.top+1)];
        }
        throw new Exception("Stack Underflow");
    }

    public int GetTop(){
        return this.top;
    }

    public boolean Full(){
        return (this.myStack.length == (this.top+1));
    }

    public boolean Empty(){
        return (-1 == this.top);
    }

    public String TopType(){
        String result = this.myStack[this.top].getClass().getSimpleName();
        if (result.equals("Separador")){
            Separador s = (Separador)this.myStack[this.top];
            if ('(' == s.GetSeparador())
                result+=".Open";
            else if (')' == s.GetSeparador())
                result+=".Close";
        }
        return result;
    }


}
