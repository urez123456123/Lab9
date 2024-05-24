import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstForm extends JFrame {
    public JTextField speedOfSoundInLiquid;

    public FirstForm() {
        setupUI();
    }

    private void setupUI() {
        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();

        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("...");
        setLayout(layout);

        JLabel modulusOfElasticityLabel = new JLabel("пружність: ");
        c.gridx = 0;
        c.gridy = 0;
        add(modulusOfElasticityLabel, c);

        JTextField elasticityField = new JTextField(5);
        c.gridx = 1;
        c.gridy = 0;
        add(elasticityField, c);

        JLabel liquidDensityLabel = new JLabel("Щільність рідини: ");
        c.gridx = 0;
        c.gridy = 1;
        add(liquidDensityLabel, c);

        JTextField liquidDensityField = new JTextField(5);
        c.gridx = 1;
        c.gridy = 1;
        add(liquidDensityField, c);

        JButton calculateBtn = new JButton("Вирахувати");
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMaximumHeight(elasticityField, liquidDensityField, speedOfSoundInLiquid);
            }
        });
        c.gridx = 0;
        c.gridy = 2;
        add(calculateBtn, c);

        JLabel resultLabel = new JLabel("Швидкість звуку в рідині: ");
        c.gridx = 0;
        c.gridy = 4;
        add(resultLabel, c);

        speedOfSoundInLiquid = new JTextField(5);
        c.gridx = 1;
        c.gridy = 4;
        add(speedOfSoundInLiquid, c);
        speedOfSoundInLiquid.setEditable(false);

        setVisible(true);
    }

    private void calculateMaximumHeight(JTextField elasticityField, JTextField liquidDensityField, JTextField speedOfSoundInLiquidField) {
        try {
            double modulusOfElasticity = Double.parseDouble(elasticityField.getText());
            double liquidDensity = Double.parseDouble(liquidDensityField.getText());

            double speedOfSoundInLiquid = Math.sqrt(modulusOfElasticity / liquidDensity);
            speedOfSoundInLiquidField.setText(String.format("%.2f", speedOfSoundInLiquid));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введіть дійсні числові значення.");
        }
    }

    public static FirstForm invokeCode() {
        FirstForm app = new FirstForm();
        app.setVisible(true);
        return app;
    }

    public static void main(String[] args) {

    }
}