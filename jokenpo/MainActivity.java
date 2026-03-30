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

    private Button btnJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogar = findViewById(R.id.btnJogar);

        if (btnJogar != null) {
            btnJogar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Abre a tela do jogo
                    Intent intent = new Intent(MainActivity.this, JogoActivity.class);
                    startActivity(intent);
                }
            });
        }
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