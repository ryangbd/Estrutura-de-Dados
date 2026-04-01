package controller;

import model.estrutura.*;

public class PilhaController{
    public PilhaController(){
        super();
    }

    public String teste() throws Exception{
        Pilha pilha = new Pilha();

        pilha.push(1);
        pilha.pop();
        pilha.push(2);
        pilha.push(30);

        return pilha.toString();
    }
}