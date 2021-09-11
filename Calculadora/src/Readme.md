# Calculadora

Aluno: Marcio Vinicius de Souza da Rocha

Turma: Bacharelado em Ciência da Computação - Noturno

Data: 09/2021 (Sep. - 2021)

## Descrição

Este projeto é referente à atividade TDE 1 do curso de Construção de Interpretadores,
tendo como objetivo o desenvolvimento de um algoritmo que receberá uma *string* com 
uma Notação Polonesa Reversa, *Reverse Polish Notation*, a seguir segue um exemplo de 
uma RPN.

$Notação Natural: (4+3) * (6-2)$

$RPN: 4 3 + 6 2 - *$

O algoritmo desenvolvido deverá interpretar a *RPN* inserida e retornar o resultado da 
execução de sua notação.

Operações a serem interpretadas

- Adição: representada pelo símbolo **{+}**
- Subtração: representada pelo símbolo **{-}**
- Multiplicação: representada pelo símbolo **{\*}**
- Divisão: representada pelo símbolo **{/}**
- Exponenciação: representada pelo síimbolo **{\|}**
- Raiz Quadrada: representada pelo síimbolo **{\&}**

## Instruções de Uso

Todas as operações contidas na string devem ser atômicas em relação à sua execução, ou seja,
deve-se conter parênteses para encapsulamento de operações para que as mesmas sejam executadas
e retornem o resultado esperado, sendo assim em uma string com mais de uma operação deverá haver
aninhamento de operacoes atômicas.

Observação: Cada elemento deve estar separado por espaços na string, isso vale para todos os 
tipos de elementos(Operadores, Separadores e Operandos). Exemplo: **( 4 3 6 + )**.

**Caso a string informada não esteja de acordo com os parâmetros descritos acima a interpretação da mesma resultará em erro.**

Exemplos de operações atômicas

- Adição: $(\ 3\ 4\ 5\ +\ )$, será realizada a operação de adição de cada valor seguinte do primeiro elemento sobre o primeiro elemento, $(3+4+5)$, o resultado deste exemplo será 12
- Subtração: $(\ 10\ 5\ 3\ 1\ -\ )$, será realizada a operação de subtração de cada valor seguinte do primeiro elemento sobre o primeiro elemento, $(10-5-3-1)$, o resultado deste exemplo será 1
- Multiplicação: $(\ 2\ 6\ 3\ * \ )$, será realizada a operação de multiplicação de cada valor seguinte do primeiro elemento sobre o primeiro elemento, $(2 * 6 * 3)$, o resultado deste exemplo será 36
- Divisão: $(\ 12\ 4\ 2\ / \ )$, será realizada a operação de divisão de cada valor seguinte do primeiro elemento sobre o primeiro elemento, $(12 / 4 / 2)$, o resultado deste exemplo será 1,5
- Exponenciação: $(\ 4\ 2\ 2\ / \ )$, será realizada a operação de exponenciação de cada valor seguinte do primeiro elemento sobre o primeiro elemento, $(4^{2})^{2}$, o resultado deste exemplo será 256
- Raiz Quadrada: $(\ 25\ \& \ )$, será obtida a raiz quadrada do elemento numério antecesso ao simbolo **&** de cada valor seguinte do primeiro elemento sobre o primeiro elemento, $(\sqrt{25})$, o resultado deste exemplo será 5.
  - **Importante!** no caso de uma operação atômica de Raiz quadrada com mais de um elemento numérico será realizada somente a operação sobre o primeiro elemento numérico antecessor ao simbolo **&**, por exemplo $(\ 4\ 49\ 144\ \&\ )$, para esta operação o resultado será 12, pois $(\sqrt{144}=12)$, **os demais elementos dentro desta operação serão descartados**

O funcionamento de execução das operações binárias é igual para as operações de:

- Adição
- Subtração
- Divisão
- Multiplicação

Para este exemplo será utilizada a operação de Multiplicação.

*n = n-ésimo elemento de uma operação atômica, portanto para a operação **( 4 5 10 2 30 7 \* )***

$L = [4, 5, 10, 2, 30, 7]$

$4 \rightarrow n=0; 5 \rightarrow n=1; 10 \rightarrow n=2; \dots; 7 \rightarrow 5$

$f(0) = L_{0}*L_{1}$

$f(n) = L_{n} * f(n-2) \rightarrow D_{f(n)}=\{n \in \mathbb{N}^{*} | 1 < n\}$

*ao executar esta operação serão removidos os elementos na posição 0 e 1, adicionando o resultado da operaçao na cabeça da lista*

após a operação descrita acima a lista ficará da seguinte maneira

$L=[20, 10, 2, 30, 7]$

note que os dois primeiros elementos, 4 e 5, foram substituidos pelo resultado da operação entre eles.

A operação de Exponenciação com mais de 2 elementos funcinoará da seguinte maneira

Considere a operação atômica **( 2 2 3 5 | )**

*n = n-ésimo elemento de uma operação atômica, portanto para a operação **( 2 2 3 5 | )***

$2 \rarr n=0$
$2 \rarr n=1$
$3 \rarr n=2$
$5 \rarr n=3$

$L = [2,2,3,5]$

$f(0) = L_{0} ^{L_{1}}$

$f(n) = L_{n}^{L_{n-2}} \rarr D_{f(n)}=\{ n \in \mathbb{N}^{*} | 1 < n \}$
