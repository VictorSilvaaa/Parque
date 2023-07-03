import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Tela_main {
    public Tela_main(Bilheteria bilheteria) {
        // Criação do frame
        JFrame frame = new JFrame("Exemplo de Frame com Painel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);

        // Criação do painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBounds(0, 0, 480, 400);

        // Criação dos botões
        JButton botao1 = new JButton("Cadastrar atração");
        botao1.setBounds(130, 50, 200, 50); // Posicionado abaixo do outro e centralizado verticalmente
        JButton botao2 = new JButton("Vender Ingresso");
        botao2.setBounds(130,110, 200, 50); // Posicionado abaixo do outro e centralizado verticalmente
        JButton botao3 = new JButton("Visitar uma Atracao");
        botao3.setBounds(130,170, 200, 50); // Posicionado abaixo do outro e centralizado verticalmente
        JButton botao4 = new JButton("Detalhar");
        botao4.setBounds(130,230, 200, 50); // Posicionado abaixo do outro e centralizado verticalmente

        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                tela_cadastrarAtracao tela_cadastrarAtracao = new tela_cadastrarAtracao(bilheteria, frame);      
            }
        });
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                frame.dispose();
                tela_venderIngresso tela_venderIngresso = new tela_venderIngresso(bilheteria, frame);           
            }
        });
        botao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela atual
                tela_visitarAtracao visitarAtracao = new tela_visitarAtracao(bilheteria, frame);
               
                
            }
        });
        botao4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela atual
                tela_detalhar detalhar = new tela_detalhar(bilheteria, frame);
               
                
            }
        });



        // Adicionando os botões ao painel principal
        painelPrincipal.add(botao1);
        painelPrincipal.add(botao2);
        painelPrincipal.add(botao3);
        painelPrincipal.add(botao4);

        // Adicionando o painel principal ao frame
        frame.getContentPane().add(painelPrincipal);

        // Exibição do frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
