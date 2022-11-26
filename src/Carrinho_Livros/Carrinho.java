package Carrinho_Livros;

import Exceptions.Excessao;
import Interfaces.IJuros;
import Livros.Livro;
import Livros.LivroFisico;
import Enum.TipoCapa;
import Livros.LivroVirtual;
import Livros.Autor;

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

    private LocalDate DataNasc(){
        System.out.println("Digite o ano de nascimento do autor: ");
        int ano = entrada.nextInt();

        System.out.println("Digite o mes de nascimento do autor: ");
        int mes = entrada.nextInt();

        System.out.println("Digite o dia de nascimento do autor: ");
        int dia = entrada.nextInt();

        LocalDate dataNasc = LocalDate.of(ano, mes, dia);

        return dataNasc;
    }

    @Override
    public void AdicionarLivro()
    {
        try{
            entrada.nextLine();
            System.out.println("Digite o titulo do livro !");
            String titulo = entrada.nextLine();

            System.out.println("Digite o ISBN do livro !");
            String isbn = entrada.nextLine();

            System.out.println("Digite o nome da editora !");
            String editora = entrada.nextLine();

            System.out.println("Digite o preço do livro !");
            double preco = entrada.nextDouble();

            entrada.nextLine();

            System.out.println("Digite o nome do autor: ");
            String nome_a = entrada.nextLine();

            Autor a = new Autor(nome_a, DataNasc());

            entrada.nextLine();

            System.out.println("Digite 1 para livro físico e 2 para virtual !");
            short tipoLivro = entrada.nextShort();

            System.out.println("Digite o dia de lançamento do livro !");
            int dia = entrada.nextInt();

            System.out.println("Digite o mês de lançamento do livro !");
            int mes = entrada.nextInt();

            System.out.println("Digite o ano de lançamento do livro !");
            int ano = entrada.nextInt();

            if(tipoLivro == 1) {
                System.out.println("Digite 1 para capa flexível e 2 para capa dura !");
                short tipo = entrada.nextShort();

                TipoCapa tipoCapa;

                if (tipo == 1)
                    tipoCapa = TipoCapa.Flexivel;
                else
                    tipoCapa = TipoCapa.Dura;
                carrinho.add(new LivroFisico(titulo, editora, isbn, preco, LocalDate.of(ano, mes, dia), tipoCapa, a));
            }else if(tipoLivro == 2) {
                carrinho.add(new LivroVirtual(titulo, editora, isbn, preco, LocalDate.of(ano, mes, dia), a));
            }
        }catch (Exception e){
            System.out.println("Houve um erro na cadastro/compra do Livro, tente novamente!");
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

        System.out.println("Digite o índice do livro que você quer remover !");
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

        try{
            System.out.println("Digite o índice do livro que você quer atualizar !");
            short indice = entrada.nextShort();

            for (Livro livro : carrinho)
            {
                if (i == indice)
                {
                    System.out.println("Digite o índice do livro que você quer atualizar !");
                    short escolha = entrada.nextShort();

                    System.out.println("O que você deseja atualizar ?");
                    System.out.println("Digite 1 para título !");
                    System.out.println("Digite 2 para ISBN !");
                    System.out.println("Digite 3 para Editora !");
                    System.out.println("Digite 4 para o preço !");
                    System.out.println("Digite 5 para o Autor !");
                    System.out.println("Digite 6 para data de publicação !");

                    short opcao = entrada.nextShort();

                    switch (opcao) {
                        case 1 ->
                        {
                            System.out.println("Digite o novo título !");
                            String titulo = entrada.nextLine();

                            livro.setTitulo(titulo);
                            entrada.nextLine();
                        }

                        case 2 ->
                        {
                            System.out.println("Digite o novo ISBN !");
                            String isbn = entrada.nextLine();

                            livro.setIsbn(isbn);
                            entrada.nextLine();
                        }

                        case 3 ->
                        {
                            System.out.println("Digite a nova editora !");
                            String editora = entrada.nextLine();

                            livro.setEditora(editora);
                            entrada.nextLine();
                        }

                        case 4 ->
                        {
                            System.out.println("Digite o novo preço !");
                            Double preco = entrada.nextDouble();

                            livro.setPreco(preco);
                        }

                        case 5 ->
                        {
                            System.out.println("Digite o nome do autor: ");
                            String n_nomeA = entrada.nextLine();

                            Autor n_Autor = new Autor(n_nomeA, DataNasc());
                            entrada.nextLine();
                        }

                        case 6 ->
                        {
                            System.out.println("Digite o dia de lançamento do livro !");
                            int n_dia = entrada.nextInt();

                            System.out.println("Digite o mês de lançamento do livro !");
                            int n_mes = entrada.nextInt();

                            System.out.println("Digite o ano de lançamento do livro !");
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
        }catch (Exception e){
            System.out.println("Houve um erro na atualizacao do Livro, tente novamente!");
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

        System.out.println("O total da compra foi de: " + numberFormat.format(soma) + "\nComo você deseja pagar ? Digite 1 para pagamento " +
                "à vista e 2 para pagamento parcelado !");

        short pagamento = entrada.nextShort();

        if(pagamento == 1)
        {
            System.out.println("Como você irá pagar à vista, iremos lhe dar um desconto de 15% !");
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
                " O preço final ficou em: " + numberFormat.format(precoFinal));
    }

    public void Pesquisar(){
        System.out.println("Como voce deseja fazer a pesquisa?\n 1 - Pelo titulo\n 2 - Pelo intervalo do preco\n");
        int esc = entrada.nextInt();

        entrada.nextLine();

        if(esc == 1){

            System.out.println("Digite o titulo do livro: ");
            String titulo = entrada.nextLine();

            for(int i = 0; i<carrinho.size(); i++){
                if(this.carrinho.get(i).getTitulo().equals(titulo)){
                    System.out.println(this.carrinho.get(i));
                }else{
                    System.out.println("Livro nao encontrado");
                    break;
                }
            }
        }else if(esc == 2){

            System.out.println("Digite o preco inicial do livro: ");
            Double precoI = entrada.nextDouble();

            System.out.println("Digite o preco final do livro: ");
            Double precoF = entrada.nextDouble();

            for(int i = 0; i < carrinho.size(); i++){
                if(this.carrinho.get(i).getPreco() <= precoF && this.carrinho.get(i).getPreco() >= precoI){
                    System.out.println(this.carrinho.get(i));
                }else{
                    System.out.println("Livro nao encontrado");
                    break;
                }
            }
        }else{
            System.out.println("Valor de escolha invalido");
        }
    }

}
