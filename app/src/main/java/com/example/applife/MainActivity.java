package com.example.applife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String apelido = sharedPreferences.getString("apelido","");
        String email = sharedPreferences.getString("email","");
        String sexo = sharedPreferences.getString("sexo","");



//        textView.setText("Bem vindo, "+apelido+email+sexo);
        final ImageView imagemPessoa = findViewById(R.id.imagempessoa);
        final ImageView imagemEstudo = findViewById(R.id.Icone_Estudo);
        final ImageView imagemAtividade = findViewById(R.id.Icone_Atividade_Fisica);
        final ImageView imagemOcio = findViewById(R.id.Icone_Ocio);
        final ImageView imagemTrabalho = findViewById(R.id.Icone_Trabalho);

        imagemEstudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagemPessoa.setImageResource(R.drawable.img_estudof);
            }
        });
        imagemAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagemPessoa.setImageResource(R.drawable.img_atividadef);
            }
        });
        imagemTrabalho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagemPessoa.setImageResource(R.drawable.img_trabalhof);
            }
        });
        imagemOcio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (true){//testar se do sexo masculino
                    imagemPessoa.setImageResource(R.drawable.imagem_ociom);
                } else {
                    imagemPessoa.setImageResource(R.drawable.imagem_ociom);
                }

            }
        });
    }
}
