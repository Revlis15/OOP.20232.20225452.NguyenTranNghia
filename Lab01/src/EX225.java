import javax.swing.JOptionPane;
public class EX225 {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null,
        "Please input the first number: ", "Input the first number",
        JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
        "Please input the second number: ", "Input the second number",
        JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum, difference, product, quotient;
        sum = num1 + num2;
        difference = num1 - num2;
        product = num1 * num2;
        quotient = num1 / num2;

        JOptionPane.showMessageDialog(null,  "Sum: " + String.format("%.2f",sum) + "\nDifference: " + String.format("%.2f",difference) + "\nProduct: " + String.format("%.2f",product) + "\nQuotient: " + String.format("%.2f",quotient), "Calculate result", 0);
        System.exit(0);
    }    
}
