package ui;

import control.Operator;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUI extends JFrame {
    private JPanel contentPanel;
    private JTextField idText;
    private JTextField nameText;
    private JButton button;

    public static void main(String[] args) {

    }

    public DeleteUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        JLabel label = new JLabel("按编号删除");
        label.setBounds(24, 62, 124, 21);
        contentPanel.add(label);

        idText = new JTextField();
        idText.setBounds(163, 59, 96, 27);
        contentPanel.add(idText);
        idText.setColumns(10);

        JLabel label1 = new JLabel("按书名删除");
        label1.setBounds(24, 104, 124, 21);
        contentPanel.add(label1);

        nameText = new JTextField();
        nameText.setBounds(163, 101, 96, 27);
        contentPanel.add(nameText);
        nameText.setColumns(10);

        JButton submitButton = new JButton("\u63D0\u4EA4");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int id = -1;
                String name = "";
                String choice = "删除";
                try {
                    id = Integer.parseInt(idText.getText());
                    System.out.println(id);
                    Operator operator = new Operator();
                    boolean isSuccuess = operator.deleteBook(id, name);
                    if (isSuccuess) {
                        System.out.println("id删除成功！");
                        Success success = new Success(choice);
                        success.setVisible(true);
                        DeleteUI.this.dispose();
                    } else {
                        System.out.println("id删除失败！请检查您输入的是否正确！");
                        ErrorUI error = new ErrorUI();
                        error.setVisible(true);
                        DeleteUI.this.dispose();
                    }
                } catch (Exception e) {
                    name = nameText.getText();
                    if (name.trim().equals("")) {
                        ErrorUI error = new ErrorUI();
                        error.setVisible(true);
                        DeleteUI.this.dispose();
                    } else {
                        System.out.println(name);
                        Operator operator = new Operator();
                        boolean isSuccess = operator.deleteBook(id, name);
                        if (isSuccess) {
                            System.out.println("name删除成功！");
                            Success success = new Success(choice);
                            success.setVisible(true);
                            DeleteUI.this.dispose();
                        } else {
                            System.out.println("name删除失败！请检查您的输入是否正确！");
                            ErrorUI error = new ErrorUI();
                            error.setVisible(true);
                            DeleteUI.this.dispose();
                        }
                    }
                }
            }
        });
        submitButton.setBounds(257, 143, 123, 29);
        contentPanel.add(submitButton);

        button = new JButton("\u8FD4\u56DE");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MenuUI menu = new MenuUI();
                menu.setVisible(true);
                DeleteUI.this.dispose();
            }
        });
        button.setBounds(28, 143, 123, 29);
        contentPanel.add(button);

        JLabel label2 = new JLabel("\u8BF7\u8F93\u5165\u5176\u4E2D\u4E4B\u4E00");
        label2.setBounds(144, 15, 126, 21);
        contentPanel.add(label2);
    }
}
