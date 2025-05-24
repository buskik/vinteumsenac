package com.example;

public class Computador extends Jogador {
    private EstrategiaDeParada estrategia = EstrategiaFactory.criarEstrategiaAleatoria();

    @Override
    public boolean parar() {
        this.parou = estrategia.deveParar(this);
        return this.parou;
    }

    public void definirNovaEstrategia() {
        this.estrategia = EstrategiaFactory.criarEstrategiaAleatoria();
        if (this.estrategia instanceof EstrategiaAgressiva) {
            System.out.println("Computador escolheu a estratégia agressiva.");
        } else {
            System.out.println("Computador escolheu a estratégia cautelosa.");
        }
    }
}
