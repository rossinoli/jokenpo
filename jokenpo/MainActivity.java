package com.example.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnModoRobo;
    private Button btnModoAmigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnModoRobo = findViewById(R.id.btnModoRobo);
        btnModoAmigo = findViewById(R.id.btnModoAmigo);

        // MODO ROBÔ (1 Player)
        if (btnModoRobo != null) {
            btnModoRobo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, JogoActivity.class);
                    startActivity(intent);
                }
            });
        }

        // MODO AMIGO (2 Players) - ATUALIZADO ✅
        if (btnModoAmigo != null) {
            btnModoAmigo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Agora abre a tela de configuração de rodadas
                    Intent intent = new Intent(MainActivity.this, ConfigRoundsActivity.class);
                    startActivity(intent);
                }
            });
        }

        // Configuração das barras do sistema
        View viewPrincipal = findViewById(R.id.main);
        if (viewPrincipal != null) {
            ViewCompat.setOnApplyWindowInsetsListener(viewPrincipal, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }
}