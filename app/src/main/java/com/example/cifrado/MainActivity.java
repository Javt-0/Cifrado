package com.example.cifrado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnCif = findViewById(R.id.btnCifrado);
        final Button btDesc = findViewById(R.id.btnDescifrar);

        //
        final EditText txtArriba = findViewById(R.id.txtArri);
        final EditText txtAbajo = findViewById(R.id.txtAbaj);

        btnCif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtDescifrado = String.valueOf(txtArriba.getText());
                txtAbajo.setText(" ");
                txtAbajo.setText(cifradoCesar(txtDescifrado, 3));

            }
        });

        btDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtCifrado = String.valueOf(txtAbajo.getText());
                txtArriba.setText(" ");
                txtArriba.setText(descifradoCesar(txtCifrado, 3));
            }
        });

    }


    //método para cifrar el texto
    private String cifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

    //método para descifrar el texto
    private String descifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
    }

}