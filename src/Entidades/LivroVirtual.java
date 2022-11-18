package Entidades;

import Exceptions.Excessao;
import Interfaces.IDesconto;
import abstrata.Livro;

public class LivroVirtual extends Livro implements IDesconto
{
    public LivroVirtual(String titulo, String editora, String isbn, Integer preco)
    {
        super(titulo, editora, isbn, preco);
    }

    @Override
    public double getPrecoDesconto(double preco) throws Excessao
    {
        if(preco<= 0)
            throw new Excessao(preco);

        return getPreco() * 0.85;  // 15% de desconto !
    }
}
