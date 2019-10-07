package ui;

import control.Operator;
import model.Book;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PriceFindUI extends JFrame {
    private JPanel contentPane;
    private JTextField minpriceText;
    private JTextField maxpriceText;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PriceFindUI frame = new PriceFindUI();
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
    public PriceFindUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u4EF7\u683C\u533A\u95F4\uFF1A");
        label.setBounds(50, 28, 274, 21);
        contentPane.add(label);
        minpriceText = new JTextField();
        minpriceText.setBounds(36, 64, 96, 27);
        contentPane.add(minpriceText);
        minpriceText.setColumns(10);
        maxpriceText = new JTextField();
        maxpriceText.setColumns(10);
        maxpriceText.setBounds(217, 64, 96, 27);
        contentPane.add(maxpriceText);
        JLabel label_1 = new JLabel("\u81F3");
        label_1.setBounds(160, 67, 81, 21);
        contentPane.add(label_1);
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
                try {
                    minprice = Float.parseFloat(minpriceText.getText());
                    maxprice = Float.parseFloat(maxpriceText.getText());
                    ArrayList<Book> booklist = operator.findBook(id, name, author, dimname, minprice, maxprice);
                    PrintUI menu = new PrintUI(booklist);
                    menu.setVisible(true);
                    PriceFindUI.this.dispose();
                } catch (Exception e) {
                    ErrorUI error = new ErrorUI();
                    error.setVisible(true);
                    PriceFindUI.this.dispose();
                }
            }
        });
        button.setBounds(245, 156, 123, 29);
        contentPane.add(button);
        JButton button_1 = new JButton("\u8FD4\u56DE");
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                FindmenuUI menu = new FindmenuUI();
                menu.setVisible(true);
                PriceFindUI.this.dispose();
            }
        });
        button_1.setBounds(15, 156, 123, 29);
        contentPane.add(button_1);
    }
}

