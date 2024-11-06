import java.awt.Color;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;import

class Operadores;

public final class CalculadoraDesktop extends JFrame {

    JTextField textoField1 = new JTextField();

    @SuppressWarnings({ "rawtypes", "unchecked" })
    JComboBox comboBox = new Operadores(sinal, descricao);
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
        textoField1.setText("Somente números");
        this.add(textoField1);

        comboBox.setName("Operadores");
        comboBox.setBounds(10, 70, 260, 30);
        // comboBox.setSelectedIndex(3);
        this.add(comboBox);

        textoField2.setBounds(10, 120, 260, 30);
        textoField2.setText("Somente números");
        this.add(textoField2);

        calcular.setBounds(10, 200, 100, 30);
        calcular.setText("Calcular");
        calcular.addActionListener(e->{
            if (comboBox == "+") {
                
            }
        });
        this.add(calcular);

        limpar.setBounds(120, 200, 100, 30);
        limpar.setText("Limpar");
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
        if (!isNumeric(str)) {
            JOptionPane.showMessageDialog(null,"O campo só pode ser numérico.");
            textoField1.requestFocus();
            return false;
        }
    }    

}
