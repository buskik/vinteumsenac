package com.example;

public class EstrategiaAgressiva implements EstrategiaDeParada {
    @Override
    public boolean deveParar(Jogador computador) {
        return computador.getPontos() >= 19;
    }
}