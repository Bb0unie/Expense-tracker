/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package home;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Home extends JFrame{
    
    public static void main(String[]args){
        
        JFrame frame = new JFrame();//create a Jframe
        frame.setTitle("Budget Tracker");
        frame.setSize(300,200);//set the size of the frame
        frame.setResizable(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//set the default close option for JFrame
        frame.setVisible(true);//make the frame visible
        
        
        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Print");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
 
        // Create a panel with a button
        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me");
        panel.add(button);
 
        // Add action to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
            }
        });
 
        // Create another panel with text
        JPanel textPanel = new JPanel();
        JLabel label = new JLabel("Geeks Premier League 2023");
        textPanel.add(label);
        
        
        // Set layout for the main frame
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(menuBar);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(textPanel, BorderLayout.SOUTH);
 
        frame.setVisible(true);
    }
}
