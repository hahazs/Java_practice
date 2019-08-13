package ui;

import com.sun.xml.internal.ws.api.server.LazyMOMProvider;
import model.Book;

import java.net.ServerSocket;
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
                System.exit(0);
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
        printMenu();
    }
    void deleteBook(){
        /*System.out.println("delete");*/
        System.out.println("请选择删除方式：1-序号   2-书名  3-返回主菜单");
        Scanner scan = new Scanner(System.in);
        int choice_del = scan.nextInt();
        switch (choice_del){
            case 1:
                System.out.println("请输入书本序号：");
                int num_book = scan.nextInt();
                num_book = orfind(num_book);
                if(num_book != -1){
                    for(int i = num_book;i < count;i++){
                        booklist[i] = booklist[i+1];
                        count--;
                        System.out.println("删除成功");
                        printAllBook();
                    }
                }
                else {
                    System.out.println("输入非法");
                }
                break;
            case 2:
                System.out.println("输入书本名称：");
                String name_book = scan.next();
                int id = namefind(name_book);
                for(int i = id;i < count;i++) {
                    booklist[i] = booklist[i + 1];
                    count--;
                    System.out.println("删除成功");
                    printAllBook();
                }
                break;
            case 3:
                break;
            default:
                System.out.println("输入非法");
                System.out.println("请选择删除方式：1-序号/r/n2-书名");
        }
        printMenu();
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
    int orfind(int number){
        if(number <= count && number > 0){
            int num_book = number - 1;
            return num_book;
        }
        else {
            return -1;
        }
    }
    int namefind(String name){
        int id = -1;
        for(int i = 0;i < count;i++){
            if(booklist[i].getBookname().equals(name)){
                id = i;
                break;
            }
            else if(i < count){
                continue;
            }
            else{
                System.out.println("未找到想要的书名");
                break;
            }
        }
        return id;
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
