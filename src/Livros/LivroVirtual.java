package Livros;

import Exceptions.Excessao;
import Interfaces.IDesconto;

import java.util.GregorianCalendar;

public class LivroVirtual extends Livro implements IDesconto {
    public LivroVirtual(String titulo, String editora, String isbn, Integer preco, GregorianCalendar DataPubli) {
        super(titulo, editora, isbn, preco, DataPubli);
    }

    @Override
    public double getPrecoDesconto(double preco) throws Excessao
    {
        if(preco<= 0)
            throw new Excessao(preco);

        return getPreco() * 0.85;  // 15% de desconto !
    }
}
