import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalculadoraDesktop extends JFrame {

    JTextField textoField1 = new JTextField();
    String operadores[]={"+","-","x",":"};
    @SuppressWarnings({ "rawtypes", "unchecked" })
    JComboBox comboBox = new JComboBox(operadores);
    JTextField textoField2 = new JTextField();
    JButton calcular = new JButton();
    JButton limpar = new JButton();
    Label resultado = new Label();

    public CalculadoraDesktop() {
        super();
        iniciarTela();
    }

    public void iniciarTela() {
        this.setTitle("Calculadora - Atividade Dsktp");
        this.setSize(300, 280);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        textoField1.setBounds(10, 20, 260, 30);
        this.add(textoField1);

        comboBox.setName("Operadores");
        comboBox.setBounds(10, 70, 260, 30);
        // comboBox.setSelectedIndex(3);
        this.add(comboBox);

        textoField2.setBounds(10, 120, 260, 30);
        this.add(textoField2);

        calcular.setBounds(10, 200, 100, 30);
        calcular.setText("Calcular");
        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(textoField1.getText());
                    double num2 = Double.parseDouble(textoField2.getText());
                    String operador = (String) comboBox.getSelectedItem();
                    double res = 0;
                    
                    switch (operador) {
                        case "+":
                            res = num1 + num2;
                            break;
                        case "-":
                            res = num1 - num2;
                            break;
                        case "x":
                            res = num1 * num2;
                            break;
                        case ":":
                            if (num2 != 0) {
                                res = num1 / num2;
                            } else {
                                resultado.setText("Erro: Divisão por zero");
                                return;
                            }
                            break;
                        }
                        
                        resultado.setText("Resultado: " + res);
                } catch (NumberFormatException ex) {
                    resultado.setText("Erro: Entrada inválida");
                }
            }

        });
        this.add(calcular);

        limpar.setBounds(120, 200, 100, 30);
        limpar.setText("Limpar");
        limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textoField1.setText("");
                textoField2.setText("");
                resultado.setText("");
            }
        });
        this.add(limpar);

        resultado.setBounds(10, 160, 260, 30);
        resultado.setText("Resultado");
        resultado.setForeground(Color.RED);
        this.add(resultado);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraDesktop();
    }

    boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean validaFormulario(String str) {
        if (!isNumeric(textoField1.getText())) {
            JOptionPane.showMessageDialog(null, "O campo só pode ser numérico.");
            textoField1.requestFocus();
            return false;
        }
        if (!isNumeric(textoField2.getText())) {
            JOptionPane.showMessageDialog(null, "O campo só pode ser numérico.");
            textoField1.requestFocus();
            return false;
        }
        return true;
    }

}
