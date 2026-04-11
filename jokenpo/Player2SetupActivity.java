package com.example.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Player2SetupActivity extends AppCompatActivity {

    private EditText editNomeP2;
    private Button btnProximo;

    // Variáveis para guardar o que veio das telas anteriores
    private int totalRounds;
    private String nomeP1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2_setup);

        // 1. Pega os dados da "mochila" (Intent) que vieram lá do começo
        totalRounds = getIntent().getIntExtra("totalRounds", 1);
        nomeP1 = getIntent().getStringExtra("nomeP1");

        editNomeP2 = findViewById(R.id.editNomePlayer2);
        btnProximo = findViewById(R.id.btnProximoP2);

        // 2. Ação do botão de Confirmar Nome
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeP2 = editNomeP2.getText().toString();

                if (!nomeP2.isEmpty()) {
                    // ATUALIZADO: Agora vamos para a tela de jogo real! ✅
                    Intent intent = new Intent(Player2SetupActivity.this, JogoDuploActivity.class);

                    // Coloca tudo na mochila para o jogo saber quem é quem e quantos rounds jogar
                    intent.putExtra("totalRounds", totalRounds);
                    intent.putExtra("nomeP1", nomeP1);
                    intent.putExtra("nomeP2", nomeP2);

                    startActivity(intent);

                    // Fecha essa tela para não ficar ocupando memória
                    finish();

                } else {
                    Toast.makeText(Player2SetupActivity.this, "Digite o nome do Player 2!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}