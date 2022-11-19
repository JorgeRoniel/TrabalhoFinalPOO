package Carrinho;

import abstrata.Livro;
import java.util.ArrayList;
import java.util.List;
import Interfaces.Carrinho;

public class Carrinho extends Livro implements Carrinho
{
    private static List<Livro> livroList = new ArrayList<>();

    private static Integer somaTotal;
    private static Integer precoFinal;
    private Integer quantidadeProdutos;
    private Integer quantidadeParcelas;

    public Carrinho(String titulo, String editora, String isbn,
                    Integer preco, Integer quantidadeProdutos, Integer quantidadeParcelas) {
        super(titulo, editora, isbn, preco);
        this.quantidadeProdutos = quantidadeProdutos;
        this.quantidadeParcelas = quantidadeParcelas;
    }

    static
    {
        for(Livro livros: livroList)
        {
            somaTotal += livros.getPreco();
        }
    }
}
