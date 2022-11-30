package Interfaces;

import Exceptions.Excessao;

public interface ICarrinho {
    void AdicionarLivroCarrinho();
    void RemoverLivroCarrinho();
    void CheckOut() throws Excessao;

}
