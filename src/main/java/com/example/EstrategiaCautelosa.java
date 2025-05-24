package com.example;

public class EstrategiaCautelosa implements EstrategiaDeParada {
    @Override
    public boolean deveParar(Jogador computador) {
        return computador.getPontos() >= 16;
    }
}