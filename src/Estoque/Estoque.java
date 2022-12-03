package Estoque;

import Exceptions.DataInvalida;
import Exceptions.*;
import Livros.Autor;
import Livros.Livro;
import Livros.LivroFisico;
import Livros.LivroVirtual;
import Enum.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;

public class Estoque
{
    private static final Scanner entrada = new Scanner(System.in);

    static List<Livro> livrosEstoque = new ArrayList<>();

    private static void VerificarData(int dia, int mes, int ano) throws DataInvalida
    {
            if(
                    dia <= 0 || dia > 31 // dias
                    || mes <= 0 || mes > 12  // mes
                    || ano <= 0 || ano > LocalDate.now().getYear() // ano
                    || dia > Month.of(mes).length(Year.isLeap(ano)) // Verificar se o dia é maior que os dias do mês

            )// fim do IF

                throw new DataInvalida(ano, mes, dia);
    }

    private static Autor CadastrarAutor() throws DataInvalida, InputMismatchException
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

            VerificarData(dia, mes, ano);

            return new Autor(nomeAutor,LocalDate.of(ano, mes, dia));
        }
        catch (DataInvalida | InputMismatchException e )
        {
            System.out.println(e.getMessage());

            System.out.println("Tente novamente !");
        }

        return CadastrarAutor();
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
        int maior = 0;
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
    public static void AtualizarLivro() throws IllegalArgumentException, InputMismatchException
    {
        int i = 0;

        for (Livro livro : livrosEstoque)
        {
            System.out.print(livro.getTitulo() + " " + livro.getPreco() + " ");
            System.out.println(" - índice: " + i + "\n");
            i++;
        }

        try
        {
            System.out.println("Digite o índice do livro que você quer atualizar !");
            short indice = entrada.nextShort();

            if(indice > i)
                throw new IllegalArgumentException("Não existe livro com esse índice !");

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

                case 2 -> {
                    entrada.nextLine();

                    System.out.println("Digite o novo ISBN !");
                    String isbn = entrada.nextLine();

                    livrosEstoque.get(indice).setIsbn(isbn);
                }

                case 3 -> {
                    entrada.nextLine();

                    System.out.println("Digite a nova editora !");
                    String editora = entrada.nextLine();

                    livrosEstoque.get(indice).setEditora(editora);
                }

                case 4 -> {
                    System.out.println("Digite o novo preço !");
                    Double preco = entrada.nextDouble();

                    livrosEstoque.get(indice).setPreco(preco);
                }

                case 5 -> {
                    System.out.println("Digite o dia de lançamento do livro !");
                    int dia = entrada.nextInt();

                    System.out.println("Digite o mês de lançamento do livro !");
                    int mes = entrada.nextInt();

                    System.out.println("Digite o ano de lançamento do livro !");
                    int ano = entrada.nextInt();

                    livrosEstoque.get(indice).setDataPublicacao(LocalDate.of(ano, mes, dia));
                }

                default -> {
                    return;
                }
            } // Switch
        } // Try
        catch (InputMismatchException | IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void CadastrarNovoLivro() throws DataInvalida, QuantidadeInvalida, PrecoInvalido
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

            if(preco <= 0)
                throw new PrecoInvalido(preco);

            entrada.nextLine();

            System.out.println("Digite 1 para livro físico e 2 para virtual !");
            short tipoLivro = entrada.nextShort();

            System.out.println("Digite o dia de lançamento do livro !");
            int dia = entrada.nextInt();

            System.out.println("Digite o mês de lançamento do livro !");
            int mes = entrada.nextInt();

            System.out.println("Digite o ano de lançamento do livro !");
            int ano = entrada.nextInt();

            VerificarData(dia,mes,ano);

            System.out.println("""
                    Selecione uma das opções para categoria !
                    AutoAjuda - 1
                    Romance - 2,
                    Ficcao - 3,
                    Historia - 4,
                    HQ - 5 ,
                    Religiao - 6,
                    Fantasia - 7,
                    Literatura - 8,
                    Biografias - 9,
                    Familia - 10""");

            Categoria[] categoria = Categoria.values();
            short escolha = entrada.nextShort();

            VerificarData(dia, mes, ano);

            if(tipoLivro == 1)
            {
                System.out.println("Digite 1 para capa flexível e 2 para capa dura !");
                short tipo = entrada.nextShort();

                System.out.println("Digite a quantidade de livros para cadastrar no estoque !");
                quantidade = entrada.nextInt();

                if(quantidade <= 0)
                    throw new QuantidadeInvalida(quantidade);

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
        }

        catch (InputMismatchException | DataInvalida | QuantidadeInvalida | PrecoInvalido e)
        {
            System.out.println(e.getMessage());
        }

        entrada.nextLine();
    }

    public static Livro BuscarLivro(String titulo) throws LivroNaoExiste
    {
        for(Livro livro: livrosEstoque)
        {
            if(Objects.equals(livro.getTitulo().toUpperCase(),titulo.toUpperCase()))
            {
                return livro;
            }
        }

        throw new LivroNaoExiste();
    }

}
