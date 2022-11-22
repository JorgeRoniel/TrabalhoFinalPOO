package Application;

import Carrinho_Livros.Carrinho;
import Carrinho_Livros.Carrinho;
import Exceptions.Excessao;
import Livros.LivroFisico;
import Livros.LivroVirtual;
import java.util.Scanner;

public class Main {

    public static Scanner entrada = new Scanner(System.in);

    public static void Menu() throws Excessao
    {
        Carrinho carrinho = new Carrinho();

        while(true)
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Digite 1 para ADICIONAR um livro !");
            System.out.println("Digite 2 para REMOVER um livro !");
            System.out.println("Digite 3 para ATUAlIZAR um livro !");
            System.out.println("Digite 4 para TERMINAR a compra e ir para o PAGAMENTO !");
            System.out.println("Digite 5 para SAIR !");
            System.out.println("-------------------------------------------------------------------");

            int escolha = entrada.nextInt();

            switch(escolha)
            {
                case 1 -> carrinho.AdicionarLivro();
                case 2 -> carrinho.RemoverLivro();
                case 3 -> carrinho.AtualizarLivro();
                case 4 -> carrinho.CheckOut();
                case 5 -> System.exit(0);
                default -> Menu();
            }
        }
    }
    public static void main(String[] args) throws Excessao
    {
        /* Fiz a lógica para adicionar ao carrinho e cobrança
            Falta fazer a lógica para tratamento de erros
         */

        Menu();
    }
}