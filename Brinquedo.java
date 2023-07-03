import java.time.LocalTime;
public class Brinquedo extends Atracao {
    private Atracao dependeAtracao;
    public Brinquedo(String nome, int capacidade, int alturaMinima, int restricaoIdade, LocalTime horaAbertura, LocalTime horaFechamento, Atracao dependeAtracao) {
        super(nome, capacidade, alturaMinima, restricaoIdade, horaAbertura, horaFechamento);
        this.dependeAtracao = dependeAtracao;
    }
}
