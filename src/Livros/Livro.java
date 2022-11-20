package Livros;

import java.util.GregorianCalendar;

public abstract class Livro {
    private String titulo;
    private String editora;
    private String isbn;
    private Integer preco;
    private GregorianCalendar DataPubli = new GregorianCalendar();

    public Livro() {

    }

    public Livro(String titulo, String editora, String isbn, Integer preco, GregorianCalendar DataPubli) {
        this.titulo = titulo;
        this.editora = editora;
        this.isbn = isbn;
        this.preco = preco;
        this.DataPubli = DataPubli;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPreco() {
        return preco;
    }

    public GregorianCalendar getDataPubli() {
        return DataPubli;
    }
}
