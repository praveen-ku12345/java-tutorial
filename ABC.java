package com.company;
public class Main {
public static void main(String[] args) {
new Airplane();
}
}
package com.company;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.DateFormat;
import java.util.Vector;
public class Airplane {
private JTextField nameData;
private JTextField sourceData;
private JTable table1;
private JButton SEARCHButton;
private JButton BOOKButton;
private JPanel airPanel;
private JTextField fee;
private JTextField exp;
private JTextField destination;
private JPanel doj;
private JSpinner spinner1;
private JTextArea boarding;
private JLabel fare;
private JButton RESETButton;
JFrame planeF = new JFrame();
JDateChooser dateChooser = new JDateChooser();
public Airplane(){
planeF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
planeF.setContentPane(airPanel);
planeF.pack();
planeF.setLocationRelativeTo(null);
doj.add(dateChooser);
planeF.setVisible(true);
fare.setText("0");
SEARCHButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if(destination.getText().equals("")|| sourceData.getText().equals("")){
JOptionPane.showMessageDialog(null,"Please Fill SOURCE & DESTINATION TO SEARCH.");
}else{
try {
String sql = "select * from airplane WHERE SOURCE= '"+sourceData.getText()+"' AND DESTINATION= '"+destination.getText()+"'";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern","root","root");
Statement statement = connection.createStatement();
ResultSet rs = statement.executeQuery(sql);
if(!rs.next())
JOptionPane.showMessageDialog(null,"NO FLIGHTS AVAILABLE");
else{
ResultSet rs1 = statement.executeQuery(sql);
table1.setModel(buildTableModel(rs1));
}
}catch (Exception ex){
JOptionPane.showMessageDialog(null,ex.getMessage());
}
}
}
});
BOOKButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(null,"FIND YOUR BOARDING PASS ATTACHED");
printPass();
}
});
table1.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
DefaultTableModel dm = (DefaultTableModel)table1.getModel();
int selectedRow = table1.getSelectedRow();
int a =(int)dm.getValueAt(selectedRow,4);
String total = String.valueOf(a*(int)spinner1.getValue());
fare.setText(total);
}
});
RESETButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
planeF.dispose();
new Airplane();
}
});
}
public void printPass(){
DefaultTableModel dms = (DefaultTableModel)table1.getModel();
int selectedRow1 = table1.getSelectedRow();
String date = DateFormat.getDateInstance().format(dateChooser.getDate());
boarding.setText(boarding.getText() + " BOARDING PASS"+"\n");
boarding.setText(boarding.getText() + " ------***------"+"\n");
boarding.setText(boarding.getText() + "\n");
boarding.setText(boarding.getText() +"NAME: "+nameData.getText()+"\n");
boarding.setText(boarding.getText() +"FLIGHT NO: "+dms.getValueAt(selectedRow1,0).toString()+"\n");
boarding.setText(boarding.getText() +"SOURCE: "+sourceData.getText()+"\n");
boarding.setText(boarding.getText() +"DESTINATION: "+destination.getText()+"\n");
boarding.setText(boarding.getText() +"DATE OF JOURNEY: "+date+"\n");
boarding.setText(boarding.getText() +"TIME: "+ dms.getValueAt(selectedRow1,3).toString()+"\n");
boarding.setText(boarding.getText() +"TOTAL AMOUNT: "+"₹"+fare.getText());
}
public void tableData() {
try{
String a= "Select* from doctor";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern","root","root");
Statement statement = connection.createStatement();
ResultSet rs = statement.executeQuery(a);
table1.setModel(buildTableModel(rs));
}catch (Exception ex1){
JOptionPane.showMessageDialog(null,ex1.getMessage());
}
}
public static DefaultTableModel buildTableModel(ResultSet rs)
throws SQLException {
ResultSetMetaData metaData = rs.getMetaData();
// names of columns
Vector<String> columnNames = new Vector<String>();
int columnCount = metaData.getColumnCount();
for (int column = 1; column <= columnCount; column++) {
columnNames.add(metaData.getColumnName(column));
}
// data of the table
Vector<Vector<Object>> data = new Vector<Vector<Object>>();
while (rs.next()) {
Vector<Object> vector = new Vector<Object>();
for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
vector.add(rs.getObject(columnIndex));
}
data.add(vector);
}
return new DefaultTableModel(data, columnNames);
}
}