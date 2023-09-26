import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LotaFacilGUi {

    private char letraPremiada = 'M'; // Letra premiada (altere para sua inicial)
    private int tentativas = 0;
    private Random random = new Random();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LotaFacilGUi().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("LotaFacil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Bem-vindo à LotaFacil!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton numeroButton = new JButton("Aposta de número");
        JButton letraButton = new JButton("Aposta de letra");
        JButton parButton = new JButton("Aposta em número par");
        JButton sairButton = new JButton("Sair");

        numeroButton.addActionListener(e -> jogarNumero(frame));
        letraButton.addActionListener(e -> jogarLetra(frame));
        parButton.addActionListener(e -> jogarPar(frame));
        sairButton.addActionListener(e -> System.exit(0));

        panel.add(titleLabel);
        panel.add(numeroButton);
        panel.add(letraButton);
        panel.add(parButton);
        panel.add(sairButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void jogarNumero(JFrame frame) {
        int numeroSorteado = random.nextInt(101);
        boolean ganhou = false;

        while (!ganhou) {
            tentativas++;

            String input = JOptionPane.showInputDialog(frame, "Digite um número de 0 a 100:");
            if (input != null) {
                try {
                    int numeroApostado = Integer.parseInt(input);
                    if (numeroApostado < 0 || numeroApostado > 100) {
                        JOptionPane.showMessageDialog(frame, "Aposta inválida.");
                    } else if (numeroApostado == numeroSorteado) {
                        JOptionPane.showMessageDialog(frame, "Você ganhou R$ 1.000,00 reais!\nTentativas: " + tentativas);
                        ganhou = true;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Que pena! O número sorteado foi: " + numeroSorteado + "\nTentativas: " + tentativas);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Aposta inválida.");
                }
            } else {
                break; // O usuário cancelou a entrada.
            }

            // Gere um novo número sorteado para a próxima tentativa
            numeroSorteado = random.nextInt(101);
        }
    }

    private void jogarLetra(JFrame frame) {
        boolean ganhou = false;

        while (!ganhou) {
            tentativas++;

            String input = JOptionPane.showInputDialog(frame, "Digite uma letra de A a Z:");
            if (input != null && input.length() == 1 && Character.isLetter(input.charAt(0))) {
                char letraApostada = input.toUpperCase().charAt(0);
                if (letraApostada == letraPremiada) {
                    JOptionPane.showMessageDialog(frame, "Você ganhou R$ 500,00 reais!\nTentativas: " + tentativas);
                    ganhou = true;
                } else {
                    JOptionPane.showMessageDialog(frame, "Que pena! A letra sorteada foi: " + letraPremiada + "\nTentativas: " + tentativas);
                }
            } else if (input != null) {
                JOptionPane.showMessageDialog(frame, "Aposta inválida.");
            } else {
                break; // O usuário cancelou a entrada.
            }
        }
    }

    private void jogarPar(JFrame frame) {
        boolean ganhou = false;

        while (!ganhou) {
            tentativas++;

            String input = JOptionPane.showInputDialog(frame, "Digite um número inteiro:");
            if (input != null) {
                try {
                    int numeroPar = Integer.parseInt(input);
                    if (numeroPar % 2 == 0) {
                        JOptionPane.showMessageDialog(frame, "Você ganhou R$ 100,00 reais!\nTentativas: " + tentativas);
                        ganhou = true;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Que pena! O número digitado é ímpar e a premiação foi para números pares.\nTentativas: " + tentativas);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Aposta inválida.");
                }
            } else {
                break; // O usuário cancelou a entrada.
            }
        }
    }
}
