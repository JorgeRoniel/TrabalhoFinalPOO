package Exceptions;

public class LivroNaoExiste extends Exception
{
    String mensagem, titulo;

    public LivroNaoExiste(String titulo) throws LivroNaoExiste
    {
        this.mensagem = "Não existe nenhum livro com o título: ";
        this.titulo = titulo;

        throw new LivroNaoExiste( "Não existe nenhum livro com o título: " + titulo);
    }
}
