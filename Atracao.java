import java.time.LocalTime;

public class Atracao {
    private String nome;
    private int capacidade;
    private float alturaMinima;
    private int restricaoIdade;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;
    private Atracao dependeAtracao;
    public Atracao(){};
    public Atracao(String nome){
        this.nome = nome;
    };
    public Atracao(String nome,int capacidade, float alturaMinima, int restricaoIdade, LocalTime horaAbertura, LocalTime horaFechamento, Atracao dependeAtracao) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.alturaMinima = alturaMinima;
        this.restricaoIdade = restricaoIdade;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.dependeAtracao = dependeAtracao;
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

    public float getAlturaMinima() {
        return alturaMinima;
    }

    public void setAlturaMinima(float alturaMinima) {
        this.alturaMinima = alturaMinima;
    }

    public int getRestricaoIdade() {
        return restricaoIdade;
    }

    public void setRestricaoIdade(int restricaoIdade) {
        this.restricaoIdade = restricaoIdade;
    }
    public void setDependeAtracao(Atracao dependeAtracao){
        this.dependeAtracao = dependeAtracao;
    }
    public Atracao getDependeAtracao() {
        return dependeAtracao;
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
