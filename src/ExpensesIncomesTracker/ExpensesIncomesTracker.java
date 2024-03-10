/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExpensesIncomesTracker;

import ExpenseIncomeEntry.ExpenseIncomeEntry;
import ExpenseIncomeTableModel.ExpenseIncomeTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class ExpensesIncomesTracker extends JFrame{
    
    public ExpenseIncomeTableModel tableModel;
    private final JTable table;
    private final JTextField dateField;
    private final JTextField descriptionField;
    private final JTextField amountField;
    private final JComboBox<String> typeComboBox;
    private final JButton addButton;
    private final JLabel balanceLabel ;
    private double balance;
    
    public ExpensesIncomesTracker(){
        
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }
        catch(Exception ext){
            System.err.println("Failed to Set FlatDarkLaf LookAndFeel");
        }
        
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("TextField.CaretForeground", Color.WHITE);
        UIManager.put("ComboBox.foreground", Color.WHITE);
        UIManager.put("ComboBox.background", Color.WHITE);
        UIManager.put("ComboBox.selectionBackground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("Label.background", Color.WHITE);
        UIManager.put("background.color", Color.WHITE);
        UIManager.put("ColorChooser.background", Color.WHITE);
        
        Font customFont = new Font("Times New Roman", Font.PLAIN, 18);
        UIManager.put("Label.font", customFont);
        UIManager.put("TextField.font", customFont);
        UIManager.put("ComboBox.font", customFont);
        UIManager.put("Button.font", customFont);
        
        balance = 0.0;
        tableModel = new ExpenseIncomeTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPanel = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        dateField = new JTextField(10);
        descriptionField = new JTextField(20);
        amountField = new JTextField(10);
        typeComboBox = new JComboBox<>(new String[]{"Expense", "Income"});

        addButton = new JButton("Add");
        addButton.addActionListener(e -> addEntry());
        balanceLabel = new JLabel("Balance: $" + balance);
        // addButton.addActionListener(e-)   
        
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Date"));
        inputPanel.add(dateField);
        
        inputPanel.add(new JLabel("Description"));
        inputPanel.add(descriptionField);
        
        inputPanel.add(new JLabel("Amount"));
        inputPanel.add(amountField);
        
        inputPanel.add(new JLabel("Type"));
        inputPanel.add(typeComboBox);
        
        inputPanel.add(addButton);
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(balanceLabel);

        setLayout(new BorderLayout());
        
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.WEST);
        
        setTitle("Expenses And Incomes Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    
    private void addEntry(){
        String date = dateField.getText();
        String description = descriptionField.getText();
        String amountStr = amountField.getText();
        String type = (String)typeComboBox.getSelectedItem();
        double amount;
        
        if(amountStr.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter the amount", "Error", JOptionPane.ERROR_MESSAGE );
            return;
        }
        
        try
        {
            amount = Double.parseDouble(amountStr);
            
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Invalid amount format", "Error", JOptionPane.ERROR_MESSAGE );
            return;
        }
        
        if(type.equals("Expense")){
            amount *= -1;
        }
        
        ExpenseIncomeEntry entry = new ExpenseIncomeEntry(date, description, amount, type);
        tableModel.addEntry(entry);
        balance += amount;
        balanceLabel.setText("Balance: $" + balance);
        
        clearInputFields();
        
    }
    
    
    private void clearInputFields(){
        dateField.setText("");
        descriptionField.setText("");
        amountField.setText("");
        typeComboBox.setSelectedIndex(0);
        
    }

}
