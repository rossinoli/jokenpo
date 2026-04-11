package com.example.jokenpo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class JogoDuploActivity extends AppCompatActivity {

    private TextView textPlacar, textVezDoJogador, textRodada;
    private ImageButton btnPedra, btnPapel, btnTesoura;
    private LinearLayout layoutFundo;

    private int totalRounds, rodadaAtual = 1;
    private String nomeP1, nomeP2;
    private int pontosP1 = 0, pontosP2 = 0;

    private String escolhaP1 = "";
    private boolean ehVezDoP1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_duplo);

        totalRounds = getIntent().getIntExtra("totalRounds", 1);
        nomeP1 = getIntent().getStringExtra("nomeP1");
        nomeP2 = getIntent().getStringExtra("nomeP2");

        textPlacar = findViewById(R.id.textPlacar);
        textVezDoJogador = findViewById(R.id.textVezDoJogador);
        textRodada = findViewById(R.id.textRodada);
        btnPedra = findViewById(R.id.btnPedraDuplo);
        btnPapel = findViewById(R.id.btnPapelDuplo);
        btnTesoura = findViewById(R.id.btnTesouraDuplo);
        layoutFundo = findViewById(R.id.layoutJogoDuplo);

        atualizarTela();

        btnPedra.setOnClickListener(v -> processarJogada("pedra"));
        btnPapel.setOnClickListener(v -> processarJogada("papel"));
        btnTesoura.setOnClickListener(v -> processarJogada("tesoura"));
    }

    private void processarJogada(String escolha) {
        if (ehVezDoP1) {
            escolhaP1 = escolha;
            ehVezDoP1 = false;
            atualizarTela();
            Toast.makeText(this, "Vez de " + nomeP2 + "!", Toast.LENGTH_SHORT).show();
        } else {
            compararJogadas(escolhaP1, escolha);
            ehVezDoP1 = true;

            if (rodadaAtual >= totalRounds) {
                textPlacar.setText(nomeP1 + ": " + pontosP1 + "  |  " + nomeP2 + ": " + pontosP2);
                new Handler().postDelayed(this::mostrarResultadoFinal, 1000);
            } else {
                rodadaAtual++;
                atualizarTela();
            }
        }
    }

    private void compararJogadas(String p1, String p2) {
        if (p1.equals(p2)) {
            Toast.makeText(this, "EMPATE!", Toast.LENGTH_SHORT).show();
        } else if ((p1.equals("pedra") && p2.equals("tesoura")) ||
                (p1.equals("papel") && p2.equals("pedra")) ||
                (p1.equals("tesoura") && p2.equals("papel"))) {
            pontosP1++;
            Toast.makeText(this, "Ponto para " + nomeP1 + "!", Toast.LENGTH_SHORT).show();
        } else {
            pontosP2++;
            Toast.makeText(this, "Ponto para " + nomeP2 + "!", Toast.LENGTH_SHORT).show();
        }
    }

    private void atualizarTela() {
        textPlacar.setText(nomeP1 + ": " + pontosP1 + "  |  " + nomeP2 + ": " + pontosP2);
        textRodada.setText("Rodada " + rodadaAtual + " de " + totalRounds);

        if (ehVezDoP1) {
            textVezDoJogador.setText("VEZ DE: " + nomeP1.toUpperCase());
            layoutFundo.setBackgroundColor(Color.parseColor("#3D8DDC"));
        } else {
            textVezDoJogador.setText("VEZ DE: " + nomeP2.toUpperCase());
            layoutFundo.setBackgroundColor(Color.parseColor("#E53935"));
        }
    }

    private void mostrarResultadoFinal() {
        String titulo;
        String mensagem;

        if (pontosP1 > pontosP2) {
            titulo = "🏆 " + nomeP1.toUpperCase() + " VENCEU!";
            mensagem = "Parabéns " + nomeP1 + "!\nResultado: " + pontosP1 + " a " + pontosP2;
        } else if (pontosP2 > pontosP1) {
            titulo = "🏆 " + nomeP2.toUpperCase() + " VENCEU!";
            mensagem = "Parabéns " + nomeP2 + "!\nResultado: " + pontosP2 + " a " + pontosP1;
        } else {
            titulo = "🤝 EMPATE!";
            mensagem = "O jogo terminou empatado em " + pontosP1 + " a " + pontosP2;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.setCancelable(false);

        // ATUALIZADO: Limpa a pilha e volta para a MainActivity
        builder.setPositiveButton("SAIR PARA O MENU", (dialog, which) -> {
            Intent intent = new Intent(JogoDuploActivity.this, MainActivity.class);
            // Flags para destruir as telas de setup que ficaram no fundo
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        builder.create().show();
    }
}