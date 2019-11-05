package com.example.applife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

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
        TextView textView = this.findViewById(R.id.message_pessoa);

        textView.setText("Bem vindo, "+apelido+sexo+email);
    }
}
