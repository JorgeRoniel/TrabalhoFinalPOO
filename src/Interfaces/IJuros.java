package Interfaces;

import Exceptions.PrecoInvalido;

public interface IJuros
{
    double getPrecoComJuros(double preco, int quantidadeParcelas) throws PrecoInvalido;
}
