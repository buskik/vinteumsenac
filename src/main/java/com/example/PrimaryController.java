package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML
    private HBox mesaDoJogador;
    @FXML
    private HBox mesaDoComputador;
    @FXML
    private ImageView monte;

    @FXML
    private Label pontosMesa;
    @FXML
    private Label pontosJogador;
    @FXML
    private Label resultado;

    private Jogo jogo;

    public void turno() {

        if (jogo.acabou()) {
            resultado.setText(jogo.resultado());
            return;
        }

        jogo.computador.parar();
        if (jogo.getJogador().parou) {
            jogo.distribuirCartaParaJogador(jogo.computador);
            if (jogo.acabou()) {
                resultado.setText(jogo.resultado());
            }
            atualizar();
            turno();
        } else {
            jogo.distribuirCartaParaJogador(jogo.jogador);
            jogo.distribuirCartaParaJogador(jogo.computador);
        }
        atualizar();
        if (jogo.acabou()) {
            resultado.setText(jogo.resultado());
            return;
        }
    }

    public void atualizar() {
        pontosJogador.setText("Jogador: " + jogo.jogador.getPontos());
        pontosMesa.setText("Mesa: " + jogo.computador.getPontos());
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();
        jogo.jogador.getCartas().forEach((carta) -> mesaDoJogador.getChildren().add(imagemCarta(carta)));
        jogo.computador.getCartas().forEach((carta) -> mesaDoComputador.getChildren().add(imagemCarta(carta)));
    }

    public void novoJogo() {
        jogo = new Jogo();

        // Ensure computer gets a new strategy at the start of each game
        jogo.computador.definirNovaEstrategia();

        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();
        pontosJogador.setText("Jogador: 0");
        pontosMesa.setText("Mesa: 0");
        resultado.setText("");
    }

    public void pedirCarta() {
        turno();
    }

    public void parar() {
        if (jogo == null) {
            resultado.setText("Você não iniciou o jogo!");
            return;

        }
        jogo.jogador.parar();
        turno();
    }

    private ImageView imagemCarta(Carta carta) {
        return new ImageView(App.class.getResource(carta.imagePath()).toString());
    }

}
