package Livros;

import Exceptions.Excessao;
import Interfaces.IDesconto;

import java.time.LocalDate;

public class LivroVirtual extends Livro {
    public LivroVirtual(String titulo, String editora, String isbn, Double preco, LocalDate dataPublicacao, Autor autor) {
        super(titulo, editora, isbn, preco, dataPublicacao, autor);
    }

}
