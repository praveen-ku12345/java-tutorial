import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankManagementGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField accountNumberField;
    private JTextField depositField;
    private JTextArea displayArea;

    public BankManagementGUI() {
        setTitle("Bank Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        nameField = new JTextField(20);
        accountNumberField = new JTextField(20);
        depositField = new JTextField(20);
        displayArea = new JTextArea(10, 30);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);

        // Create a panel and add components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);
        panel.add(new JLabel("Deposit Amount:"));
        panel.add(depositField);
        panel.add(depositButton);

        // Add panel and display area to the frame
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String accountNumber = accountNumberField.getText();
        String depositAmount = depositField.getText();

        // Assuming a simple display of the entered information
        String displayText = "Name: " + name + "\nAccount Number: " + accountNumber
                + "\nDeposit Amount: " + depositAmount + "\n\n";

        displayArea.append(displayText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankManagementGUI());
    }
}
