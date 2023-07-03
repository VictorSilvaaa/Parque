import java.util.HashMap;
import java.util.Map;

public class Comprador {
    private String nome;
    private int idade;
    private double altura;
    private Map<Atracao, Integer> atracoesVisitadas;

    public Comprador(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.atracoesVisitadas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public Map<Atracao, Integer> getAtracoesVisitadas() {
        return atracoesVisitadas;
    }

    public void visitarAtracao(Atracao atracao) {
        Integer quantidadeVisitas = atracoesVisitadas.get(atracao);
        if (quantidadeVisitas == null) {
            atracoesVisitadas.put(atracao, 1);
        } else {
            atracoesVisitadas.put(atracao, quantidadeVisitas + 1);
        }
    }
}
