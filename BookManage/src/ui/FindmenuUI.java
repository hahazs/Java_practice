package ui;

import javax.naming.event.EventContext;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

public class FindmenuUI extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FindmenuUI frame = new FindmenuUI();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    public FindmenuUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u8BF7\u9009\u62E9\u60A8\u8981\u5982\u4F55\u67E5\u627E\u56FE\u4E66\uFF1A");
        label.setBounds(94,33,216,21);
        contentPane.add(label);

        JButton idButton = new JButton("编号");
        idButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                IDfindUI menu = new IDfindUI();
                menu.setVisible(true);
                FindmenuUI.this.dispose();
            }
        });
        idButton.setBounds(134,60,107,29);
        contentPane.add(idButton);

        JButton button = new JButton("书名");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                NameFindUI menu = new NameFindUI();
                menu.setVisible(true);
                FindmenuUI.this.dispose();
            }
        });
        button.setBounds(134,92,107,29);
        contentPane.add(button);

        JButton button1 = new JButton("作者");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AuthorFindUI menu = new AuthorFindUI();
                menu.setVisible(true);
                FindmenuUI.this.dispose();
            }
        });
        button1.setBounds(134,126,107,29);
        contentPane.add(button1);

        JButton button3 = new JButton("价格");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                PriceFindUI menu = new PriceFindUI();
                menu.setVisible(true);
                FindmenuUI.this.dispose();
            }
        });
        button3.setBounds(134,159,107,29);
        contentPane.add(button3);

        JButton button2 = new JButton("\u8FD4\u56DE");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MenuUI menu = new MenuUI();
                menu.setVisible(true);
                FindmenuUI.this.dispose();
            }
        });
        button2.setBounds(134,189,107,29);
        contentPane.add(button2);
    }
}
