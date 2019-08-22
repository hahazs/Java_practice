package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame {
    private JPanel contentPane;
    public static int choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MenuUI frame = new MenuUI();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public MenuUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("Welcome...");
        label.setBounds(145,0,81,21);
        contentPane.add(label);

        JButton addButton = new JButton("增加图书");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUI addUI = new AddUI();
            }
        });
        addButton.setBounds(110,25,123,29);
        contentPane.add(addButton);

    }
}
