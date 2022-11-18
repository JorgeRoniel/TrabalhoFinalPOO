package abstrata;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Autor
{
    private static final Locale locale = new Locale("pt","BR");

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy",locale);
    private String nome;
    private LocalDate dataNascimento;
    private int Idade;
    private String nacionalidade;

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
