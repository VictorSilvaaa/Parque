import java.time.LocalTime;
public class Lanchonete extends Atracao {
    public Lanchonete(String nome, int capacidade, LocalTime horaAbertura, LocalTime horaFechamento) {
        super(nome, capacidade, 0, 0, horaAbertura, horaFechamento);
    }
}
