package Carrinho_Livros;

import Exceptions.Excessao;
import Livros.Livro;
import Livros.LivroFisico;
import Enum.*;
import Livros.LivroVirtual;
import Livros.Autor;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Carrinho implements Interfaces.ICarrinho, Interfaces.IDesconto, Interfaces.IJuros
{
    private final Scanner entrada = new Scanner(System.in);
    List<Livro> carrinho = new ArrayList<>();

    private LocalDate RecebeDataNascimento()
    {

        System.out.println("Digite o ano de nascimento do autor: ");
        int ano = entrada.nextInt();

        System.out.println("Digite o mes de nascimento do autor: ");
        int mes = entrada.nextInt();

        System.out.println("Digite o dia de nascimento do autor: ");
        int dia = entrada.nextInt();

        return LocalDate.of(ano, mes, dia);
    }

    @Override
    public void AdicionarLivro() throws InputMismatchException, DateTimeException
    {
        try
        {
            System.out.println("Digite o titulo do livro !");
            String titulo = entrada.nextLine();

            System.out.println("Digite o ISBN do livro !");
            String isbn = entrada.nextLine();

            System.out.println("Digite o nome da editora !");
            String editora = entrada.nextLine();

            System.out.println("Digite o pre�o do livro !");
            double preco = entrada.nextDouble();

            entrada.nextLine();

            System.out.println("Digite o nome do autor: ");
            String nomeAutor = entrada.nextLine();

            Autor autor = new Autor(nomeAutor, RecebeDataNascimento());

            entrada.nextLine();

            System.out.println("Digite 1 para livro f�sico e 2 para virtual !");
            short tipoLivro = entrada.nextShort();

            System.out.println("Digite o dia de lan�amento do livro !");
            int dia = entrada.nextInt();

            System.out.println("Digite o m�s de lan�amento do livro !");
            int mes = entrada.nextInt();

            System.out.println("Digite o ano de lan�amento do livro !");
            int ano = entrada.nextInt();

            Excessao.ValidarData(ano,mes,dia);

            System.out.println("Digite 1 para capa flex�vel e 2 para capa dura !");
            short tipo = entrada.nextShort();

            TipoCapa tipoCapa;

            if (tipo == 1)
                tipoCapa = TipoCapa.Flexivel;
            else
                tipoCapa = TipoCapa.Dura;

            if (tipoLivro == 1)
                carrinho.add(new LivroFisico(titulo, editora, isbn, preco,
                        LocalDate.of(ano, mes, dia), tipoCapa, autor,Categoria.valueOf("5")));
            else
                carrinho.add(new LivroVirtual(titulo, editora, isbn, preco,
                        LocalDate.of(ano, mes, dia), autor, Categoria.valueOf("6")));

        }
        catch (DateTimeException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e)
        {
            System.out.println("Dados informados s�o inv�lidos !");
        }
    }

    @Override
    public void RemoverLivro()
    {
        int i = 0;

        for(Livro livro: carrinho)
        {
            System.out.println(livro.getTitulo() + " " + livro.getPreco());
            System.out.print(" - " + i);
        }

        System.out.println("Digite o �ndice do livro que voc� quer remover !");
        short escolha = entrada.nextShort();

        carrinho.remove(escolha);
    }

    @Override
    public void AtualizarLivro()
    {
        int i = 0;

        for(Livro livro: carrinho)
        {
            System.out.println(livro.getTitulo() + " " + livro.getPreco());
            System.out.print(" - " + i);
            i++;
        }

        System.out.println("Digite o �ndice do livro que voc� quer atualizar !");
        short indice = entrada.nextShort();

        for (Livro livro : carrinho)
        {
            if (i == indice)
            {
                System.out.println("Digite o �ndice do livro que voc� quer atualizar !");
                short escolha = entrada.nextShort();

                System.out.println("O que voc� deseja atualizar ?");
                System.out.println("Digite 1 para t�tulo !");
                System.out.println("Digite 2 para ISBN !");
                System.out.println("Digite 3 para Editora !");
                System.out.println("Digite 4 para o pre�o !");
                System.out.println("Digite 5 para data de publica��o !");

                short opcao = entrada.nextShort();

                switch (opcao) {
                    case 1 ->
                    {
                        System.out.println("Digite o novo t�tulo !");
                        String titulo = entrada.nextLine();

                        livro.setTitulo(titulo);
                    }

                    case 2 ->
                    {
                        System.out.println("Digite o novo ISBN !");
                        String isbn = entrada.nextLine();

                        livro.setIsbn(isbn);
                    }

                    case 3 ->
                    {
                        System.out.println("Digite a nova editora !");
                        String editora = entrada.nextLine();

                        livro.setEditora(editora);
                    }

                    case 4 ->
                    {
                        System.out.println("Digite o novo pre�o !");
                        Double preco = entrada.nextDouble();

                        livro.setPreco(preco);
                    }

                    case 5 ->
                    {
                        System.out.println("Digite o dia de lan�amento do livro !");
                        int n_dia = entrada.nextInt();

                        System.out.println("Digite o m�s de lan�amento do livro !");
                        int n_mes = entrada.nextInt();

                        System.out.println("Digite o ano de lan�amento do livro !");
                        int n_ano = entrada.nextInt();

                        LocalDate n_dataL = LocalDate.of(n_ano, n_mes, n_dia);
                        livro.setDataPublicacao(n_dataL);
                    }

                    default ->
                    {
                        return;
                    }
                }
            }
        }
    }
    @Override
    public double getPrecoDesconto(double preco) throws Excessao
    {
        Excessao.ValidarPreco(preco);

        return preco * 0.85;  // 15% de desconto !
    }

    @Override
    public double getPrecoComJuros(double preco, int quantidadeParcelas) {
        return Math.pow(1.1,quantidadeParcelas) * preco;
    }

    @Override
    public void CheckOut() throws Excessao
    {
        double soma = 0;
        double precoFinal = 0;

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        Locale locale = new Locale("pt", "BR");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",locale);

        for(Livro livro: carrinho)
        {
            if(livro instanceof LivroVirtual)
                soma += getPrecoDesconto(livro.getPreco());
            else
                soma += livro.getPreco();
        }

        System.out.println("O total da compra foi de: " + numberFormat.format(soma) + "\nComo voc� deseja pagar ? " +
                "Digite 1 para pagamento � vista e 2 para pagamento parcelado !");

        short pagamento = entrada.nextShort();

        if(pagamento == 1)
        {
            System.out.println("Como voc� ir� pagar � vista, iremos lhe dar um desconto de 15% !");
            precoFinal = getPrecoDesconto(soma);
        }

        else
        {
            System.out.println("Digite a quantidade de parcelas !");
            short parcelas = entrada.nextShort();

            precoFinal = getPrecoComJuros(soma,parcelas);
        }

        System.out.println("Digite 1 para finalizar a compra e 2 para cancelar !");
        short escolha = entrada.nextShort();

        if(escolha == 1)
            System.out.println("Compra foi realizada com sucesso no dia " + LocalDate.now().format(dateTimeFormatter) +
                    " as " + LocalDateTime.now().getHour() + " horas e " + LocalDateTime.now().getMinute() + " minutos !" +
                " O pre�o final ficou em: " + numberFormat.format(precoFinal));
    }

    public void Pesquisar() throws InputMismatchException
    {
        try
        {
            System.out.println("Digite o t�tulo para pesquisa !");
            String titulo = entrada.nextLine();

            for (Livro livro : carrinho)
            {
                if (Objects.equals(titulo, livro.getTitulo()))
                {
                    System.out.println("Imprimindo os dados do livro.................");
                    System.out.println(livro);
                }
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Dados inv�lidos !");
        }
    }

    public void PesquisarPorPreco(Integer precoInicial, Integer precoFinal) throws IllegalArgumentException
    {
        if(precoInicial <= 0 || precoFinal <= 0)
            throw new IllegalArgumentException("Os pre�os informados s�o inv�lidos !");

        for(Livro livro: carrinho)
        {
            if(livro.getPreco() <= precoFinal && livro.getPreco() >= precoInicial)
            {
                System.out.println(livro.getTitulo() + " -  R$: " + livro.getPreco());
            }
        }
    }
}
