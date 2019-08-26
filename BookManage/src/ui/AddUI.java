package ui;

import com.sun.net.httpserver.Authenticator;
import control.Operator;
import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUI extends JFrame {
    private JPanel contentPane;
    private JTextField booknameText;
    private JTextField authorText;
    private JTextField priceText;
    /**
     * launch the application
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AddUI frame = new AddUI();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public AddUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("请输入您想要的增加的图书：");
        label.setBounds(105,15,211,21);
        contentPane.add(label);

        JLabel label_1 = new JLabel("书名：");
        label_1.setBounds(15,50,81,21);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel();
        label_2.setBounds(15,95,81,21);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("价格：");
        label_3.setBounds(15,137,81,21);
        contentPane.add(label_3);

        booknameText = new JTextField();
        booknameText.setBounds(115,51,162,27);
        contentPane.add(booknameText);
        booknameText.setColumns(10);

        authorText = new JTextField();
        authorText.setColumns(10);
        authorText.setBounds(115,92,162,27);
        contentPane.add(authorText);

        priceText = new JTextField();
        priceText.setColumns(10);
        priceText.setBounds(115,134,162,27);
        contentPane.add(priceText);

        JButton button = new JButton("\u63D0\u4EA4");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String choice = "增加";
                    String name = booknameText.getText();
                    String author = authorText.getText();
                    float price = Float.parseFloat(priceText.getText());
                    Operator operator = new Operator();
                    boolean isSuccess = operator.addBook(name,author,price);
                    if(isSuccess){
                        Success success = new Success(choice);

                    }
                }
            }
        });
    }
}
