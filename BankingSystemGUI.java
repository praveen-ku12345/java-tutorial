import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class BankingSystemGUI extends JFrame {
    private JButton depositButton, withdrawButton, checkBalanceButton, createAccountButton, deleteAccountButton, retrievePasswordButton;
    private JLabel balanceLabel, accountLabel;
    private JTextField amountField, usernameField, passwordField;
    private double balance = 1000.0; // Initial balance
    private Map<String, String> accountData = new HashMap<>(); // Store account data (Username, Password)
    private ArrayList<String> accountList = new ArrayList<>(); // Store account usernames

    private String currentUser = null; // Track the currently logged-in user

    public BankingSystemGUI() {
        setTitle("Banking System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        checkBalanceButton = new JButton("Check Balance");
        createAccountButton = new JButton("Create Account");
        deleteAccountButton = new JButton("Delete Account");
        retrievePasswordButton = new JButton("Retrieve Password");

        balanceLabel = new JLabel("Balance: $" + balance);
        accountLabel = new JLabel("Accounts: " + accountList);

        amountField = new JTextField(10);
        usernameField = new JTextField(10);
        passwordField = new JTextField(10);

        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(checkBalanceButton);
        panel.add(createAccountButton);
        panel.add(deleteAccountButton);
        panel.add(retrievePasswordButton);
        panel.add(balanceLabel);
        panel.add(accountLabel);

        panel.add(new JLabel("Amount: "));
        panel.add(amountField);
        panel.add(new JLabel("Username: "));
        panel.add(usernameField);
        panel.add(new JLabel("Password: "));
        panel.add(passwordField);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(null, "Please log in first.");
                } else {
                    // Deposit logic
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(null, "Please log in first.");
                } else {
                    // Withdraw logic
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(null, "Please log in first.");
                } else {
                    // Check balance logic
                }
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                if (!username.isEmpty() && !password.isEmpty() && !accountData.containsKey(username)) {
                    accountData.put(username, password);
                    accountList.add(username);
                    updateAccountLabel();
                    JOptionPane.showMessageDialog(null, "Account created successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or username already exists.");
                }
            }
        });

        deleteAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                if (accountData.containsKey(username)) {
                    accountData.remove(username);
                    accountList.remove(username);
                    updateAccountLabel();
                    JOptionPane.showMessageDialog(null, "Account deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Account not found.");
                }
            }
        });

        retrievePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                if (accountData.containsKey(username)) {
                    String password = accountData.get(username);
                    JOptionPane.showMessageDialog(null, "Password for " + username + " is: " + password);
                } else {
                    JOptionPane.showMessageDialog(null, "Account not found.");
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: $" + balance);
    }

    private void updateAccountLabel() {
        accountLabel.setText("Accounts: " + accountList);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankingSystemGUI());
    }
}
