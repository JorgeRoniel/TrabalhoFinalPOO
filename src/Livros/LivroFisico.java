package Livros;

import java.time.LocalDate;
import Enum.*;

public class LivroFisico extends Livro {
    private TipoCapa tipoCapa; //Capa Flexível ou Capa Dura
    public LivroFisico(String titulo, String editora, String isbn, Double preco,
                       LocalDate dataPublicacao, TipoCapa tipoCapa, Autor autor, Categoria categoria)
    {
        super(titulo, editora,isbn,preco, dataPublicacao,autor,categoria);

        this.tipoCapa = tipoCapa;
    }

    public TipoCapa getCapa()
    {
        return this.tipoCapa;
    }

    @Override
    public String toString() {
        return "\nTítulo do livro: " +getTitulo() +"\n" +
                "Tipo do livro: Fisico\n"+
                "Código ISBN: " +getIsbn() + "\n " +
                "Editora: " + getEditora() + "\n" +
                "Nome do autor: " + getNomeAutor() + "\n" +
                "Data de nascimento do autor: " + getDataNascimentoAutor() + "\n" +
                "Preço: " +getPreco() + "\n" +
                "Data da publicação: " + getDataPublicacao() + "\n" +
                "Tipo da capa: " + getCapa().toString() + "\n" +
                "Categoria " + getCategoria();
    }
}
