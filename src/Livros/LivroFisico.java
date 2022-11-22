package Livros;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import Enum.TipoCapa;

public class LivroFisico extends Livro {
    private TipoCapa tipoCapa; //Capa Flexível ou Capa Dura
    public LivroFisico(String titulo, String editora, String isbn, Double preco,
                       LocalDate dataPublicacao, TipoCapa tipoCapa) {
        super(titulo, editora, isbn,preco, dataPublicacao);

        this.tipoCapa = tipoCapa;
    }

    @Override
    public String toString() {
        return "LivroFisico{}";
    }
}
