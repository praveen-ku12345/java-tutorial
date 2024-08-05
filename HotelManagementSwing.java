import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManagementSwing extends JFrame {

    private JTextField nameField, contactField, genderField;
    private JComboBox<String> roomTypeComboBox;
    private List<String> selectedFoodItems;
    private List<String> bookedRooms;
    private Map<String, Integer> foodPrices;

    public HotelManagementSwing() {
        setTitle("Hotel Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new JLabel("Customer Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Contact Number:"));
        contactField = new JTextField();
        add(contactField);

        add(new JLabel("Gender:"));
        genderField = new JTextField();
        add(genderField);

        add(new JLabel("Room Type:"));
        String[] roomTypes = {"Luxury Double Room", "Deluxe Double Room", "Luxury Single Room", "Deluxe Single Room"};
        roomTypeComboBox = new JComboBox<>(roomTypes);
        add(roomTypeComboBox);

        JButton bookButton = new JButton("Book Room");
        JButton displayButton = new JButton("Display Room Details");
        JButton orderFoodButton = new JButton("Order Food");
        JButton displayBookedRoomsButton = new JButton("Display Booked Rooms");
        JButton checkoutButton = new JButton("Checkout");
        JButton exitButton = new JButton("Exit");

        add(bookButton);
        add(displayButton);
        add(orderFoodButton);
        add(displayBookedRoomsButton);
        add(checkoutButton);
        add(exitButton);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookRoom();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRoomDetails();
            }
        });

        orderFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderFood();
            }
        });

        displayBookedRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBookedRooms();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        selectedFoodItems = new ArrayList<>();
        bookedRooms = new ArrayList<>();
        foodPrices = new HashMap<>();
        initializeFoodPrices();

        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
    }

    private void initializeFoodPrices() {
        foodPrices.put("Burger", 8);
        foodPrices.put("Pizza", 12);
        foodPrices.put("Pasta", 10);
        foodPrices.put("Salad", 5);
        foodPrices.put("Soft Drink", 2);
    }

    private void bookRoom() {
        String name = nameField.getText().trim();
        String contact = contactField.getText().trim();
        String gender = genderField.getText().trim();
        String roomType = (String) roomTypeComboBox.getSelectedItem();

        // Validate customer details
        if (name.isEmpty() || !isValidName(name) || !isValidPhoneNumber(contact) || gender.isEmpty() || !isValidGender(gender)) {
            JOptionPane.showMessageDialog(this, "Please enter valid customer details.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Implement booking logic here
        int roomCost = getRoomCost(roomType);
        bookedRooms.add("Name: " + name + ", Room Type: " + roomType + ", Cost: $" + roomCost);
        JOptionPane.showMessageDialog(this, "Booking Room...\nName: " + name + "\nContact: " + contact + "\nGender: " + gender +
                "\nRoom Type: " + roomType + "\nCost: $" + roomCost);
        clearFields();
    }

    private boolean isValidName(String name) {
        // Implement name validation logic (for example, at least 3 characters)
        return name.length() >= 3;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Implement phone number validation logic (for example, 10 digits)
        return phoneNumber.matches("\\d{10}");
    }

    private boolean isValidGender(String gender) {
        // Implement gender validation logic (for example, "Male" or "Female")
        return gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female");
    }

    private int getRoomCost(String roomType) {
        // Implement room cost based on room type
        switch (roomType) {
            case "Luxury Double Room":
                return 4000;
            case "Deluxe Double Room":
                return 3000;
            case "Luxury Single Room":
                return 2200;
            case "Deluxe Single Room":
                return 1200;
            default:
                return 0;
        }
    }

    private void displayRoomDetails() {
        String roomType = (String) roomTypeComboBox.getSelectedItem();
        // Implement room details display logic here
        JOptionPane.showMessageDialog(this, "Displaying Room Details...\nRoom Type: " + roomType + "\nDetails: " + getRoomDetails(roomType));
    }

    private String getRoomDetails(String roomType) {
        // Implement room details based on room type
        switch (roomType) {
            case "Luxury Double Room":
                return "Number of double beds: 1\nAC: Yes\nFree breakfast: Yes\nCharge per day: 4000";
            case "Deluxe Double Room":
                return "Number of double beds: 1\nAC: No\nFree breakfast: Yes\nCharge per day: 3000";
            case "Luxury Single Room":
                return "Number of single beds: 1\nAC: Yes\nFree breakfast: Yes\nCharge per day: 2200";
            case "Deluxe Single Room":
                return "Number of single beds: 1\nAC: No\nFree breakfast: Yes\nCharge per day: 1200";
            default:
                return "Invalid room type";
        }
    }

    private void orderFood() {
        // Implement food ordering logic here
        String roomType = (String) roomTypeComboBox.getSelectedItem();

        // Display food items and prices
        StringBuilder foodMenu = new StringBuilder("Food Menu:\n");
        for (Map.Entry<String, Integer> entry : foodPrices.entrySet()) {
            foodMenu.append(entry.getKey()).append(": $").append(entry.getValue()).append("\n");
        }

        // Let the user select food items
        String[] foodOptions = foodPrices.keySet().toArray(new String[0]);
        String selectedFood = (String) JOptionPane.showInputDialog(this, foodMenu.toString(), "Order Food", JOptionPane.PLAIN_MESSAGE, null, foodOptions, null);

        if (selectedFood != null) {
            selectedFoodItems.add(selectedFood);
            JOptionPane.showMessageDialog(this, "Ordered " + selectedFood + " for Room Type: " + roomType);
        }
    }

    private void displayBookedRooms() {
        if (bookedRooms.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No rooms booked yet.", "Booked Rooms", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder bookedRoomsInfo = new StringBuilder("Booked Rooms:\n");
            for (String roomInfo : bookedRooms) {
                bookedRoomsInfo.append(roomInfo).append("\n");
            }
            JOptionPane.showMessageDialog(this, bookedRoomsInfo.toString(), "Booked Rooms", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void checkout() {
        String name = nameField.getText();
        String roomType = (String) roomTypeComboBox.getSelectedItem();

        // Implement checkout logic here
        int option = JOptionPane.showConfirmDialog(this, "Do you want to checkout for " + name + " - " + roomType + "?", "Checkout", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Checking Out...\nName: " + name + "\nRoom Type: " + roomType);
            clearFields();
        }
    }

    private void clearFields() {
        nameField.setText("");
        contactField.setText("");
        genderField.setText("");
        roomTypeComboBox.setSelectedIndex(0);
        selectedFoodItems.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelManagementSwing();
            }
        });
    }
}
