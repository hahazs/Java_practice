package ui;

import control.Operator;
import model.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NameFindUI extends JFrame {
    private JPanel contentPane;
    private JTextField nameText;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    NameFindUI frame = new NameFindUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NameFindUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u4E66\u540D\uFF1A");
        label.setBounds(78, 53, 227, 21);
        contentPane.add(label);
        nameText = new JTextField();
        nameText.setBounds(88, 90, 170, 27);
        contentPane.add(nameText);
        nameText.setColumns(10);
        JButton button = new JButton("\u6A21\u7CCA\u67E5\u627E");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = null;
                int id = -1;
                String author = null;
                String dimname = null;
                float minprice = 0;
                float maxprice = -1;
                Operator operator = new Operator();
                dimname = nameText.getText();
                if (dimname.equals("")) {
                    ErrorUI error = new ErrorUI();
                    error.setVisible(true);
                    NameFindUI.this.dispose();
                } else {
                    ArrayList<Book> booklist = operator.findBook(id, name, author, dimname, minprice, maxprice);
                    PrintUI menu = new PrintUI(booklist);
                    menu.setVisible(true);
                    NameFindUI.this.dispose();
                }
            }
        });
        button.setBounds(241, 176, 123, 29);
        contentPane.add(button);
        JButton button_1 = new JButton("\u7CBE\u786E\u67E5\u627E");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String name = null;
                int id = -1;
                String author = null;
                String dimname = null;
                float minprice = 0;
                float maxprice = -1;
                Operator operator = new Operator();
                name = nameText.getText();
                if (name.equals("")) {
                    ErrorUI error = new ErrorUI();
                    error.setVisible(true);
                    NameFindUI.this.dispose();
                } else {
                    ArrayList<Book> booklist = operator.findBook(id, name, author, dimname, minprice, maxprice);
                    PrintUI menu = new PrintUI(booklist);
                    menu.setVisible(true);
                    NameFindUI.this.dispose();
                }
            }
        });
        button_1.setBounds(241, 132, 123, 29);
        contentPane.add(button_1);
        JButton button_2 = new JButton("\u8FD4\u56DE");
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                FindmenuUI menu = new FindmenuUI();
                menu.setVisible(true);
                NameFindUI.this.dispose();
            }
        });
        button_2.setBounds(26, 176, 123, 29);
        contentPane.add(button_2);
    }
}
