package Interfaces;

import abstrata.Livro;

public interface Carrinho
{
    void AdicionarProduto(Livro livro, Integer quantidade);
    void RemoverProduto(Livro);
}
