package com.example;

import java.util.Random;

public class EstrategiaFactory {
    private static final Random random = new Random();

    public static EstrategiaDeParada criarEstrategiaAleatoria() {
        if (random.nextBoolean()) {
            return new EstrategiaCautelosa();
        } else {
            return new EstrategiaAgressiva();
        }
    }
}