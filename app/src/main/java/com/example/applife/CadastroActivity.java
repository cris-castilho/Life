package com.example.applife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CadastroActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        final EditText apelido = this.findViewById(R.id.apelidoEditText);
        final RadioGroup sexo = this.findViewById(R.id.sexoRadioGroup);
        final EditText email = this.findViewById(R.id.emailEditText);
        Button botaoproximo = this.findViewById(R.id.btncadastrar);

        botaoproximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(apelido.getText().toString() != "" && email.getText().toString() != "" && sexo.getCheckedRadioButtonId() != -1){

                    RadioButton r = (RadioButton) sexo.getChildAt(sexo.getCheckedRadioButtonId());
                    String selectedtext = r.getText().toString();

                    cadastrar(apelido.getText().toString(),email.getText().toString(),selectedtext);
                }
            }
        });
    }

    private void cadastrar(String apelido, String email, String sexo) {
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("apelido", apelido);
        editor.putString("email", email);
        editor.putString("sexo", sexo);
        editor.commit();

        proximaTela();
    }


    public void proximaTela() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
