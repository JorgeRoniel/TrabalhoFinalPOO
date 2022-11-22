package Livros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Livro {
    private static final Locale locale = new Locale("pt","BR");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy",locale);
    private String titulo;
    private String editora;
    private String isbn;
    private Double preco;
    private LocalDate dataPublicacao;

    private Autor autor = new Autor();

    public Livro() {

    }

    public Livro(String titulo, String editora, String isbn, Double preco,
                 LocalDate dataPublicacao, Autor autor) {
        this.titulo = titulo;
        this.editora = editora;
        this.isbn = isbn;
        this.preco = preco;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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

    public Double getPreco() {
        return preco;
    }

    public String getDataPublicacao() {
        return formatter.format(dataPublicacao);
    }
}
