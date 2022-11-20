package Carrinho_Livros;

import Livros.Livro;

public interface Carrinho {
    void AdicionarLivro(Livro livro);
    void RemoverLivro(int indice);
    void AtualizarLivro(Livro livro, int indice);

}
