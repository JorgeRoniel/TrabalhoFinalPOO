package Exceptions;

import java.time.*;

public class DataInvalida extends Exception
{
    String mensagem;

    public DataInvalida(String mensagem)
    {
        this.mensagem = mensagem;
    }
    public DataInvalida(int ano, int mes, int dia) throws DataInvalida
    {
        if(ano < 0)
            throw new DataInvalida("Ano n�o pode ser menor que zero !");

        else if(ano > LocalDateTime.now().getYear())
            throw new DataInvalida("O ano informado n�o pode ser maior que o ano atual !");

        else if(mes <= 0 || mes > 12)
            throw new DataInvalida("O m�s informado � inv�lido !");

        else if(dia <= 0 || dia > Month.of(mes).length(Year.isLeap(LocalDate.now().getYear())))
            throw new DataInvalida("O dia informado � inv�lido para tal m�s !");
    }

    @Override
    public final String getMessage()
    {
        return mensagem;
    }
}
