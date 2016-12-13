package com.example.rm31675.persistencia.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rm31675.persistencia.MinhaAplicacao;
import com.example.rm31675.persistencia.model.Livro;

/**
 * Created by rm31675 on 12/12/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static String NOME_BANCO = "livros.db";
    public static int VERSAO_BANCO = 1;

    public DBHelper(){
        super(MinhaAplicacao.getContext(), NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LivroDAO.createTable());
        seed();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

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
