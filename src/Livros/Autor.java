package Livros;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Autor
{
    private static final Locale locale = new Locale("pt","BR");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy",locale);
    private String nome;
    private LocalDate dataNascimento;

    public Autor()
    {

    }

    public Autor(String nome, LocalDate dataNascimento)
    {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento()
    {
        return dataNascimento.format(formatter);
    }

    public int getIdade()
    {
        return Period.between(dataNascimento,LocalDate.now()).getYears();
    }
}
