package Exceptions;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class DataInvalida extends Exception
{
    private String mensagem;

    private DataInvalida(String mensagem)
    {
        this.mensagem = mensagem;
    }
    public DataInvalida(int ano, int mes, int dia) throws DataInvalida
    {
        if(ano < 0)
            throw new DataInvalida("Ano não pode ser menor que zero !");

        else if(ano > LocalDateTime.now().getYear())
            throw new DataInvalida("O ano informado não pode ser maior que o ano atual !");

        else if(mes <= 0 || mes > 12)
            throw new DataInvalida("O mês informado é inválido !");

        else if(dia <= 0 || dia > Month.of(mes).length(Year.isLeap(LocalDate.now().getYear())))
            throw new DataInvalida("O dia informado é inválido para o mês de " +
                  Month.of(mes).getDisplayName(TextStyle.FULL,new Locale("pt", "BR")));
    }

    @Override
    public final String getMessage()
    {
        return mensagem;
    }
}
