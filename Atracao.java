import java.time.LocalTime;

public class Atracao {
    private String nome;
    private int capacidade;
    private int alturaMinima;
    private int restricaoIdade;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;
    public Atracao(){};
    public Atracao(String nome,int capacidade, int alturaMinima, int restricaoIdade, LocalTime horaAbertura, LocalTime horaFechamento) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.alturaMinima = alturaMinima;
        this.restricaoIdade = restricaoIdade;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAlturaMinima() {
        return alturaMinima;
    }

    public void setAlturaMinima(int alturaMinima) {
        this.alturaMinima = alturaMinima;
    }

    public int getRestricaoIdade() {
        return restricaoIdade;
    }

    public void setRestricaoIdade(int restricaoIdade) {
        this.restricaoIdade = restricaoIdade;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
}
