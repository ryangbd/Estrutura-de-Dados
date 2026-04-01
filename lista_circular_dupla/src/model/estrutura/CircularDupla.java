package model.estrutura;
import java.lang.Exception;
import model.estrutura.No;
public class CircularDupla<T> {
    private No<T> ultimo = null;

    /*
     * append     Adiciona o elemento no final;
     * get        Retorna um nó dado um index;
     * index      Retorna um índice de um elemento;
     * insert     Insere um elemento em uma determinada posição;
     * last       Retorna o ultimo elemento;
     * remove     Remove um elemento dado o index;
     * size       Retorna o total de elementos;
     */

    public void append(T elemento) {
        No<T> novo = new No<>(elemento);
        if (this.ultimo == null){
            this.ultimo = novo;
            novo.setProximo (novo);
            novo.setAnterior (novo);
        } else {
            No<T> buffer_ultimo = this.ultimo;
            No<T> buffer_proximo = this.ultimo.getProximo();
            novo.setProximo(buffer_proximo);
            novo.setAnterior(buffer_ultimo);
            buffer_proximo.setAnterior (novo);
            buffer_ultimo.setProximo (novo);
            this.ultimo = novo;
        }
    }
    public No<T> getLast() throws IllegalArgumentException {
        if (this.ultimo == null)
            throw new IllegalArgumentException("Nao existe item na lista.");
        return this.ultimo;
    }

    public void remove(No<T> remover) {
        No<T> anterior = remover.getAnterior();
        No<T> proximo = remover.getProximo();
        if (this.ultimo == remover && anterior == remover && proximo == remover) {
            // somente 1 elemento na lista
            this.ultimo = null;
        } else {
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);
            if(this.ultimo == remover) {
                this.ultimo = anterior;
            }
            remover.setProximo(null);
            remover.setAnterior(null);
            remover.setValor(null);
        }
    }

    public void remove() throws IllegalArgumentException {
        remove (getLast());
    }

    public int total() {
        if (this.ultimo == null)
            return 0;
        No<T> buffer = this.ultimo;
        int total = 0;
        do{
            total++;
            buffer = buffer.getProximo();
        } while (buffer != this.ultimo);
        return total;
    }

    @Override
    public String toString() {
        if (this.ultimo == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.ultimo;
        builder.append(buffer.getValor());
        while( buffer.getProximo() != this.ultimo) {
            builder.append(",");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }
        builder.append("]");
        return builder.toString();
    }
}