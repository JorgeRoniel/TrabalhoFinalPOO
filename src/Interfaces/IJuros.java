package Interfaces;

public interface IJuros
{
    default double getPrecoComJuros(double preco, int quantidadeParcelas)
    {
        return Math.pow(1.1,quantidadeParcelas) * preco;
    }
}
