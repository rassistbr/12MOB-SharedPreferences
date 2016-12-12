package com.example.rm31675.persistencia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkConectado();
    }

    public void logar(View v){
        String usuario = ((EditText) findViewById(R.id.etUsuario)).getText().toString();
        String senha= ((EditText) findViewById(R.id.etSenha)).getText().toString();

        CheckBox cbManterConectado = (CheckBox) findViewById(R.id.checkBox);
        if(usuario.equals("admin") && senha.equals("123")){
            salvarPreferencias(usuario, cbManterConectado.isChecked());
            abrirTela();
        }

    }

    private void checkConectado(){
        SharedPreferences settings = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE);
        if(settings.getBoolean("manterConectado",false)){
            abrirTela();
        }
    }

    private void abrirTela() {
        startActivity(new Intent(this, LivrosActivity.class));
    }

    private void salvarPreferencias(String usuario, boolean isConectado) {
        SharedPreferences settings = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE);
        SharedPreferences.Editor e = settings.edit();
        e.putString("ususario",usuario);
        e.putBoolean("manterConectado", isConectado);
        e.commit();
    }
}
