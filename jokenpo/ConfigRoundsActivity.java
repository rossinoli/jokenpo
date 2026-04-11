package com.example.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ConfigRoundsActivity extends AppCompatActivity {

    private EditText editQuantidadeRounds;
    private Button btnConfirmarRounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_rounds);

        editQuantidadeRounds = findViewById(R.id.editQuantidadeRounds);
        btnConfirmarRounds = findViewById(R.id.btnConfirmarRounds);

        btnConfirmarRounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoRounds = editQuantidadeRounds.getText().toString();

                // Verifica se o usuário não deixou vazio
                if (!textoRounds.isEmpty()) {
                    int rounds = Integer.parseInt(textoRounds);

                    // Abre a tela do Player 1 (Azul) passando a quantidade de rounds
                    Intent intent = new Intent(ConfigRoundsActivity.this, Player1SetupActivity.class);
                    intent.putExtra("totalRounds", rounds);
                    startActivity(intent);

                } else {
                    Toast.makeText(ConfigRoundsActivity.this,
                            "Por favor, digite a quantidade de rounds!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}