package com.example;

public enum Naipe {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    private String nome;

    Naipe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
