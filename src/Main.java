import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static double balance = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banking System");
        frame.setSize(400,200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2)) ;
        frame.add(panel);

        JLabel balanceLabel = new JLabel("Balance amount: ");
        panel.add(balanceLabel);

        JLabel balanceValue = new JLabel("₹" + balance);
        panel.add(balanceValue);

        JLabel amountLabel = new JLabel("Amount: ");
        panel.add(amountLabel);

        JTextField amountText = new JTextField();
        panel.add(amountText);

        JButton depositButton = new JButton("Deposit");
        depositButton.setFocusable(false);
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setFocusable(false);
        panel.add(withdrawButton);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountText.getText());
                if (amount >= 0) {
                    balance += amount;
                    balanceValue.setText("₹" + balance);
                    JOptionPane.showMessageDialog(frame, "Deposit Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Deposit Unsuccessful", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountText.getText());
                if(amount > balance){
                    JOptionPane.showMessageDialog(frame,"Insufficient funds!","Error", JOptionPane.ERROR_MESSAGE);
                } else if(amount <= balance){
                    balance -= amount;
                    balanceValue.setText("₹" + balance);
                    JOptionPane.showMessageDialog(frame,"Withdrawal Successful","Success",JOptionPane.INFORMATION_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(frame,"Invalid Amount!","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
}