package ui;

import com.sun.javafx.logging.JFRInputEvent;
import control.Operator;
import model.Book;

import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IDfindUI extends JFrame {
    private JPanel contentPane;
    private JTextField idText;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    IDfindUI frame = new IDfindUI();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public IDfindUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u7F16\u53F7:");
        label.setBounds(15,71,210,21);
        contentPane.add(label);

        idText = new JTextField();
        idText.setBounds(224,68,96,27);
        contentPane.add(idText);
        idText.setColumns(10);

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
                    id = Integer.parseInt(idText.getText());
                    ArrayList<Book> booklist = operator.findBook(id,name,author,dimname,minprice,maxprice);
                    PrintUI menu = new PrintUI(booklist);
                    menu.setVisible(true);
                    IDfindUI.this.dispose();
                } catch (Exception e){
                    ErrorUI errorUI = new ErrorUI();
                    errorUI.setVisible(true);
                    IDfindUI.this.dispose();
                }
            }
        });
        button.setBounds(267,167,123,29);
        contentPane.add(button);

        JButton button1 = new JButton("返回");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                FindmenuUI menu = new FindmenuUI();
                menu.setVisible(true);
                IDfindUI.this.dispose();
            }
        });
        button1.setBounds(27,167,123,29);
        contentPane.add(button1);
    }
}
