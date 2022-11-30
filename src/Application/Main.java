package Application;

import Carrinho_Livros.Carrinho;
import Estoque.Estoque;
import Exceptions.Excessao;
import java.util.InputMismatchException;
import java.util.Scanner;
import Livros.*;

public class Main
{
    public static Scanner entrada = new Scanner(System.in);

    public static void MenuGeral() throws InputMismatchException
    {
        while(true)
        {
            try
            {
                System.out.println("Digite 1 para ir para o Menu do CONTROLE DE ESTOQUE !");
                System.out.println("Digite 2 para ir para o Menu de VENDAS !");

                int escolha = entrada.nextInt();

                switch (escolha) {
                    case 1 -> MenuEstoque();
                    case 2 -> MenuCarrinho();
                    default -> MenuGeral();
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Você precisa digitar um número !");
                break;
            }
        }
    }

    public static void MenuEstoque() throws InputMismatchException
    {
        try
        {
            while (true)
            {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Digite 1 para ADICIONAR um livro no ESTOQUE !");
                System.out.println("Digite 2 para ATUAlIZAR um livro !");
                System.out.println("Digite 3 para PESQUISAR um livro !");
                System.out.println("Digite 4 para SAIR !");
                System.out.println("-------------------------------------------------------------------");

                int escolha = entrada.nextInt();

                switch (escolha)
                {
                    case 1 -> Estoque.CadastrarNovoLivro();
                    case 2 -> Estoque.AtualizarLivro();
                    case 3 ->
                    {
                        entrada.nextLine();

                        System.out.println("Digite o título do livro que você busca !");
                        String titulo = entrada.nextLine();

                        Livro livro = Estoque.BuscarLivro(titulo);

                        if(livro != null)
                        {
                            System.out.println("Livro encontrado ! Imprimindo os dados...............");
                            System.out.println(livro);
                        }
                        else
                            System.out.println("Livro não encontrado !");
                    }
                    case 4 ->
                    {
                        return;
                    }
                    default -> MenuCarrinho();
                }
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Dados inválidos !");
        }
    }
    public static void MenuCarrinho() throws InputMismatchException
    {
        Carrinho carrinho = new Carrinho();

        try
        {
            while (true)
            {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Digite 1 para ADICIONAR um livro no CARRINHO!");
                System.out.println("Digite 2 para REMOVER um livro do CARRINHO !");
                System.out.println("Digite 4 para IMPRIMIR os LIVROS no CARRINHO !");
                System.out.println("Digite 5 para TERMINAR a compra e ir para o PAGAMENTO !");
                System.out.println("Digite 6 para SAIR !");
                System.out.println("-------------------------------------------------------------------");

                int escolha = entrada.nextInt();

                switch (escolha)
                {
                    case 1 -> carrinho.AdicionarLivroCarrinho();
                    case 2 -> carrinho.RemoverLivroCarrinho();
                    case 3 -> carrinho.ImprimirConteudoCarrinho();
                    case 5 -> carrinho.CheckOut();
                    case 6 ->
                    {
                        return;
                    }
                    default -> MenuCarrinho();
                }
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Dados inválidos !");
        }
        catch (Excessao e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) throws Excessao
    {
        /*
            Fiz a parte do estoque. Falta fazer só a parte do tratamento de excessões e as categorias.

            O resto já ta tudo ok.
         */

        MenuGeral();

        entrada.close();
    }
}