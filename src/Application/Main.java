package Application;

import Carrinho_Livros.Carrinho;
import Exceptions.Excessao;
import java.util.Scanner;

public class Main {

    public static Scanner entrada = new Scanner(System.in);

    public static void Menu() throws Excessao
    {
        Carrinho carrinho = new Carrinho();

        while(true)
        {
            try{
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Digite 1 para ADICIONAR um livro !");
                System.out.println("Digite 2 para REMOVER um livro !");
                System.out.println("Digite 3 para ATUAlIZAR um livro !");
                System.out.println("Digite 4 para PESQUISAR um livro !");
                System.out.println("Digite 5 para TERMINAR a compra e ir para o PAGAMENTO !");
                System.out.println("Digite 6 para SAIR !");
                System.out.println("-------------------------------------------------------------------");

                int escolha = entrada.nextInt();

                switch(escolha)
                {
                    case 1 -> carrinho.AdicionarLivro();
                    case 2 -> carrinho.RemoverLivro();
                    case 3 -> carrinho.AtualizarLivro();
                    case 4 -> carrinho.Pesquisar();
                    case 5 -> carrinho.CheckOut();
                    case 6 -> System.exit(0);
                    default -> Menu();
                }
            }catch (Exception e){
                System.out.println("O valor digitado e invalido, tente novamente!");
                break;
            }
        }
    }
    public static void main(String[] args) throws Excessao
    {
        /*
        Fiz a parte de tratamento de erros, cadastro e atualização de autor e a função de pesquisa, porem
        tem um bug na parte de pesquisa por titulo, mas deixa que depois eu arrumo

        fica pra tu fazer a parte de imprimir os livros, de acordo como o professor pediu no pdf

        caso tu queira fazer alguma alteração nos tratamentos de erros, pode fazer
         */

        Menu();
    }
}