package Livros;

import Exceptions.Excessao;
import Interfaces.IDesconto;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class LivroVirtual extends Livro implements IDesconto {
    public LivroVirtual(String titulo, String editora, String isbn, Double preco, LocalDate dataPublicacao) {
        super(titulo, editora, isbn, preco, dataPublicacao);
    }

    @Override
    public double getPrecoDesconto(double preco) throws Excessao
    {
        if(preco<= 0)
            throw new Excessao(preco);

        return getPreco() * 0.85;  // 15% de desconto !
    }
}
