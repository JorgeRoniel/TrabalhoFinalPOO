package Exceptions;

public class Excessao extends Exception
{
    public Excessao(double preco)
    {
        if(preco <= 0)
            throw new IllegalArgumentException("O pre�o tem que ser um valor positivo !");
    }

    public Excessao(double preco, int quantidadeParcelas)
    {
        if(preco <= 0 && quantidadeParcelas <= 0)
            throw new IllegalArgumentException("O pre�o e o n�mero de parcelas tem que ser um valor positivo !");

        else if (preco <= 0)
            throw new IllegalArgumentException("O pre�o tem que ser um valor positivo !");

        else if(quantidadeParcelas <= 0)
            throw new IllegalArgumentException("A quantidade de parcelas tem que ser positiva !");

    }
}
