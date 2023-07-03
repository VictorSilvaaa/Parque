import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ExibirDetalharUsuario extends JFrame {
    private JComboBox<Comprador> comboBoxCompradores;
    private JTextArea textAreaDetalhes;

    public ExibirDetalharUsuario(Bilheteria bilheteria, JFrame frameAnterior) {
        JFrame frame = new JFrame("Formulário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // ComboBox de Compradores
        comboBoxCompradores = new JComboBox<>();
        List<Comprador> compradores = bilheteria.getCompradores();
        for (Comprador comprador : compradores) {
            comboBoxCompradores.addItem(comprador);
        }
        comboBoxCompradores.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Comprador) {
                    Comprador aComprador = (Comprador) value;
                    setText(aComprador.getNome());
                }
                return this;
            }
        });
        comboBoxCompradores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comprador compradorSelecionado = (Comprador) comboBoxCompradores.getSelectedItem();
                exibirDetalhesComprador(compradorSelecionado);
            }
        });

        // Área de detalhes
        textAreaDetalhes = new JTextArea();
        textAreaDetalhes.setEditable(false);

        // Painel de seleção de compradores
        JPanel painelCompradores = new JPanel(new FlowLayout());
        painelCompradores.add(new JLabel("Compradores:"));
        painelCompradores.add(comboBoxCompradores);

       

        // Adicionando os componentes ao painel principal
        painelPrincipal.add(painelCompradores, BorderLayout.NORTH);
        painelPrincipal.add(new JScrollPane(textAreaDetalhes), BorderLayout.CENTER);

          // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para o frame anterior
                frame.setVisible(false);
                frameAnterior.setVisible(true);
            }
        });
        painelPrincipal.add(botaoVoltar, BorderLayout.SOUTH);
        // Adicionando o painel principal ao frame
        frame.getContentPane().add(painelPrincipal);

        // Exibição do frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void exibirDetalhesComprador(Comprador comprador) {
    if (comprador != null) {
        String detalhes = "Nome: " + comprador.getNome() + "\n";
        detalhes += "Idade: " + comprador.getIdade() + "\n";
        detalhes += "Atrações Visitadas:\n";
        Map<Atracao, Integer> atracoesVisitadas = comprador.getAtracoesVisitadas();
        for (Map.Entry<Atracao, Integer> entry : atracoesVisitadas.entrySet()) {
            Atracao atracao = entry.getKey();
            int quantidadeVisitas = entry.getValue();
            
            detalhes += "Atração: " + atracao.getNome() + ", Visitas: " + quantidadeVisitas + "\n";
        }
        
        textAreaDetalhes.setText(detalhes);
    } else {
        textAreaDetalhes.setText("");
    }
}
}
