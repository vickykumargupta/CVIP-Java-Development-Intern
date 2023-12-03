import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorApp extends JFrame {

    private JTextField heightField, weightField, bmiResultField;

    public BMICalculatorApp() {
        setTitle("BMI Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        JLabel heightLabel = new JLabel("Enter your height (m):");
        JLabel weightLabel = new JLabel("Enter your weight (kg):");
        JLabel bmiLabel = new JLabel("Your BMI:");

        heightField = new JTextField(10);
        weightField = new JTextField(10);
        bmiResultField = new JTextField(10);
        bmiResultField.setEditable(false);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

       
        setLayout(new GridLayout(4, 2));

        
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(bmiLabel);
        add(bmiResultField);
        add(new JLabel()); 
        add(calculateButton);

        
        setVisible(true);
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double bmi = calculateBMI(height, weight);
            bmiResultField.setText(String.format("%.2f", bmi));
            interpretBMI(bmi);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for height and weight.");
        }
    }

    private double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    private void interpretBMI(double bmi) {
        String interpretation;
        if (bmi < 18.5) {
            interpretation = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            interpretation = "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            interpretation = "Overweight";
        } else {
            interpretation = "Obese";
        }
        JOptionPane.showMessageDialog(this, "BMI Interpretation: " + interpretation);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           
            public void run() {
                new BMICalculatorApp();
            }
        });
    }
}
