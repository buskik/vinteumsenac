package com.example;

public class Carta {
    int numero;
    Naipe naipe;

    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public String imagePath() {
        String numberPath = String.valueOf(numero);
        switch (numero) {
            case 1:
                numberPath = "Ace"; // Ás
                break;
            case 11:
                numberPath = "Jack"; // Valete
                break;
            case 12:
                numberPath = "Queen"; // Dama
                break;
            case 13:
                numberPath = "King"; // Rei
                break;
        }
        return "classic-cards/" + numberPath + this.naipe.getNome() + ".png";
    }

    public int getNumero() {
        return numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }
}
