package Livros;

import Exceptions.Excessao;
import Interfaces.IDesconto;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class LivroVirtual extends Livro {
    public LivroVirtual(String titulo, String editora, String isbn, Double preco, LocalDate dataPublicacao) {
        super(titulo, editora, isbn, preco, dataPublicacao);
    }

}
