package Interfaces;

public interface IJuros
{
    default double PrecoComJuros(double preco, int quantidadeParcelas)
    {
        return Math.pow(1.1,quantidadeParcelas) * preco;
    }
}
