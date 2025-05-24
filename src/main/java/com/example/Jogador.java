package com.example;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    int pontos;
    List<Carta> cartas;
    boolean parou;

    public Jogador() {
        this.pontos = 0;
        this.cartas = new ArrayList<>();
        this.parou = false;
    }

    public boolean parar() {
        return this.parou = true;
    }

    public List<Carta> getCartas() {
        return this.cartas;
    }

    public void receberCarta(Carta carta) {
        this.cartas.add(carta);

        this.pontos += carta.getNumero();
    }

    public int getPontos() {
        return this.pontos;
    }
}
