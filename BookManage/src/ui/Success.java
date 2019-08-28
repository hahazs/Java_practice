package ui;

import control.Operator;
import model.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.ArrayList;

public class Success extends JFrame {
    private JPanel contentPane;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Success frame = new Success("haha");
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public Success(String choice) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel(choice+"成功");
        label.setBounds(152,69,130,21);
        contentPane.add(label);

        JButton button = new JButton("\u8FD4\u56DE\u83DC\u5355");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUI menu = new MenuUI();
                menu.setVisible(true);
                Success.this.dispose();
            }
        });
        button.setBounds(31,142,130,29);
        contentPane.add(button);

        JButton button1 = new JButton("\u67E5\u770B\u6240\u6709\u56FE\u4E66");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operator operator = new Operator();
                ArrayList<Book> booklist = operator.printAllBook();
                PrintUI menu = new PrintUI(booklist);
                menu.setVisible(true);
                Success.this.dispose();
            }
        });
        button1.setBounds(219,142,141,29);
        contentPane.add(button1);
    }
}
