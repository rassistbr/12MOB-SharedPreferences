package com.example.rm31675.persistencia.model;

/**
 * Created by rm31675 on 12/12/2016.
 */
public class Livro {

    public final static String NOME_TABLE = "livros";
    public final static String COLUNA_ID = "_id";
    public final static String COLUNA_TITULO = "titulo";
    public final static String COLUNA_AUTOR = "autor";
    public final static String COLUNA_EDITORA = "editora";

    private int id;
    private String titulo;
    private String autor;
    private String editora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
