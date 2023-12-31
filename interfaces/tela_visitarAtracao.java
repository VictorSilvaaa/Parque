import javax.swing.*;
import javax.swing.RowFilter.Entry;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class tela_visitarAtracao extends JFrame {
    private JComboBox<Comprador> comboBoxCompradores;
    private JComboBox<Atracao> comboBoxAtracoes;

    public tela_visitarAtracao(Bilheteria bilheteria, JFrame frameAnterior) {
         
        // Criação do frame
        JFrame frame = new JFrame("Visitar Atrações");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(4, 1, 10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Criação dos componentes da tela
        JLabel labelCompradores = new JLabel("Compradores:");
        JLabel labelAtracoes = new JLabel("Atrações:");
        JButton buttonConfirmar = new JButton("Confirmar");
        JButton buttonVoltar = new JButton("Voltar");

        //listar atracoes
        comboBoxAtracoes = new JComboBox<>();
        List<Atracao> atracoes = bilheteria.getAtracoes();
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
        painelPrincipal.add(labelAtracoes);
        painelPrincipal.add(comboBoxAtracoes);

        //listar compradores
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
                    Comprador comprador = (Comprador) value;
                    setText(comprador.getNome());
                }
                return this;
            }
        });
        painelPrincipal.add(labelCompradores);
        painelPrincipal.add(comboBoxCompradores);

        
        // Configuração do ActionListener para o botão "Confirmar"
        buttonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comprador compradorSelecionado = (Comprador) comboBoxCompradores.getSelectedItem();
                Atracao atracaoSelecionada = (Atracao) comboBoxAtracoes.getSelectedItem();
                boolean flag = false;
                if (atracaoSelecionada.getDependeAtracao() != null) {
                    for (Map.Entry<Atracao, Integer> atracao : compradorSelecionado.getAtracoesVisitadas().entrySet()) {
                        Atracao chave = atracao.getKey();
                        if (chave.getNome().equals(atracaoSelecionada.getDependeAtracao().getNome())) {
                            // O comprador já visitou a atração necessária
                           flag = true;
                        } 
                    }           
                }
                if(atracaoSelecionada.getDependeAtracao()==null || flag == true){
                    compradorSelecionado.visitarAtracao(atracaoSelecionada);
                    JOptionPane.showMessageDialog(null, "Atração visitada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    frameAnterior.setVisible(true);
                }else{ 
                    JOptionPane.showMessageDialog(null, "Não é possível visitar essa atração sem antes visitar a atração dependente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    dispose();
                    frameAnterior.setVisible(true);
                    // Exibir a tela de aviso ou tomar outras ações necessárias
                }
            }
        });

        // Configuração do ActionListener para o botão "Voltar"
        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela ao voltar
                frameAnterior.setVisible(true);
            }
        });

        painelPrincipal.add(buttonConfirmar);
        painelPrincipal.add(buttonVoltar);
        
        // Adicionando o painel principal ao frame
        frame.getContentPane().add(painelPrincipal);
        

        // Exibição do frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
