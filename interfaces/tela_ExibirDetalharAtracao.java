import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class tela_ExibirDetalharAtracao extends JFrame {
    private JComboBox<Atracao> comboBoxAtracoes;
    private JTextArea textAreaDetalhes;

    public tela_ExibirDetalharAtracao(Bilheteria bilheteria, JFrame frameAnterior) {
        JFrame frame = new JFrame("Detalhar Atracao");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // ComboBox de Compradores
        comboBoxAtracoes = new JComboBox<>();
        List<Atracao> atracoes= bilheteria.getAtracoes();
        for (Atracao atracao : atracoes) {
            comboBoxAtracoes.addItem(atracao);
        }
        comboBoxAtracoes.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Atracao) {
                    Atracao atracao = (Atracao) value;
                    setText(atracao.getNome());
                }
                return this;
            }
        });
        comboBoxAtracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Atracao AtracaoSelecionado = (Atracao) comboBoxAtracoes.getSelectedItem();
                exibirDetalhesAtracao(AtracaoSelecionado);
            }
        });

        // Área de detalhes
        textAreaDetalhes = new JTextArea();
        textAreaDetalhes.setEditable(false);

        // Painel de seleção de compradores
        JPanel painelCompradores = new JPanel(new FlowLayout());
        painelCompradores.add(new JLabel("Atracoes:"));
        painelCompradores.add(comboBoxAtracoes);

       

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

    private void exibirDetalhesAtracao(Atracao atracao) {
    if (atracao != null) {
        String detalhes = "Nome: " + atracao.getNome() + "\n";
        detalhes+= "Capacidade: " + atracao.getCapacidade() + "\n";
        detalhes+= "Altura minima: " + atracao.getAlturaMinima() + "\n";
        detalhes+= "Restrição Idade: " + atracao.getRestricaoIdade() + "\n";
        detalhes+= "Horario funcionamento: " + atracao.getHoraAbertura() + "-" + atracao.getHoraFechamento()+"\n";

        textAreaDetalhes.setText(detalhes);
    } else {
        textAreaDetalhes.setText("");
    }
}
}
