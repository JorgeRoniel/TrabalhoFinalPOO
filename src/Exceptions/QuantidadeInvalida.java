package Exceptions;

public class QuantidadeInvalida extends Exception
{
    String mensagem;

    public QuantidadeInvalida(String mensagem )
    {
        this.mensagem = mensagem;

    }
    public QuantidadeInvalida(int quantidade) throws QuantidadeInvalida
    {
        if(quantidade <= 0 )
            throw new QuantidadeInvalida("A quantidade de livros n�o pode ser zero !");
    }

    @Override
    public final String getMessage()
    {
        return mensagem;
    }
}
