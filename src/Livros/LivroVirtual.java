package Livros;

import Enum.*;
import java.text.NumberFormat;
import java.time.LocalDate;

public class LivroVirtual extends Livro {
    public LivroVirtual(String titulo, String editora, String isbn, Double preco,
                        LocalDate dataPublicacao, Autor autor, Categoria categoria) {
        super(titulo, editora, isbn, preco, dataPublicacao, autor,categoria);
    }


    public String toString()
    {
        return "\nTítulo do livro: " + getTitulo() + "\n" +
                "Tipo do livro: Virtual\n" +
                "Código ISBN: " + getIsbn() + "\n " +
                "Editora: " + getEditora() + "\n" +
                "Nome do autor: " + getNomeAutor() + "\n" +
                "Data de nascimento do autor: " + getDataNascimentoAutor() + "\n" +
                "Preço: " + NumberFormat.getCurrencyInstance().format(getPreco()) + "\n" +
                "Data da publicação: " + getDataPublicacao() + "\n" +
                "Categoria " + getCategoria();
    }
}
