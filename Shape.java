import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Shape extends JFrame 
{
    private JTextField textField;
    private JLabel label;
    private JScrollPane scrollPane;

    public Shape() {
        setTitle("Text Display Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        textField = new JTextField(20);
        label = new JLabel("JLabel Example:");
        scrollPane = new JScrollPane(textField);
        add(scrollPane);
        add(label);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String typedText = textField.getText();
                label.setText("Typed Text: " + typedText);
                textField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Shape x= new Shape();
        x.setVisible(true);
    }
}