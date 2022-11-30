package Application;

import Carrinho_Livros.Carrinho;
import Exceptions.Excessao;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static Scanner entrada = new Scanner(System.in);

    public static void Menu() throws Excessao
    {
        Carrinho carrinho = new Carrinho();

        try
        {
            while (true)
            {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Digite 1 para ADICIONAR um livro !");
                System.out.println("Digite 2 para REMOVER um livro !");
                System.out.println("Digite 3 para ATUAlIZAR um livro !");
                System.out.println("Digite 4 para PESQUISAR um livro !");
                System.out.println("Digite 5 para TERMINAR a compra e ir para o PAGAMENTO !");
                System.out.println("Digite 6 para SAIR !");
                System.out.println("-------------------------------------------------------------------");

                int escolha = entrada.nextInt();

                switch (escolha) {
                    case 1 -> carrinho.AdicionarLivro();
                    case 2 -> carrinho.RemoverLivro();
                    case 3 -> carrinho.AtualizarLivro();
                    case 4 -> carrinho.Pesquisar();
                    case 5 -> carrinho.CheckOut();
                    case 6 -> System.exit(0);
                    default -> Menu();
                }
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Dados inválidos !");
        }
    }
    public static void main(String[] args) throws Excessao
    {
        /*
            Fiz mais uma parte de tratamento de erros. Devido a testes, vi que também lançava excessões de datas.

            Então também fiz tratamento de excessões para datas.

            Fiz algumas Alterações para o autor
         */

        Menu();
    }
}