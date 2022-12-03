package Exceptions;

public class LivroNaoExiste extends Exception
{
    private String mensagem;

    private LivroNaoExiste(String mensagem)
    {
        this.mensagem = mensagem;
    }
    public LivroNaoExiste() throws LivroNaoExiste
    {
        throw new LivroNaoExiste("O livro informado não existe !");
    }

    @Override
    public final String getMessage()
    {
        return mensagem;
    }
}
