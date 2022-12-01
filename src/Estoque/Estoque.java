package Estoque;

import Exceptions.Excessao;
import Livros.Autor;
import Livros.Livro;
import Livros.LivroFisico;
import Livros.LivroVirtual;
import Enum.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class Estoque
{
    private static final Scanner entrada = new Scanner(System.in);

    static List<Livro> livrosEstoque = new ArrayList<>();

    private static Autor CadastrarAutor() throws DateTimeException, InputMismatchException
    {
        try
        {
            entrada.nextLine();

            System.out.println("Digite o nome do autor: ");
            String nomeAutor = entrada.nextLine();

            System.out.println("Digite o dia de nascimento do autor: ");
            int dia = entrada.nextInt();

            System.out.println("Digite o mes de nascimento do autor: ");
            int mes = entrada.nextInt();

            System.out.println("Digite o ano de nascimento do autor: ");
            int ano = entrada.nextInt();

            return new Autor(nomeAutor,LocalDate.of(ano, mes, dia));
        }
        catch (DateTimeException e)
        {
            System.out.println("Data informada é inválida !");

            System.out.println("Tente novamente !");

        }
        catch (InputMismatchException e)
        {
            System.out.println("Dados inválidos !");
        }

        return null;
    }

    public static Double ValorTotalEmEstoque()
    {
        Double soma = 0D;

        for(Livro livro: livrosEstoque)
        {
            if(livro instanceof LivroFisico)
                soma += livro.getPreco() * ((LivroFisico) livro).getQuantidadeEstoque();

            else
                soma += livro.getPreco();
        }

        return soma;
    }

    public static String LivroMaisVendido()
    {
        int maior = 0, i = 0;
        String titulo = "";
        for(Livro livro: livrosEstoque)
        {
            if(livro.getQuantidadeVendas() > maior) {
                maior = livro.getQuantidadeVendas();
                titulo = livro.getTitulo();
            }
        }

        return titulo;
    }
    public static void ImprimirEstoque()
    {
        for(Livro livro: livrosEstoque)
        {
            System.out.println(livro);
        }
    }
    public static void AtualizarLivro()
    {
        int i = 0;

        for (Livro livro : livrosEstoque)
        {
            System.out.print(livro.getTitulo() + " " + livro.getPreco() + " " );
            System.out.print(" - " + i + "\n");
            i++;
        }

        System.out.println("Digite o índice do livro que você quer atualizar !");
        short indice = entrada.nextShort();

        entrada.nextLine();

        System.out.println("O que você deseja atualizar ?");
        System.out.println("Digite 1 para título !");
        System.out.println("Digite 2 para ISBN !");
        System.out.println("Digite 3 para Editora !");
        System.out.println("Digite 4 para o preço !");
        System.out.println("Digite 5 para data de publicação !");

        short opcao = entrada.nextShort();

        switch (opcao)
        {
            case 1 ->
            {
                entrada.nextLine();

                System.out.println("Digite o novo título !");
                String titulo = entrada.nextLine();

                livrosEstoque.get(indice).setTitulo(titulo);
            }

            case 2 ->
            {
                entrada.nextLine();

                System.out.println("Digite o novo ISBN !");
                String isbn = entrada.nextLine();

                livrosEstoque.get(indice).setIsbn(isbn);
            }

            case 3 ->
            {
                entrada.nextLine();

                System.out.println("Digite a nova editora !");
                String editora = entrada.nextLine();

                livrosEstoque.get(indice).setEditora(editora);
            }

            case 4 ->
            {
                System.out.println("Digite o novo preço !");
                Double preco = entrada.nextDouble();

                livrosEstoque.get(indice).setPreco(preco);
            }

            case 5 ->
            {
                System.out.println("Digite o dia de lançamento do livro !");
                int dia = entrada.nextInt();

                System.out.println("Digite o mês de lançamento do livro !");
                int mes = entrada.nextInt();

                System.out.println("Digite o ano de lançamento do livro !");
                int ano = entrada.nextInt();

                livrosEstoque.get(indice).setDataPublicacao(LocalDate.of(ano, mes, dia));
            }

            default ->
            {
                return;
            }
        }
    }
    public static void CadastrarNovoLivro() throws DateTimeException, InputMismatchException
    {
        int quantidade;

        try
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

            System.out.println("Digite o dia de lançamento do livro !");
            int dia = entrada.nextInt();

            System.out.println("Digite o mês de lançamento do livro !");
            int mes = entrada.nextInt();

            System.out.println("Digite o ano de lançamento do livro !");
            int ano = entrada.nextInt();

            System.out.println("Selecione uma das opções para categoria !\n" +
                    "AutoAjuda - 1\n" +
                    "Romance - 2,\n" +
                    "Ficcao - 3,\n" +
                    "Historia - 4,\n" +
                    "HQ - 5 ,\n" +
                    "Religiao - 6,\n" +
                    "Fantasia - 7,\n" +
                    "Literatura - 8,\n" +
                    "Biografias - 9,\n" +
                    "Familia - 10");

            Categoria[] categoria = Categoria.values();
            short escolha = entrada.nextShort();

            Excessao.ValidarData(ano,mes,dia);

            if(tipoLivro == 1)
            {
                System.out.println("Digite 1 para capa flexível e 2 para capa dura !");
                short tipo = entrada.nextShort();

                System.out.println("Digite a quantidade de livros para cadastrar no estoque !");
                quantidade = entrada.nextInt();

                TipoCapa tipoCapa;

                if (tipo == 1)
                    tipoCapa = TipoCapa.Flexivel;
                else
                    tipoCapa = TipoCapa.Dura;

                livrosEstoque.add(new LivroFisico(titulo, editora, isbn, preco, quantidade,
                        LocalDate.of(ano, mes, dia), tipoCapa, CadastrarAutor(), categoria[escolha - 1]));
            }

            else
                livrosEstoque.add(new LivroVirtual(titulo, editora, isbn, preco,
                        LocalDate.of(ano, mes, dia), CadastrarAutor(), categoria[escolha - 1]));

            entrada.nextLine();

        }
        catch(InputMismatchException e)
        {
            System.out.println("Dados inválidos !");
        }

        catch (DateTimeException e)
        {
            System.out.println("Data inválida !");
        }

        catch (IllegalArgumentException e)
        {
            System.out.println("Quantidade de livros cadastradas é inválida !");
        }
    }

    public static Livro BuscarLivro(String titulo)
    {
        for(Livro livro: livrosEstoque)
        {
            if(Objects.equals(livro.getTitulo().toUpperCase(),titulo.toUpperCase()))
            {
                return livro;
            }
        }
        return null;
    }

}
