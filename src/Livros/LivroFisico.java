package Livros;

import java.text.NumberFormat;
import java.time.LocalDate;
import Enum.*;

public class LivroFisico extends Livro {
    private final TipoCapa tipoCapa; //Capa Flexível ou Capa Dura
    private int quantidadeEstoque;
    public LivroFisico(String titulo, String editora, String isbn, Double preco, Integer quantidadeEstoque,
                       LocalDate dataPublicacao, TipoCapa tipoCapa, Autor autor, Categoria categoria)
    {
        super(titulo, editora,isbn,preco, dataPublicacao,autor,categoria);
        this.quantidadeEstoque = quantidadeEstoque;
        this.tipoCapa = tipoCapa;
    }

    public TipoCapa getCapa()
    {
        return this.tipoCapa;
    }

    public int getQuantidadeEstoque()
    {
        return this.quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque)
    {
        this.quantidadeEstoque += quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "\nTítulo do livro: " +getTitulo() +"\n" +
                "Tipo do livro: Fisico\n"+
                "Código ISBN: " +getIsbn() + "\n" +
                "Editora: " + getEditora() + "\n" +
                "Nome do autor: " + getNomeAutor() + "\n" +
                "Data de nascimento do autor: " + getDataNascimentoAutor() + "\n" +
                "Preço: " + NumberFormat.getCurrencyInstance().format(getPreco()) + "\n" +
                "Quantidade em estoque: " +getQuantidadeEstoque() + "\n" +
                "Data da publicação: " + getDataPublicacao() + "\n" +
                "Tipo da capa: " + getCapa().toString() + "\n" +
                "Categoria: " + getCategoria();
    }
}
