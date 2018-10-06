package com.example.diego.pedrapapeloutesoura;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolhaPedra(View view) {
        realizarJogada("pedra");
    }

    public void escolhaPapel(View view) {
        realizarJogada("papel");
    }

    public void escolhaTesoura(View view) {
        realizarJogada("tesoura");
    }

    public void realizarJogada(String jogada) {
        String jogadas[] = {"pedra", "papel", "tesoura"};
        ImageView imagemAdversario = findViewById(R.id.escolhaAdversario);

        String escolhaAdversaria = jogadas[new Random().nextInt(3)];

        switch (escolhaAdversaria) {
            case "pedra":
                imagemAdversario.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemAdversario.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemAdversario.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((escolhaAdversaria == "pedra" && jogada == "papel") ||
                (escolhaAdversaria == "papel" && jogada == "tesoura") ||
                (jogada == "pedra" && escolhaAdversaria == "tesoura")) {
            exibeResultado("vitoria");
        } else if ((escolhaAdversaria == "pedra" && jogada == "tesoura") ||
                (jogada == "pedra" && escolhaAdversaria == "papel") ||
                (jogada == "papel" && escolhaAdversaria == "tesoura")) {
            exibeResultado("derrota");
        } else {
            exibeResultado("empate");
        }
    }

    public void exibeResultado(String resultado) {
        TextView textoResultado = findViewById(R.id.textViewResultado);
        String textosDerrota[] = {"Você perdeu :(", "Que pena! tente mais uma vez", "Não foi dessa vez :/"};
        String textosVitória[] = {"Yes! você mandou ver!", "Você venceu!", "Wow, você venceu! =O"};

        int numeroTexto = new Random().nextInt(3);

        if (resultado == "empate") {
            textoResultado.setText("Empatou! =O");
        } else if (resultado == "vitoria") {
            textoResultado.setText(textosVitória[numeroTexto]);
        } else {
            textoResultado.setText(textosDerrota[numeroTexto]);
        }

    }
}
