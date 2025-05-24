package com.example;

public class Jogo {
    protected Monte monte;
    protected Computador computador;
    protected Jogador jogador;

    public Jogo() {
        monte = new Monte();
        monte.embaralhar();
        computador = new Computador();
        jogador = new Jogador();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public String resultado() {
        // Empate acima de 21
        if (jogador.getPontos() > 21 && computador.getPontos() > 21) {
            if (jogador.getPontos() == computador.getPontos()) {
                return "Empate! Ambos estouraram com a mesma pontuação.";
            }
            // O jogador que estourou primeiro perde
            return "Você perdeu!";
        }

        // Jogador estourou
        if (jogador.getPontos() > 21) {
            return "Você perdeu!";
        }

        // Computador estourou
        if (computador.getPontos() > 21) {
            return "Você ganhou!";
        }

        // Ganha com mais pontos
        if (jogador.getPontos() > computador.getPontos()) {
            return "Você ganhou!";
        }

        // Perde com menos pontos
        if (jogador.getPontos() < computador.getPontos()) {
            return "Você perdeu!";
        }

        // Empate com menos de 21
        return "Empate!";
    }

    public boolean acabou() {
        // O jogo acaba quando:
        // algum jogador estourou
        // ambos os jogadores pararam
        return jogador.getPontos() > 21 ||
                computador.getPontos() > 21 ||
                (jogador.parou && computador.parou);
    }

    public Carta distribuirCartaParaJogador(Jogador jogador) {
        if (jogador.parou) {
            return null;
        }
        Carta carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }

    public Computador getComputador() {
        return computador;
    }
}
