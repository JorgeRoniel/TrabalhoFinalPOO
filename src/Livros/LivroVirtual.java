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
        return "\nT�tulo do livro: " + getTitulo() + "\n" +
                "Tipo do livro: Virtual\n" +
                "C�digo ISBN: " + getIsbn() + "\n " +
                "Editora: " + getEditora() + "\n" +
                "Nome do autor: " + getNomeAutor() + "\n" +
                "Data de nascimento do autor: " + getDataNascimentoAutor() + "\n" +
                "Pre�o: " + NumberFormat.getCurrencyInstance().format(getPreco()) + "\n" +
                "Data da publica��o: " + getDataPublicacao() + "\n" +
                "Categoria " + getCategoria();
    }
}
