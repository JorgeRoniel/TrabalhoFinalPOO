package Carrinho_Livros;

import Livros.Livro;
import Livros.LivroFisico;
import Enum.TipoCapa;
import Livros.LivroVirtual;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrinho implements Interfaces.ICarrinho
{
    private final Scanner entrada = new Scanner(System.in);
    List<Livro> carrinho = new ArrayList<>();

    @Override
    public void AdicionarLivro()
    {
        System.out.println("Digite o titulo do livro !");
        String titulo = entrada.nextLine();

        System.out.println("Digite o ISBN do livro !");
        String isbn = entrada.nextLine();

        System.out.println("Digite o nome da editora !");
        String editora = entrada.nextLine();

        System.out.println("Digite o preço do livro !");
        double preco = entrada.nextDouble();

        entrada.nextLine();

        System.out.println("Digite 1 para livro físico e 2 para virtual !");
        short tipoLivro = entrada.nextShort();

        System.out.println("Digite a data de lançamento do livro no formato (dd/mm/yy) !");
        LocalDate data = LocalDate.parse(entrada.nextLine());

        System.out.println("Digite 1 para capa flexível e 2 para capa dura !");
        short tipo = entrada.nextShort();

        TipoCapa tipoCapa;

        if(tipo == 1)
            tipoCapa = TipoCapa.Flexivel;
        else
            tipoCapa = TipoCapa.Dura;

        if(tipoLivro == 1)
            carrinho.add(new LivroFisico(titulo,editora,isbn,preco,data,tipoCapa));
        else
            carrinho.add(new LivroVirtual(titulo,editora,isbn,preco,data));
    }

    @Override
    public void RemoverLivro(Livro livro)
    {
        carrinho.remove(livro);
    }

    @Override
    public void AtualizarLivro(Livro livro, int escolha)
    {

    }
}
