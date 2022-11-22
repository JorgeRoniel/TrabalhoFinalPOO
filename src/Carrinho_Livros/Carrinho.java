package Carrinho_Livros;

import Exceptions.Excessao;
import Interfaces.IJuros;
import Livros.Livro;
import Livros.LivroFisico;
import Enum.TipoCapa;
import Livros.LivroVirtual;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Carrinho implements Interfaces.ICarrinho, Interfaces.IDesconto, Interfaces.IJuros
{
    private final Scanner entrada = new Scanner(System.in);
    List<Livro> carrinho = new ArrayList<>();

    @Override
    public void AdicionarLivro()
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

        System.out.println("Digite 1 para livro f�sico e 2 para virtual !");
        short tipoLivro = entrada.nextShort();

        System.out.println("Digite o dia de lan�amento do livro !");
        int dia = entrada.nextInt();

        System.out.println("Digite o m�s de lan�amento do livro !");
        int mes = entrada.nextInt();

        System.out.println("Digite o ano de lan�amento do livro !");
        int ano = entrada.nextInt();

        System.out.println("Digite 1 para capa flex�vel e 2 para capa dura !");
        short tipo = entrada.nextShort();

        TipoCapa tipoCapa;

        if(tipo == 1)
            tipoCapa = TipoCapa.Flexivel;
        else
            tipoCapa = TipoCapa.Dura;

        if(tipoLivro == 1)
            carrinho.add(new LivroFisico(titulo,editora,isbn,preco,LocalDate.of(ano,mes,dia),tipoCapa));
        else
            carrinho.add(new LivroVirtual(titulo,editora,isbn,preco,LocalDate.of(ano,mes,dia)));
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
                        System.out.println("Digite a nova data no formato (dd-mm-yyyy) !");
                        String data = entrada.nextLine();

                        livro.setDataPublicacao(LocalDate.parse(data));
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
        if(preco<= 0)
            throw new Excessao(preco);

        return preco * 0.85;  // 15% de desconto !
    }

    @Override
    public double getPrecoComJuros(double preco, int quantidadeParcelas) {
        return Math.pow(1.1,quantidadeParcelas) * preco;
    }

    @Override
    public void CheckOut() throws Excessao {
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

        System.out.println("O total da compra foi de: " + numberFormat.format(soma) + "\nComo voc� deseja pagar ? Digite 1 para pagamento " +
                "� vista e 2 para pagamento parcelado !");

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
            System.out.println("Compra foi realizada com sucesso no dia "
                    + LocalDate.now().format(dateTimeFormatter) +
                    " as " + LocalDateTime.now().getHour() + " horas e " + LocalDateTime.now().getMinute() + " minutos !" +
                " O pre�o final ficou em: " + numberFormat.format(precoFinal));
    }
}
