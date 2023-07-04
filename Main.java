import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância da classe Atracao
        // Criando uma instância da classe Bilheteria
        Bilheteria bilheteria = new Bilheteria();
        Tela_main tela_main = new Tela_main(bilheteria);

        // Detalhando as atrações da bilheteria
        bilheteria.detalharAtracoes();
    }
}
 