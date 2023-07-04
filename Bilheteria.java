import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
//arquivos
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Bilheteria {
    private Map<Atracao, Integer> ingressos;
    private List<Comprador> compradores;

    public Bilheteria() {
        ingressos = new HashMap<>();
        compradores = new ArrayList<>();
        lerDadosDeArquivo("dados_bilheteria.txt");
    }

    public void adicionarAtracao(Atracao atracao, int quantidadeIngressos) {
        ingressos.put(atracao, quantidadeIngressos);
        salvarDadosEmArquivo("dados_bilheteria.txt");
    }

    public void removerAtracao(Atracao atracao) {
        ingressos.remove(atracao);
        salvarDadosEmArquivo("dados_bilheteria.txt");
    }

    public void detalharAtracoes() {
        for (Map.Entry<Atracao, Integer> entry : ingressos.entrySet()) {
        Atracao atracao = entry.getKey();
        int quantidadeIngressos = entry.getValue();
        System.out.println("---ATRACAO---");
        System.out.println("Nome: "+ atracao.getNome());
        System.out.println("Capacidade: " + atracao.getCapacidade());
        System.out.println("Altura Mínima: " + atracao.getAlturaMinima());
        System.out.println("Restrição de Idade: " + atracao.getRestricaoIdade());
        System.out.println("Hora de Abertura: " + atracao.getHoraAbertura());
        System.out.println("Hora de Fechamento: " + atracao.getHoraFechamento());
        System.out.println("Quantidade de ingressos: " + quantidadeIngressos);
        System.out.println("------------------------");
    }
    }

    public void salvarDadosEmArquivo(String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
        for (Map.Entry<Atracao, Integer> entry : ingressos.entrySet()) {
            Atracao atracao = entry.getKey();
            int quantidadeIngressos = entry.getValue();
            writer.newLine();
            writer.write("Nome: " + atracao.getNome());
            writer.newLine();
            writer.write("Capacidade: " + atracao.getCapacidade());
            writer.newLine();
            writer.write("Altura Mínima: " + atracao.getAlturaMinima());
            writer.newLine();
            writer.write("Restrição de Idade: " + atracao.getRestricaoIdade());
            writer.newLine();
            writer.write("Hora de Abertura: " + atracao.getHoraAbertura());
            writer.newLine();
            writer.write("Hora de Fechamento: " + atracao.getHoraFechamento());
            writer.newLine();
            writer.write("Quantidade de ingressos: " + quantidadeIngressos);
            writer.newLine();
            writer.write("Depende: " + atracao.getDependeAtracao().getNome());
            writer.newLine();
            writer.write("------------------------");
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    public void lerDadosDeArquivo(String nomeArquivo) {
    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
        String line;
        Atracao atracao = null;
        int quantidadeIngressos = 0;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Nome: ")) {
                atracao = new Atracao();
                String nome = line.substring("Nome: ".length());
                atracao.setNome(nome);
            } else if (line.startsWith("Capacidade: ")) {
                int capacidade = Integer.parseInt(line.substring("Capacidade: ".length()));
                atracao.setCapacidade(capacidade);
            } else if (line.startsWith("Altura Mínima: ")) {
                float alturaMinima = Float.parseFloat(line.substring("Altura Mínima: ".length()));
                atracao.setAlturaMinima(alturaMinima);
            } else if (line.startsWith("Restrição de Idade: ")) {
                int restricaoIdade = Integer.parseInt(line.substring("Restrição de Idade: ".length()));
                atracao.setRestricaoIdade(restricaoIdade);
            } else if (line.startsWith("Hora de Abertura: ")) {
                String horaAberturaStr = line.substring("Hora de Abertura: ".length());
                LocalTime horaAbertura = LocalTime.parse(horaAberturaStr);
                atracao.setHoraAbertura(horaAbertura);
            } else if (line.startsWith("Hora de Fechamento: ")) {
                String horaFechamentoStr = line.substring("Hora de Fechamento: ".length());
                LocalTime horaFechamento = LocalTime.parse(horaFechamentoStr);
                atracao.setHoraFechamento(horaFechamento);
            } else if (line.startsWith("Quantidade de ingressos: ")) {
                quantidadeIngressos = Integer.parseInt(line.substring("Quantidade de ingressos: ".length()));
                ingressos.put(atracao, quantidadeIngressos);
            }else if (line.startsWith("Depende: ")) {
                String nomeDepende = line.substring("Depende: ".length());
                atracao.setDependeAtracao(new Atracao(nomeDepende));
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
     public List<Atracao> getAtracoes() {
        List<Atracao> atracoesDisponiveis = new ArrayList<>();

        for (Map.Entry<Atracao, Integer> entry : ingressos.entrySet()) {
            Atracao atracao = entry.getKey();
            int quantidadeIngressos = entry.getValue();

            if (quantidadeIngressos >= 0) {
                atracoesDisponiveis.add(atracao);
            }
        }

        return atracoesDisponiveis;
    }

    public boolean adicionarComprador(Comprador novoComprador) {
        for (Comprador comprador : compradores) {
            if (comprador.getNome().equals(novoComprador.getNome()) &&
                comprador.getIdade() == novoComprador.getIdade() &&
                comprador.getAltura() == novoComprador.getAltura()) {
                // Comprador já cadastrado, não adiciona novamente
                return false;
            }
        }
        // Comprador não cadastrado, adiciona à lista
        compradores.add(novoComprador);
        return true;
    }
    public List<Comprador> getCompradores() {
        return this.compradores;
    }


}
