package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorUI extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ErrorUI frame = new ErrorUI();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public ErrorUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u64CD\u4F5C\u5931\u8D25\uFF01");
        label.setBounds(151,67,110,21);
        contentPane.add(label);

        JButton button = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MenuUI menu = new MenuUI();
                menu.setVisible(true);
                ErrorUI.this.dispose();
            }
        });
        button.setBounds(246,168,123,29);
        contentPane.add(button);
    }
}
