package com.example.applife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    private String sexo = "";
    private int progresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout imagemPessoa = findViewById(R.id.imagempessoa);
        final ImageView imagemEstudo = findViewById(R.id.Icone_Estudo);
        final ImageView imagemAtividade = findViewById(R.id.Icone_Atividade_Fisica);
        final ImageView imagemOcio = findViewById(R.id.Icone_Ocio);
        final ImageView imagemTrabalho = findViewById(R.id.Icone_Trabalho);
        final ProgressBar progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(4);

        DatabaseHandler db = new DatabaseHandler(this);

        Usuario usr = db.getUsuario(1);
        sexo = usr.getSexo();

        if (sexo.contains("Masculino")){
            imagemPessoa.setBackgroundResource(R.drawable.imagem_ociom);
        }else{
            imagemPessoa.setBackgroundResource(R.drawable.img_ociof);
        }

        imagemEstudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progresso++;
                progressBar.setProgress(progresso);
                if (sexo.contains("Masculino")){
                    imagemPessoa.setBackgroundResource(R.drawable.estudom);
                }else{
                    imagemPessoa.setBackgroundResource(R.drawable.img_estudof);
                }
            }
        });
        imagemAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progresso++;
                progressBar.setProgress(progresso);
                if (sexo.contains("Masculino")){
                    imagemPessoa.setBackgroundResource(R.drawable.atividadem);
                }else{
                    imagemPessoa.setBackgroundResource(R.drawable.img_atividadef);
                }
            }
        });
        imagemTrabalho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progresso++;
                progressBar.setProgress(progresso);
                if (sexo.contains("Masculino")){
                    imagemPessoa.setBackgroundResource(R.drawable.imagem_trabalhom);
                }else{
                    imagemPessoa.setBackgroundResource(R.drawable.img_trabalhof);
                }
                sendNotification("teste","testando notificacao");
            }
        });
        imagemOcio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progresso++;
                progressBar.setProgress(progresso);
                if (sexo.contains("Masculino")){
                    imagemPessoa.setBackgroundResource(R.drawable.imagem_ociom);
                }else{
                    imagemPessoa.setBackgroundResource(R.drawable.img_ociof);
                }
            }
        });

        progressBar.
    }

    public void sendNotification(String title, String message) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);

        //Create the intent that’ll fire when the user taps the notification//

//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.setComponent(new ComponentName("com.example.applife","AppLife"));
//        intent.addCategory(Intent.CATEGORY_LAUNCHER);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

//        mBuilder.setContentIntent(pendingIntent);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentTitle(title);
        mBuilder.setContentText(message);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannel(new NotificationChannel("001","teste",NotificationManager.IMPORTANCE_DEFAULT));
        mNotificationManager.notify(001, mBuilder.build());
    }
}
