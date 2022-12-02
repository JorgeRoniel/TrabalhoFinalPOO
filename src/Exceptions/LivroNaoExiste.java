package Exceptions;

public class LivroNaoExiste extends Exception
{
    String mensagem, titulo;

    public LivroNaoExiste(String titulo) throws LivroNaoExiste
    {
        this.mensagem = "N�o existe nenhum livro com o t�tulo: ";
        this.titulo = titulo;

        throw new LivroNaoExiste( "N�o existe nenhum livro com o t�tulo: " + titulo);
    }
}
