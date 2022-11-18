package Interfaces;

import Exceptions.Excessao;

public interface IDesconto
{
    double getPrecoDesconto(double preco) throws Excessao;

}

