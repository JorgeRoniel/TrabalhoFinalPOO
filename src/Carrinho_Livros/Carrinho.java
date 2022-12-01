package Carrinho_Livros;

import Estoque.Estoque;
import Exceptions.Excessao;
import Livros.Livro;
import Livros.LivroFisico;
import Livros.LivroVirtual;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Carrinho implements Interfaces.ICarrinho, Interfaces.IDesconto, Interfaces.IJuros
{
    private final Scanner entrada = new Scanner(System.in);
    List<Livro> carrinho = new ArrayList<>();

    public void ImprimirConteudoCarrinho()
    {
        Double soma = 0D;

        for(Livro livro : carrinho)
        {
            System.out.println(livro.getTitulo() + " " + NumberFormat.getCurrencyInstance().format(livro.getPreco()));
            soma += livro.getPreco();
        }

        System.out.print("Total da compra até o momento: \n" + NumberFormat.getCurrencyInstance().format(soma) + "\n");
    }
    @Override
    public void AdicionarLivroCarrinho() throws InputMismatchException
    {
        try
        {
            System.out.println("Digite o titulo do livro que você procura !");
            String titulo = entrada.nextLine();

            Livro livro = Estoque.BuscarLivro(titulo);

            if(livro instanceof LivroFisico)
            {
                if (((LivroFisico) livro).getQuantidadeEstoque() > 0)
                {
                    System.out.println("Encontramos o seu livro !");
                    System.out.println(livro);

                    System.out.println("Você confirma que é esse livro que você está a procura ? Digite 1 para SIM !");
                    int escolha = entrada.nextInt();

                    if(escolha == 1)
                        carrinho.add(livro);
                } else
                {
                    System.out.println("Encontramos o seu livro mas não temos mais quantidades disponíveis ): !");
                }
            }
            else if(livro instanceof LivroVirtual)
            {
                System.out.println("Encontramos o seu livro !");
                System.out.println(livro);

                System.out.println("Você confirma que é esse livro que você está a procura ? Digite 1 para SIM !");
                int escolha = entrada.nextInt();

                if(escolha == 1)
                {
                    carrinho.add(livro);

                    System.out.println("O livro foi adicionado no carrinho !");
                }
            }
            else
                System.out.println("Não encontramos o seu livro !");
        }

        catch (InputMismatchException e)
        {
            System.out.println("Dados informados são inválidos !");

            System.out.println("Tente novamente !");

            AdicionarLivroCarrinho();
        }
    }

    @Override
    public void RemoverLivroCarrinho()
    {
        int i = 0;

        for(Livro livro: carrinho)
        {
            System.out.println(livro.getTitulo() + " " + livro.getPreco());
            System.out.print(" - " + i);
        }

        try
        {
            System.out.println("Digite o índice do livro que você quer remover !");
            short escolha = entrada.nextShort();

            carrinho.remove(escolha);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Dados inválidos !");
        }
    }

    @Override
    public double getPrecoDesconto(double preco) throws Excessao
    {
        try
        {
            Excessao.ValidarPreco(preco);

            return preco * 0.85;  // 15% de desconto !
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public double getPrecoComJuros(double preco, int quantidadeParcelas)
    {
        if(quantidadeParcelas < 4 && preco > 50)
            return preco * 1.05;

        else
            return preco * 1.25;
    }

    @Override
    public void CheckOut() throws Excessao
    {
        double soma = 0;
        double precoFinal = 0;

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        Locale locale = new Locale("pt", "BR");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",locale);

        if(carrinho.isEmpty())
        {
            System.out.println("O carrinho está vazio !");
            return;
        }

        for(Livro livro: carrinho)
        {
            if(livro instanceof LivroVirtual)
                soma += getPrecoDesconto(livro.getPreco());
            else
                soma += livro.getPreco();
        }

        try
        {
            System.out.println("O total da compra foi de: " + numberFormat.format(soma) + "\nComo você deseja pagar ? " +
                    "Digite 1 para pagamento à vista e 2 para pagamento parcelado !");

            short pagamento = entrada.nextShort();

            if (pagamento == 1)
            {
                System.out.println("Como você irá pagar à vista, iremos lhe dar um desconto de 15% !");
                precoFinal = getPrecoDesconto(soma);
            } else
            {
                System.out.println("Digite a quantidade de parcelas !");
                short parcelas = entrada.nextShort();

                precoFinal = getPrecoComJuros(soma, parcelas);
            }

            System.out.println("Digite 1 para finalizar a compra e 2 para cancelar !");
            short escolha = entrada.nextShort();


            if (escolha == 1)
            {
                System.out.println("Compra foi realizada com sucesso no dia " + LocalDate.now().format(dateTimeFormatter) +
                        " as " + LocalDateTime.now().getHour() + " horas e " + LocalDateTime.now().getMinute() + " minutos !" +
                        " O preço final ficou em: " + numberFormat.format(precoFinal));

                for (Livro livro : carrinho)
                {
                    if (livro instanceof LivroFisico)
                    {
                        ((LivroFisico) livro).setQuantidadeEstoque(-1); // Para atualizar a quantidade em estoque !
                    }

                    livro.setQuantidadeVendas(1);

                    carrinho.remove(livro); // Esvaziar o carrinho após o CheckOut !
                } // for
            }// if
        } // try

        catch (InputMismatchException e)
        {
            System.out.println("Dados inválidos !");
        }
    } // class

    public void Pesquisar() throws InputMismatchException
    {
        try
        {
            System.out.println("Digite o título para pesquisa !");
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
            System.out.println("Dados inválidos !");
        }
    }

    public void PesquisarPorPreco(Integer precoInicial, Integer precoFinal) throws IllegalArgumentException
    {
        if(precoInicial <= 0 || precoFinal <= 0)
            throw new IllegalArgumentException("Os preços informados são inválidos !");

        for(Livro livro: carrinho)
        {
            if(livro.getPreco() <= precoFinal && livro.getPreco() >= precoInicial)
            {
                System.out.println(livro.getTitulo() + " -  R$: " + livro.getPreco());
            }
        }
    }
}
