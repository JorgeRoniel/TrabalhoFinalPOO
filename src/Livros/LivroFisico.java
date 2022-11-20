package Livros;

import java.util.GregorianCalendar;


public class LivroFisico extends Livro {
    private String tipoCapa; //Capa Flexível ou Capa Dura
    public LivroFisico(String titulo, String editora, String isbn, Integer preco, GregorianCalendar DataPubli, String tipoCapa) {
        super(titulo, editora, isbn,preco, DataPubli);

        this.tipoCapa = tipoCapa;
    }

    @Override
    public String toString() {
        return "LivroFisico{}";
    }
}
