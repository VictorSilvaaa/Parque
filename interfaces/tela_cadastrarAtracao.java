import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalTime;
import java.util.List;
import java.awt.GridLayout;
import java.lang.NumberFormatException;
import java.awt.Component;



public class tela_cadastrarAtracao extends JFrame {
    public Bilheteria bilheteria;
    private JComboBox<Comprador> comboBoxCompradores;
    private JComboBox<Atracao> comboBoxAtracoes;
    public tela_cadastrarAtracao(Bilheteria bilheteria, JFrame frameAnterior) {
        
        this.bilheteria = bilheteria;
        // Criação do frame
        JFrame frame = new JFrame("Castradastrar Atracao");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        // Criação do painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBounds(0, 0, 480, 400);

        // Criação dos botões
        JButton botao1 = new JButton("Brinquedo");
        botao1.setBounds(130, 70, 200, 50); // Posicionado abaixo do outro e centralizado verticalmente
        JButton botao2 = new JButton("Lanchonete");
        botao2.setBounds(130,130, 200, 50); // Posicionado abaixo do outro e centralizado verticalmente
        JButton botao3 = new JButton("Voltar");
        botao3.setBounds(130,190, 200, 50); // Posicionado abaixo do outro e centralizado verticalmente
        

        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                exibeTelaCadastroBrinquedo(frame);
                //dispose();          
            }
        });
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                exibeTelaCadastroLanchonete(frame);
                //dispose();          
            }
        });
        botao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameAnterior.setVisible(true);
                //dispose();          
            }
        });


        // Adicionando os botões ao painel principal
        painelPrincipal.add(botao1);
        painelPrincipal.add(botao2);
        painelPrincipal.add(botao3);

        // Adicionando o painel principal ao frame
        frame.getContentPane().add(painelPrincipal);

        // Exibição do frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void exibeTelaCadastroBrinquedo(JFrame frameAnterior){
        JFrame frame = new JFrame("Formulário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(8, 2, 10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label e campo para a capacidade
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();
        painelPrincipal.add(labelNome);
        painelPrincipal.add(campoNome);

        // Label e campo para a capacidade
        JLabel labelCapacidade = new JLabel("Capacidade:");
        JTextField campoCapacidade = new JTextField();
        painelPrincipal.add(labelCapacidade);
        painelPrincipal.add(campoCapacidade);

        // Label e campo para a altura mínima
        JLabel labelAlturaMinima = new JLabel("Altura Mínima:");
        JTextField campoAlturaMinima = new JTextField();
        painelPrincipal.add(labelAlturaMinima);
        painelPrincipal.add(campoAlturaMinima);

        // Label e campo para a restrição de idade
        JLabel labelRestricaoIdade = new JLabel("Restrição de Idade:");
        JTextField campoRestricaoIdade = new JTextField();
        painelPrincipal.add(labelRestricaoIdade);
        painelPrincipal.add(campoRestricaoIdade);

        // Label e campo para a hora de abertura
        JLabel labelHoraAbertura = new JLabel("Hora de Abertura (HH:mm):");
        JTextField campoHoraAbertura = new JTextField();
        painelPrincipal.add(labelHoraAbertura);
        painelPrincipal.add(campoHoraAbertura);

        // Label e campo para a hora de fechamento
        JLabel labelHoraFechamento = new JLabel("Hora de Fechamento (HH:mm):");
        JTextField campoHoraFechamento = new JTextField();
        painelPrincipal.add(labelHoraFechamento);
        painelPrincipal.add(campoHoraFechamento);

        //listar atracoes
        JLabel labelAtracoes = new JLabel("Dependencia");
        comboBoxAtracoes = new JComboBox<>();
        List<Atracao> atracoes = bilheteria.getAtracoes();
        comboBoxAtracoes.addItem(null);
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




         // Botão Confirmar
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String nome;
                    int capacidade;
                    float alturaMinima;
                    int restricaoIdade;
                    LocalTime horaAbertura;
                    LocalTime horaFechamento;
                    Atracao itemSelecionado;
                   
                    nome = campoNome.getText();
                    capacidade = Integer.parseInt(campoCapacidade.getText());
                    alturaMinima = Float.parseFloat(campoAlturaMinima.getText());
                    restricaoIdade = Integer.parseInt(campoRestricaoIdade.getText());
                    horaAbertura = LocalTime.parse(campoHoraAbertura.getText());
                    horaFechamento = LocalTime.parse(campoHoraFechamento.getText());
                    itemSelecionado = (Atracao) comboBoxAtracoes.getSelectedItem();
                                        
                    Brinquedo newBrinquedo = new Brinquedo(nome, capacidade, alturaMinima, restricaoIdade, horaAbertura, horaFechamento, itemSelecionado);
                    bilheteria.adicionarAtracao(newBrinquedo, capacidade);                    
    }});
        painelPrincipal.add(botaoConfirmar);

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
        painelPrincipal.add(botaoVoltar);


        frame.getContentPane().add(painelPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void exibeTelaCadastroLanchonete(JFrame frameAnterior){
        JFrame frame = new JFrame("Formulário Lanchonete");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(6, 2, 10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label e campo para a capacidade
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();
        painelPrincipal.add(labelNome);
        painelPrincipal.add(campoNome);

        // Label e campo para a capacidade
        JLabel labelCapacidade = new JLabel("Capacidade:");
        JTextField campoCapacidade = new JTextField();
        painelPrincipal.add(labelCapacidade);
        painelPrincipal.add(campoCapacidade);

        // Label e campo para a hora de abertura
        JLabel labelHoraAbertura = new JLabel("Hora de Abertura (HH:mm):");
        JTextField campoHoraAbertura = new JTextField();
        painelPrincipal.add(labelHoraAbertura);
        painelPrincipal.add(campoHoraAbertura);

        // Label e campo para a hora de fechamento
        JLabel labelHoraFechamento = new JLabel("Hora de Fechamento (HH:mm):");
        JTextField campoHoraFechamento = new JTextField();
        painelPrincipal.add(labelHoraFechamento);
        painelPrincipal.add(campoHoraFechamento);

        //listar atracoes
        JLabel labelAtracoes = new JLabel("Dependencia");
        comboBoxAtracoes = new JComboBox<>();
        List<Atracao> atracoes = bilheteria.getAtracoes();
        comboBoxAtracoes.addItem(null);
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

        // Botão Confirmar
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String nome = campoNome.getText();
                    int capacidade = Integer.parseInt(campoCapacidade.getText());
                    LocalTime horaAbertura = LocalTime.parse(campoHoraAbertura.getText());
                    LocalTime horaFechamento = LocalTime.parse(campoHoraFechamento.getText());
                    Atracao itemSelecionado = (Atracao) comboBoxAtracoes.getSelectedItem();
                    Lanchonete newLanchonete = new Lanchonete(nome, capacidade, horaAbertura, horaFechamento, itemSelecionado);
                    bilheteria.detalharAtracoes();
                    bilheteria.adicionarAtracao(newLanchonete, capacidade);
                    bilheteria.detalharAtracoes();
                    JOptionPane.showMessageDialog(null, "Atração cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE); 
                
            }
        });
        painelPrincipal.add(botaoConfirmar);

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
        painelPrincipal.add(botaoVoltar);

        frame.getContentPane().add(painelPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }







}
