package com.example.rm31675.persistencia.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rm31675.persistencia.model.Livro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rm31675 on 12/12/2016.
 */
public class LivroDAO {
    private SQLiteDatabase db;

    public static String createTable(){
        return "CREATE TABLE " + Livro.NOME_TABLE
                + " (" + Livro.COLUNA_ID + " integer PRIMARY KEY AUTOINCREMENT "
                + ","  + Livro.COLUNA_TITULO + " text "
                + ", " + Livro.COLUNA_AUTOR + " text "
                + ", " + Livro.COLUNA_EDITORA + " text"
                + ")";
    }


    public String insereDado(Livro livro) {
        ContentValues valores;
        long resultado;

        db = DatabaseManager.getInstance().openDatabase(false);
        valores = new ContentValues();
        valores.put(Livro.COLUNA_TITULO, livro.getTitulo());
        valores.put(Livro.COLUNA_AUTOR, livro.getAutor());
        valores.put(Livro.COLUNA_EDITORA, livro.getEditora());
        resultado = db.insert(Livro.NOME_TABLE, null, valores);

        DatabaseManager.getInstance().closeDatabase();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public List<Livro> carregaDados() {
        List<Livro> livros = new ArrayList<>();

        Cursor cursor;
        String[] campos = {Livro.COLUNA_ID, Livro.COLUNA_TITULO};
        db = DatabaseManager.getInstance().openDatabase(true);
        //cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);
        cursor = db.query(Livro.NOME_TABLE, null, null, null, null, null, null, null);

        if (cursor != null) {
            if(cursor.moveToFirst()){
                do {
                    Livro livro = new Livro();
                    livro.setId(cursor.getInt(cursor.getColumnIndex(Livro.COLUNA_ID)));
                    livro.setEditora(cursor.getString(cursor.getColumnIndex(Livro.COLUNA_EDITORA)));
                    livro.setTitulo(cursor.getString(cursor.getColumnIndex(Livro.COLUNA_TITULO)));
                    livro.setAutor(cursor.getString(cursor.getColumnIndex(Livro.COLUNA_EDITORA)));
                    livros.add(livro);
                } while(cursor.moveToNext());
            }
        }
        DatabaseManager.getInstance().closeDatabase();
        return livros;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {Livro.COLUNA_ID,Livro.COLUNA_TITULO,Livro.COLUNA_AUTOR,Livro.COLUNA_EDITORA};
        String where = Livro.COLUNA_ID + "=" + id;
        db = DatabaseManager.getInstance().openDatabase(true);
        cursor = db.query(Livro.NOME_TABLE, campos, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        DatabaseManager.getInstance().closeDatabase();
        return cursor;
    }

    public void alteraRegistro(Livro livro){
        ContentValues valores;
        String where;

        db = DatabaseManager.getInstance().openDatabase(false);

        where = Livro.COLUNA_ID + "=" + livro.getId();

        valores = new ContentValues();
        valores.put(Livro.COLUNA_TITULO, livro.getTitulo());
        valores.put(Livro.COLUNA_AUTOR, livro.getAutor());
        valores.put(Livro.COLUNA_EDITORA, livro.getEditora());

        db.update(Livro.NOME_TABLE, valores,where,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void deletaRegistro(int id){
        String where = Livro.COLUNA_ID + "=" + id;
        db = DatabaseManager.getInstance().openDatabase(false);
        db.delete(Livro.NOME_TABLE,where,null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
