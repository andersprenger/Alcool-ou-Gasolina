package br.poa.andersonsprenger.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view) {
        TextInputEditText precoAlcool       = findViewById(R.id.precoAlcool);
        TextInputEditText precoGasolina     = findViewById(R.id.precoGasolina);
        TextView textoCalculo               = findViewById(R.id.textoCalculo);

        try {
            if (
                    Double.parseDouble(precoAlcool.getText().toString())   /
                    Double.parseDouble(precoGasolina.getText().toString()) <
                    0.7d
            ) {
                textoCalculo.setText("Melhor abastecer com álcool.");
            } else {
                textoCalculo.setText("Melhor abastecer com gasolina.");
            }
        } catch (NumberFormatException | NullPointerException e) {
            textoCalculo.setText("=( Ops, algo não deu certo!");
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}