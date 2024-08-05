import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class CoffeeShopGUI extends JFrame {

    private JComboBox<String> coffeeTypeComboBox;
    private ButtonGroup sizeButtonGroup;
    private JCheckBox milkCheckBox, sugarCheckBox, whippedCreamCheckBox;

    private Map<String, Double> itemPrices;

    public CoffeeShopGUI() {
        // Set up the frame
        setTitle("Coffee Shop");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize item prices
        initializeItemPrices();

        // Create components
        coffeeTypeComboBox = new JComboBox<>(new String[]{"Espresso", "Latte", "Cappuccino", "Americano"});
        sizeButtonGroup = new ButtonGroup();
        milkCheckBox = new JCheckBox("Milk");
        sugarCheckBox = new JCheckBox("Sugar");
        whippedCreamCheckBox = new JCheckBox("Whipped Cream");

        // Create radio buttons for size
        JRadioButton smallRadioButton = new JRadioButton("Small");
        JRadioButton mediumRadioButton = new JRadioButton("Medium");
        JRadioButton largeRadioButton = new JRadioButton("Large");

        // Add radio buttons to the button group
        sizeButtonGroup.add(smallRadioButton);
        sizeButtonGroup.add(mediumRadioButton);
        sizeButtonGroup.add(largeRadioButton);

        // Create the "Place Order" button
        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create menu
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        // Add menu items with prices
        for (Map.Entry<String, Double> entry : itemPrices.entrySet()) {
            JMenuItem menuItem = new JMenuItem(entry.getKey() + " - $" + entry.getValue());
            menu.add(menuItem);
        }

        // Set layout with two columns
        setLayout(new GridLayout(6, 2, 10, 5)); // 10-pixel horizontal gap, 5-pixel vertical gap

        // Add components to the frame
        add(new JLabel("Coffee Type:"));
        add(coffeeTypeComboBox);

        add(new JLabel("Size:"));
        add(smallRadioButton);
        add(new JLabel(""));
        add(mediumRadioButton);
        add(new JLabel(""));
        add(largeRadioButton);

        add(new JLabel("Extras:"));
        add(milkCheckBox);
        add(new JLabel(""));
        add(sugarCheckBox);
        add(new JLabel(""));
        add(whippedCreamCheckBox);

        add(new JLabel(""));
        add(placeOrderButton);

        // Set the frame to be visible
        setVisible(true);
    }

    private void initializeItemPrices() {
        // Initialize item prices
        itemPrices = new HashMap<>();
        itemPrices.put("Espresso", 2.0);
        itemPrices.put("Latte", 3.5);
        itemPrices.put("Cappuccino", 4.0);
        itemPrices.put("Americano", 2.5);
        itemPrices.put("Small", 0.0);
        itemPrices.put("Medium", 1.0);
        itemPrices.put("Large", 2.0);
        itemPrices.put("Milk", 0.5);
        itemPrices.put("Sugar", 0.2);
        itemPrices.put("Whipped Cream", 0.8);
    }

    private void placeOrder() {
        StringBuilder orderSummary = new StringBuilder("Order Summary:\n");
        double totalPrice = 0.0;

        // Coffee type
        String selectedCoffeeType = (String) coffeeTypeComboBox.getSelectedItem();
        orderSummary.append("Coffee Type: ").append(selectedCoffeeType).append(" - $").append(itemPrices.get(selectedCoffeeType)).append("\n");
        totalPrice += itemPrices.get(selectedCoffeeType);

        // Determine selected size
        for (Enumeration<AbstractButton> buttons = sizeButtonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                orderSummary.append("Size: ").append(button.getText()).append(" - $").append(itemPrices.get(button.getText())).append("\n");
                totalPrice += itemPrices.get(button.getText());
            }
        }

        // Add extras
        if (milkCheckBox.isSelected()) {
            orderSummary.append("Extras: Milk - $").append(itemPrices.get("Milk")).append("\n");
            totalPrice += itemPrices.get("Milk");
        }
        if (sugarCheckBox.isSelected()) {
            orderSummary.append("Extras: Sugar - $").append(itemPrices.get("Sugar")).append("\n");
            totalPrice += itemPrices.get("Sugar");
        }
        if (whippedCreamCheckBox.isSelected()) {
            orderSummary.append("Extras: Whipped Cream - $").append(itemPrices.get("Whipped Cream")).append("\n");
            totalPrice += itemPrices.get("Whipped Cream");
        }

        // Display total price
        orderSummary.append("Total Price: $").append(totalPrice).append("\n");

        // Display order summary in a dialog
        JOptionPane.showMessageDialog(this, orderSummary.toString(), "Order Placed", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CoffeeShopGUI();
            }
        });
    }
}
