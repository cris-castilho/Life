package com.example.applife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        boolean b = sharedpreferences.getBoolean("primeira_vez",false);

        if(b){
            inicialTela();
        }
        Button botaoproximo = this.findViewById(R.id.botaoProximo);
        botaoproximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proximaTela();
            }
        });
    }

    public void proximaTela() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("primeira_vez", true);
        editor.commit();
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    public void inicialTela() {
        this.finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
