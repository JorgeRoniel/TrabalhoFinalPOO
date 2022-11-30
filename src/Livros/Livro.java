package Livros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import Enum.Categoria;

public abstract class Livro
{
    private static final Locale locale = new Locale("pt","BR");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",locale);
    private String titulo;
    private String editora;
    private String isbn;
    private Double preco;
    private LocalDate dataPublicacao;
    private int quantidadeVendas;
    private Categoria categoria;
    private Autor autor = new Autor();

    public Livro()
    {

    }

    public Livro(String titulo, String editora, String isbn, Double preco,
                 LocalDate dataPublicacao, Autor autor, Categoria categoria)
    {
        this.titulo = titulo;
        this.editora = editora;
        this.isbn = isbn;
        this.preco = preco;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
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

    public int getQuantidadeVendas()
    {
        return this.quantidadeVendas;
    }
    public void setQuantidadeVendas(int quantidade)
    {
        this.quantidadeVendas += quantidade;
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

    public Categoria getCategoria() { return categoria;}

    public String getNomeAutor() { return autor.getNome();}

    public String getDataNascimentoAutor()
    {
        return autor.getDataNascimento();
    }
}
