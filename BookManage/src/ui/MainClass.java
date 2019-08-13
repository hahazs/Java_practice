package ui;

import model.Book;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainClass {
    //设置图书库的图书存量上限
    private static final int size = 10;
    //新建一个Book数组
    Book[] booklist = new Book[size];
    //新建一个整数计数
    int count = 0;

    public MainClass(){
        Scanner scanner = new Scanner(System.in);
        printMenu();
        while(true){
            //读取用户输入
            int choice = scanner.nextInt();
            if(choice == 5)
            {
                System.out.println("Exit Successfully");
            }
            else {
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        deleteBook();
                        break;
                    case 3:
                        changeBook();
                        break;
                    case 4:
                        findBook();
                        break;
                    default:
                        System.out.println("Warning");
                        printMenu();
                        continue;
                }
            }
        }
    }
    void printMenu(){
        System.out.println("Welcome");
        System.out.println("addBook......1");
        System.out.println("deleteBook...2");
        System.out.println("changeBook...3");
        System.out.println("findBook.....4");
        System.out.println("Exit.........5");
    }
    void addBook(){
        /*System.out.println("add");*/
        System.out.println("当前共有"+count+"本书");
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入书名");
        String bookname = scan.next();
        System.out.println("请输入作者");
        String author = scan.next();
        System.out.println("请输入价格");
        float price = scan.nextFloat();
        Book book = new Book(bookname,author,price);
        booklist[count] = book;
        count++;
        if(count <= size){
            System.out.println("添加成功");
            printAllBook();
        }
        else {
            System.out.println("超过图书管理上限");
        }
    }
    void deleteBook(){
        /*System.out.println("delete");*/
        System.out.println("请选择删除方式：1-序号/r/n2-书名");
    }
    void changeBook(){
        System.out.println("change");
    }
    void findBook(){
        System.out.println("find");
    }
    void printAllBook(){
        System.out.println("当前图书有:");
        for(int i = 0;i < count;i++){
            System.out.println("第"+(i+1)+"本书：书名"+booklist[i].getBookname()+"作者："+booklist[i].getAuthor()+"价格："+booklist[i].getPrice()+"元");
        }
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
