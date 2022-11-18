package Exceptions;

public class Excessao extends Exception
{
    public Excessao(double preco)
    {
        if(preco <= 0)
            throw new IllegalArgumentException("O preço tem que ser um valor positivo !");
    }

    public Excessao(double preco, int quantidadeParcelas)
    {
        if(preco <= 0 && quantidadeParcelas <= 0)
            throw new IllegalArgumentException("O preço e o número de parcelas tem que ser um valor positivo !");

        else if (preco <= 0)
            throw new IllegalArgumentException("O preço tem que ser um valor positivo !");

        else if(quantidadeParcelas <= 0)
            throw new IllegalArgumentException("A quantidade de parcelas tem que ser positiva !");

    }
}
