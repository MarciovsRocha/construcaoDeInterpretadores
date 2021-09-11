#include <iostream>

class Elemento{};

class Stack{
  private:
    Elemento stack[];
  public:
    Stack(int stackSize){}
};

class Separador: Elemento{
  private: 
    char element;
    bool validElement(char e){
      return (('(' == e) || (')' == e));
    };
  public:
    char getElemento(){
      return element;
    };
};

class Operando: Elemento{
  private:
    double num;
};

class Operador: Elemento{
  private:
    char op;
    bool validOperator(char o){
      char valid[6]={'+','-','*','/','|','&'};
      for(int aux=0;aux<6;aux++){
        if (o == valid[aux]) return true;
      }
      return false;
    };
};



int main() {
  std::cout << "Hello World!\n";
}