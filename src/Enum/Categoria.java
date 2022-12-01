package Enum;

public enum Categoria
{
    AutoAjuda(1),
    Romance(2),
    Ficcao(3),
    Historia(4),
    HQ(5),
    Religiao(6),
    Fantasia(7),
    Literatura(8),
    Biografias(9),
    Familia(10);

    int escolha;

    Categoria(int escolha)
    {
        this.escolha = escolha;
    }

}
