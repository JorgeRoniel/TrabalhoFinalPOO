package Interfaces;

import Exceptions.LivroNaoExiste;
import Exceptions.PrecoInvalido;

public interface ICarrinho
{
    void AdicionarLivroCarrinho() throws LivroNaoExiste;
    void RemoverLivroCarrinho();
    void CheckOut() throws PrecoInvalido;

}
