package Exceptions;

import java.time.*;

public class Excessao extends Exception
{
    public static void ValidarPreco(double preco)
    {
        if(preco <= 0)
            throw new IllegalArgumentException("O pre�o tem que ser um valor positivo !");
    }

    public static void ValidarPreco (double preco, int quantidadeParcelas)
    {
        if(preco <= 0 && quantidadeParcelas <= 0)
            throw new IllegalArgumentException("O pre�o e o n�mero de parcelas tem que ser um valor positivo !");

        else if (preco <= 0)
            throw new IllegalArgumentException("O pre�o tem que ser um valor positivo !");

        else if(quantidadeParcelas <= 0)
            throw new IllegalArgumentException("A quantidade de parcelas tem que ser positiva !");

    }

    public static void ValidarData(int ano, int mes, int dia) throws DateTimeException
    {
        if(ano < 0)
            throw  new DateTimeException("Ano n�o pode ser menor que zero !");

        else if(ano > LocalDateTime.now().getYear())
            throw  new DateTimeException("O ano informado n�o pode ser maior que o ano atual !");

        else if(mes <= 0 || mes > 12)
            throw  new DateTimeException("O m�s informado � inv�lido !");

        else if(mes == 2 && Year.isLeap(LocalDate.now().getYear()) && dia > 29)
            throw  new DateTimeException("O dia informado � inv�lido para o m�s de fevereiro !");

        else if(mes == 2 && dia > 28)
            throw  new DateTimeException("O dia informado � inv�lido !");

        else if(dia == 0 || dia > Month.of(mes).maxLength())
            throw new DateTimeException("O dia informado � inv�lido para tal m�s !");
    }
}
