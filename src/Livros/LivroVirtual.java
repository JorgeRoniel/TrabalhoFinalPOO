package Livros;

import Exceptions.Excessao;
import Interfaces.IDesconto;

import java.time.LocalDate;

public class LivroVirtual extends Livro {
    public LivroVirtual(String titulo, String editora, String isbn, Double preco, LocalDate dataPublicacao, Autor autor) {
        super(titulo, editora, isbn, preco, dataPublicacao, autor);
    }

    public String toString() {
        return "\nTitulo do livro: " +getTitulo() +"\n" +
                "Tipo do livro: Virtual\n" +
                "Codigo ISBN: " +getIsbn() + "\n " +
                "Editora: " + getEditora() + "\n" +
                "Preco: " +getPreco() + "\n" +
                "Data da publicacao: " + getDataPublicacao() + "\n";
    }
}
