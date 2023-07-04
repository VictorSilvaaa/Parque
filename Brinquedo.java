import java.time.LocalTime;
public class Brinquedo extends Atracao {
    public Brinquedo(String nome, int capacidade, float alturaMinima, int restricaoIdade, LocalTime horaAbertura, LocalTime horaFechamento, Atracao dependeAtracao) {
        super(nome, capacidade, alturaMinima, restricaoIdade, horaAbertura, horaFechamento, dependeAtracao);
    }
}
