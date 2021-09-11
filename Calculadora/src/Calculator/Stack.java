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

    public Element top(){
        return this.myStack[this.top];
    }

    public boolean Full(){
        return (this.myStack.length == (this.top+1));
    }

    public boolean Empty(){
        return (-1 == this.top);
    }

}
