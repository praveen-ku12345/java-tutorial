import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankManagementGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField accountNumberField;
    private JTextField depositField;
    private JTextField withdrawField;
    private JTextArea displayArea;

    public BankManagementGUI() {
        setTitle("Bank Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        nameField = new JTextField(20);
        accountNumberField = new JTextField(20);
        depositField = new JTextField(20);
        withdrawField = new JTextField(20);
        displayArea = new JTextArea(10, 30);

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton deleteButton = new JButton("Delete Account");

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        deleteButton.addActionListener(this);

        // Create a panel and add components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);
        panel.add(new JLabel("Deposit Amount:"));
        panel.add(depositField);
        panel.add(new JLabel("Withdraw Amount:"));
        panel.add(withdrawField);
        panel.add(depositButton);
        panel.add(withdrawButton);

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

        if (e.getActionCommand().equals("Deposit")) {
            String depositAmount = depositField.getText();
            String displayText = "Deposit: " + depositAmount + " for Account Number: " + accountNumber + "\n";
            displayArea.append(displayText);
        } else if (e.getActionCommand().equals("Withdraw")) {
            String withdrawAmount = withdrawField.getText();
            String displayText = "Withdraw: " + withdrawAmount + " from Account Number: " + accountNumber + "\n";
            displayArea.append(displayText);
        } else if (e.getActionCommand().equals("Delete Account")) {
            String displayText = "Account Number " + accountNumber + " has been deleted.\n";
            displayArea.append(displayText);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankManagementGUI::new);
    }
}
