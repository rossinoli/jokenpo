package com.example.jokenpo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class JogoActivity extends AppCompatActivity {

    // 1. Declaramos os itens da tela
    private ImageView imageEscolhaApp;
    private TextView textResultado;
    private ImageButton btnPedra, btnPapel, btnTesoura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        // 2. Conectamos o Java com o XML
        imageEscolhaApp = findViewById(R.id.imageEscolhaApp);
        textResultado = findViewById(R.id.textResultado);
        btnPedra = findViewById(R.id.btnPedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);

        // 3. Configuramos os cliques nas mãos
        btnPedra.setOnClickListener(v -> opcaoSelecionada("pedra"));
        btnPapel.setOnClickListener(v -> opcaoSelecionada("papel"));
        btnTesoura.setOnClickListener(v -> opcaoSelecionada("tesoura"));
    }

    // 4. A Lógica do Jogo
    @SuppressLint("SetTextI18n")
    public void opcaoSelecionada(String escolhaUsuario) {

        // Sorteio do App (0 = pedra, 1 = papel, 2 = tesoura)
        int numeroAleatorio = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numeroAleatorio];

        // Atualiza a imagem do App de acordo com o sorteio
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

        // 5. Comparação do Vencedor
        if (
                (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel")) ||
                        (escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
                        (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra"))
        ) { // App Ganhou
            textResultado.setText("Você Perdeu! :( ");
        } else if (
                (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel")) ||
                        (escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                        (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra"))
        ) { // Usuário Ganhou
            textResultado.setText("Você Ganhou! :D ");
        } else { // Empate
            textResultado.setText("Empatamos! ;) ");
        }
    }
}