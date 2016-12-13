package com.example.rm31675.persistencia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rm31675.persistencia.dao.LivroDAO;
import com.example.rm31675.persistencia.model.Livro;

public class LivrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        LivroDAO dao = new LivroDAO();
  //      dao.carregaDados();

        seed();

    }

    public void seed() {
        LivroDAO dao = new LivroDAO();

        Livro android = new Livro();
        android.setAutor("Ricardo Lachetta");
        android.setEditora("Novatec");
        android.setTitulo("Google Android");
        dao.insereDado(android);

        Livro torreNegra = new Livro();
        torreNegra.setAutor("A Torre Negra");
        torreNegra.setEditora("AchoSuma");
        torreNegra.setTitulo("Rober Torres");
        dao.insereDado(torreNegra);
    }

}
