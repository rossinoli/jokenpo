package com.example.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Player1SetupActivity extends AppCompatActivity {

    private EditText editNomeP1;
    private Button btnProximo;
    private int totalRounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1_setup);

        // Recupera o valor de rounds vindo da tela anterior
        totalRounds = getIntent().getIntExtra("totalRounds", 1);

        editNomeP1 = findViewById(R.id.editNomePlayer1);
        btnProximo = findViewById(R.id.btnProximoP1);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeP1 = editNomeP1.getText().toString();

                if (!nomeP1.isEmpty()) {
                    // AGORA ATIVADO: Vai para a tela do Player 2 (Vermelha) ✅
                    Intent intent = new Intent(Player1SetupActivity.this, Player2SetupActivity.class);

                    // Passando a mochila de dados para a próxima tela
                    intent.putExtra("totalRounds", totalRounds);
                    intent.putExtra("nomeP1", nomeP1);

                    startActivity(intent);
                } else {
                    Toast.makeText(Player1SetupActivity.this, "Digite seu nome!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}