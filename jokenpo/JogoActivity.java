package com.example.jokenpo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class JogoActivity extends AppCompatActivity {

    private ImageView imageEscolhaApp;
    private TextView textResultado;
    private ImageButton btnPedra, btnPapel, btnTesoura;
    private Button btnVoltar; // Declaração do novo botão

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        imageEscolhaApp = findViewById(R.id.imageEscolhaApp);
        textResultado = findViewById(R.id.textResultado);
        btnPedra = findViewById(R.id.btnPedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);
        btnVoltar = findViewById(R.id.btnVoltar); // Conectando o botão de voltar

        // Cliques nas opções de jogo
        btnPedra.setOnClickListener(v -> opcaoSelecionada("pedra"));
        btnPapel.setOnClickListener(v -> opcaoSelecionada("papel"));
        btnTesoura.setOnClickListener(v -> opcaoSelecionada("tesoura"));

        // Lógica para o botão Voltar
        if (btnVoltar != null) {
            btnVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); // Fecha esta tela e volta para a MainActivity
                }
            });
        }
    }

    @SuppressLint("SetTextI18n")
    public void opcaoSelecionada(String escolhaUsuario) {
        int numeroAleatorio = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numeroAleatorio];

        switch (escolhaApp) {
            case "pedra":
                imageEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel")) ||
                        (escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
                        (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra"))
        ) {
            textResultado.setText("Você Perdeu! :( ");
        } else if (
                (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel")) ||
                        (escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                        (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra"))
        ) {
            textResultado.setText("Você Ganhou! :D ");
        } else {
            textResultado.setText("Empatamos! ;) ");
        }
    }
}