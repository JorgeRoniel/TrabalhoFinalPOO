package Interfaces;

import Exceptions.Excessao;
import Livros.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static Application.Main.entrada;

public interface ICarrinho {
    void AdicionarLivro();
    void RemoverLivro();
    void AtualizarLivro();

    void CheckOut() throws Excessao;

}
