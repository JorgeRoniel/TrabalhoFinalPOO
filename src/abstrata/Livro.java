package abstrata;

public abstract class Livro {
    private String titulo;
    private String editora;
    private String isbn;
    private Integer preco;
    public Livro()
    {

    }
    public Livro(String titulo, String editora, String isbn, Integer preco) {
        this.titulo = titulo;
        this.editora = editora;
        this.isbn = isbn;
        this.preco = preco;
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
}
