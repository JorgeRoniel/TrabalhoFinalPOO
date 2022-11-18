package Entidades;

import abstrata.Livro;

public class LivroFisico extends Livro
{
    public LivroFisico(String titulo, String editora, String isbn, Integer preco)
    {
        super(titulo, editora, isbn,preco);
    }
}
