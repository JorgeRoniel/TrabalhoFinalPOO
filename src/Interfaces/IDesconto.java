package Interfaces;

import Exceptions.PrecoInvalido;

public interface IDesconto
{
    double getPrecoDesconto(double preco) throws PrecoInvalido;

}

