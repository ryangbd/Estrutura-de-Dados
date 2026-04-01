package model.estrutura;

public class Pilha<T>{
    private No<T> ultimo = null;

    //push: Insere um elemento em cima da pilha
    //pop: Remove o elemento que está sobre a pilha


    //para compreensão do método e das trocas, segue o exemplo:
    //aux=a
    //a=b
    //b=aux
    public void push(T elemento){
        No<T> novo_ultimo = new No<>(elemento);
        if(this.ultimo != null){
            No<T> auxiliar = this.ultimo;
            novo_ultimo.setAnterior(auxiliar);
        }
            this.ultimo=novo_ultimo;
    }

    public No<T> pop(){
        if(this.ultimo == null){
            return null;
        }
        No<T> elemento = this.ultimo;
        this.ultimo = elemento.getAnterior();

        return elemento;
    }

    @Override
    public String toString(){
        if(this.ultimo==null){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.ultimo;
        builder.append(buffer.getValor());
        while(buffer.getAnterior()!=null){
            builder.append(",");
            buffer = buffer.getAnterior();
            builder.append(buffer.getValor());
        }
        builder.append("]");
        return builder.toString();
    }
}

//isso é coisa de maluco