package ui;

import control.Operator;
import model.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AuthorFindUI extends JFrame {
    private JPanel contentPane;
    private JTextField authorText;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AuthorFindUI frame = new AuthorFindUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AuthorFindUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u4F5C\u8005\uFF1A");
        label.setBounds(15, 48, 212, 21);
        contentPane.add(label);
        authorText = new JTextField();
        authorText.setBounds(226, 45, 124, 27);
        contentPane.add(authorText);
        authorText.setColumns(10);
        JButton button = new JButton("\u63D0\u4EA4");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = null;
                int id = -1;
                String author = null;
                String dimname = null;
                float minprice = 0;
                float maxprice = -1;
                Operator operator = new Operator();
                author = authorText.getText();
                if (author.equals("")) {
                    ErrorUI error = new ErrorUI();
                    error.setVisible(true);
                    AuthorFindUI.this.dispose();
                } else {
                    ArrayList<Book> booklist = operator.findBook(id, name, author, dimname, minprice, maxprice);
                    PrintUI menu = new PrintUI(booklist);
                    menu.setVisible(true);
                    AuthorFindUI.this.dispose();
                }
            }
        });
        button.setBounds(278, 158, 123, 29);
        contentPane.add(button);
        JButton button_1 = new JButton("\u8FD4\u56DE");
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                FindmenuUI menu = new FindmenuUI();
                menu.setVisible(true);
                AuthorFindUI.this.dispose();
            }
        });
        button_1.setBounds(40, 158, 123, 29);
        contentPane.add(button_1);
    }
}

