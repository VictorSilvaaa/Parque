import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class tela_venderIngresso extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldAltura;
    private JComboBox<Atracao> comboBoxAtracoes;

    public tela_venderIngresso(Bilheteria bilheteria, JFrame frameAnterior) {
        setTitle("Vender Ingresso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelNome = new JLabel("Nome:");
        textFieldNome = new JTextField();
        panel.add(labelNome);
        panel.add(textFieldNome);

        JLabel labelIdade = new JLabel("Idade:");
        textFieldIdade = new JTextField();
        panel.add(labelIdade);
        panel.add(textFieldIdade);

        JLabel labelAltura = new JLabel("Altura:");
        textFieldAltura = new JTextField();
        panel.add(labelAltura);
        panel.add(textFieldAltura);


        JButton buttonConfirmar = new JButton("Confirmar");
        buttonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                int idade = Integer.parseInt(textFieldIdade.getText());
                int altura = Integer.parseInt(textFieldAltura.getText());
               
                Comprador newComprador = new Comprador(nome, idade, altura);
                bilheteria.adicionarComprador(newComprador);
                // Realize as ações desejadas com os dados do ingresso vendido
               // dispose(); // Fecha a tela atual
            }
        });
        panel.add(buttonConfirmar);

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                frameAnterior.setVisible(true);
            }
        });
        panel.add(buttonVoltar);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
