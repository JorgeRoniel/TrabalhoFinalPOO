package Exceptions;

public class LivroNaoExiste extends Exception
{
    String mensagem;

    public LivroNaoExiste(String mensagem)
    {
        this.mensagem = mensagem;
    }
    public LivroNaoExiste() throws LivroNaoExiste
    {
        throw new LivroNaoExiste("O livro informado n�o existe !");
    }

    @Override
    public String getMessage()
    {
        return mensagem;
    }
}
