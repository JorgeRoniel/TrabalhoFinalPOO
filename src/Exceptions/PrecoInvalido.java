package Exceptions;

public class PrecoInvalido extends Exception
{
    private String mensagem;

    private PrecoInvalido(String mensagem)
    {
        this.mensagem = mensagem;
    }
    public PrecoInvalido(double preco) throws PrecoInvalido
    {
        if(preco <= 0)
            throw new PrecoInvalido("O preço tem que ser um valor positivo !");
    }

    public PrecoInvalido(double preco, int quantidadeParcelas) throws PrecoInvalido
    {
        if(preco <= 0 && quantidadeParcelas <= 0)
            throw new PrecoInvalido("O preço e o número de parcelas tem que ser um valor positivo !");

        else if (preco <= 0)
            throw new PrecoInvalido("O preço tem que ser um valor positivo !");

        else if(quantidadeParcelas <= 0)
            throw new PrecoInvalido("A quantidade de parcelas tem que ser positiva !");

    }

    @Override
    public final String getMessage()
    {
        return mensagem;
    }
}
