package Application;

import Carrinho_Livros.Carrinho;
import Estoque.Estoque;
import Exceptions.*;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import Livros.*;

import javax.xml.crypto.Data;

public class Main
{
    private static final Scanner entrada = new Scanner(System.in);

    public static void MenuGeral() throws InputMismatchException,DataInvalida, PrecoInvalido, QuantidadeInvalida
    {
        try
        {
            while (true)
            {
                System.out.println("Digite 1 para ir para o Menu do CONTROLE DE ESTOQUE !");
                System.out.println("Digite 2 para ir para o Menu de VENDAS !");
                System.out.println("Digite 3 para sair !");
                int escolha = entrada.nextInt();

                switch (escolha) {
                    case 1 -> MenuEstoque();
                    case 2 -> MenuCarrinho();
                    case 3 -> System.exit(0);
                    default -> MenuGeral();
                }
            }
        }
        catch(InputMismatchException | DataInvalida | QuantidadeInvalida | LivroNaoExiste | PrecoInvalido e )
        {
            System.out.println(e.getMessage());
        }
    }

    public static void MenuEstoque() throws InputMismatchException, DataInvalida,
            QuantidadeInvalida, PrecoInvalido,LivroNaoExiste
    {
        try
        {
            while (true)
            {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Digite 1 para ADICIONAR um livro no ESTOQUE !");
                System.out.println("Digite 2 para ATUAlIZAR um livro !");
                System.out.println("Digite 3 para PESQUISAR um livro !");
                System.out.println("Digite 4 para IMPRIMIR o valor TOTAL de produtos em ESTOQUE !");
                System.out.println("Digite 5 para IMPRIMIR todos os PRODUTOS que estão em ESTOQUE !");
                System.out.println("Digite 6 para IMPRIMIR o livro MAIS VENDIDO !");
                System.out.println("Digite 7 para SAIR !");
                System.out.println("-------------------------------------------------------------------");

                int escolha = entrada.nextInt();

                switch (escolha)
                {
                    case 1 ->
                    {
                        entrada.nextLine();
                        Estoque.CadastrarNovoLivro();
                    }

                    case 2 ->
                    {
                        entrada.nextLine();
                        Estoque.AtualizarLivro();
                    }

                    case 3 ->
                    {
                        entrada.nextLine();

                        System.out.println("Digite o título do livro que você busca !");
                        String titulo = entrada.nextLine();

                        Livro livro = Estoque.BuscarLivro(titulo);

                        System.out.println("Livro encontrado ! Imprimindo os dados...............");
                        System.out.println(livro);

                    }
                    case 4 -> System.out.println(NumberFormat.getCurrencyInstance().format(Estoque.ValorTotalEmEstoque()));

                    case 5 -> Estoque.ImprimirEstoque();

                    case 6 -> System.out.println(Estoque.LivroMaisVendido());

                    case 7 ->
                    {
                        return;
                    }
                    default -> MenuCarrinho();
                }
            }
        }
        catch (InputMismatchException | DataInvalida | PrecoInvalido | LivroNaoExiste | QuantidadeInvalida e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void MenuCarrinho() throws InputMismatchException, LivroNaoExiste, PrecoInvalido
    {
        Carrinho carrinho = new Carrinho();

        try
        {
            while (true)
            {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Digite 1 para ADICIONAR um livro no CARRINHO!");
                System.out.println("Digite 2 para REMOVER um livro do CARRINHO !");
                System.out.println("Digite 3 para IMPRIMIR os LIVROS no CARRINHO !");
                System.out.println("Digite 4 para TERMINAR a compra e ir para o PAGAMENTO !");
                System.out.println("Digite 5 para SAIR !");
                System.out.println("-------------------------------------------------------------------");

                int escolha = entrada.nextInt();

                switch (escolha)
                {
                    case 1 ->
                    {
                        entrada.nextLine();

                        carrinho.AdicionarLivroCarrinho();
                    }
                    case 2 ->
                    {
                        entrada.nextLine();

                        carrinho.RemoverLivroCarrinho();
                    }
                    case 3 -> carrinho.ImprimirConteudoCarrinho();
                    case 4 -> carrinho.CheckOut();
                    case 5 ->
                    {
                        return;
                    }
                    default -> MenuCarrinho();
                }
            }
        }
        catch (InputMismatchException | LivroNaoExiste e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws DataInvalida, PrecoInvalido, QuantidadeInvalida
    {
        /*
            Este código se encontra armazenado no seguinte repositório:

            https://github.com/JorgeRoniel/TrabalhoFinalPOO

         */

        MenuGeral();

        entrada.close();
    }
}