package Exceptions;

public class QuantidadeInvalida extends Exception
{
    private String mensagem;

    private QuantidadeInvalida(String mensagem )
    {
        this.mensagem = mensagem;

    }
    public QuantidadeInvalida(int quantidade) throws QuantidadeInvalida
    {
        if(quantidade <= 0 )
            throw new QuantidadeInvalida("A quantidade de livros não pode ser zero !");
    }

    @Override
    public final String getMessage()
    {
        return mensagem;
    }
}
