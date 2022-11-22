package Application;

import Carrinho_Livros.Carrinho;
import Carrinho_Livros.Carrinho;
import Livros.LivroFisico;
import Livros.LivroVirtual;
import java.util.Scanner;

public class Main {

    public static Scanner entrada = new Scanner(System.in);

    public static void Menu()
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
                case 4 -> carrinho.
            }
        }
    }
    public static void main(String[] args) {
        /*
         * Fazer o menu:
         *
         * no menu vai perguntar se a pessoa quer cadastrar um livro, atualizar, remover, etc.
         *
         * na parte de add livro, perguntar se é fisico ou virtual, se for fisico instanciar a classe livrofisico, senão
         * instanciar livrovirtual
         *
         * quando for fazer qualquer ação, tipo cadastrar, chamar as funções de Colecaolivros
         *
         */

        /*
         * OBS: ainda vou fazer umas coisas nas classes, não ta tudo 100% feito la, segunda nois se fala no disc
         *   :)
         */
    }
}