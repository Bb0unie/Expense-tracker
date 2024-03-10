/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExpenseIncomeTableModel;

import ExpenseIncomeEntry.ExpenseIncomeEntry;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ExpenseIncomeTableModel extends AbstractTableModel {
    public final List<ExpenseIncomeEntry> entries;//list to store the entries (rows) in the table
    public final String[] columnNames = {"Date", "Description", "Amount", "Type"}; //column name for the table


    //constructor to initialize the table model
    public ExpenseIncomeTableModel(){
        entries = new ArrayList<>();
    }

    /*
    add new entry to the table
    @param_entry the expense or income entry to add
     */
    public void addEntry(ExpenseIncomeEntry entry){
        entries.add(entry);
        //notify the table that a new row has been inserted
        fireTableRowsInserted(entries.size()-1, entries.size()-1);
    }

    public int getRowCount(){
        return entries.size();
    }

    public int getColumnCount(){
        return columnNames.length;
    }
    
    public String getColumnName(int column){
        return columnNames[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex){
        
        ExpenseIncomeEntry entry = entries.get(rowIndex);

        //return the value for the cell base on the column index
        switch(columnIndex){
            case 0: return entry.getDate();
            case 1: return entry.getDescription();
            case 2: return entry.getAmount();
            case 3: return entry.getType();
            default: return null;
        }
    }
}
