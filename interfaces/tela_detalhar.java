import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class tela_detalhar extends JFrame {
    private JComboBox<Comprador> comboBoxCompradores;
    private JTextArea textAreaDetalhes;
    public tela_detalhar(Bilheteria bilheteria, JFrame frameAnterior) {
        // Criação do frame
        JFrame frame = new JFrame("Detalhar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBounds(0, 0, 480, 400);
        JButton botaoDetalharAtracao = new JButton("Detalhar Atração");
        JButton botaoDetalharUsuario = new JButton("Detalhar Usuário");
        JButton botaoVoltar = new JButton("Voltar");

    
        botaoDetalharAtracao.setBounds(130, 100, 200, 50); 
        botaoDetalharUsuario.setBounds(130, 160, 200, 50); 
        botaoVoltar.setBounds(130, 220, 200, 50); 
       

        botaoDetalharAtracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ExibirDetalharAtracao exibirAtracao = new ExibirDetalharAtracao();
            }
        });

        botaoDetalharUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ExibirDetalharUsuario exibirUsuario = new ExibirDetalharUsuario(bilheteria, frame);
            }
        });

         botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para o frame anterior
                frame.setVisible(false);
                frameAnterior.setVisible(true);
            }
        });

        painelPrincipal.add(botaoDetalharAtracao);
        painelPrincipal.add(botaoDetalharUsuario);
        painelPrincipal.add(botaoVoltar);

        
        // Adicionando o painel principal ao frame
        frame.getContentPane().add(painelPrincipal);

        // Exibição do frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

class ExibirDetalharAtracao extends JFrame {
    public ExibirDetalharAtracao() {
        // Criação do frame
        JFrame frame = new JFrame("Detalhar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        JPanel painelPrincipal = new JPanel(new FlowLayout());
    
        // Lógica para exibir detalhes da atração
        JLabel label = new JLabel("Detalhes da Atração");
        painelPrincipal.add(label);

         // Adicionando o painel principal ao frame
        frame.getContentPane().add(painelPrincipal);

        // Exibição do frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}

