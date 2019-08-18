package ui;

import model.Book;
import tool.IO;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
/*    //设置图书库的图书存量上限
    private static final int size = 10;
    //新建一个Book数组
    Book[] booklist = new Book[size];*/
    public ArrayList booklist = new ArrayList();
    //新建一个整数计数
    public int count = 0;

    public MainClass(){
        Scanner scanner = new Scanner(System.in);
        IO io = new IO();
        io.load(this);

        printMenu();
        while(true){
            //读取用户输入
            int choice = scanner.nextInt();
            if(choice == 5)
            {
                io.save(this);
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
        if(count > booklist.size()-1)
        {
            System.out.println("当前共有" + count + "本书");
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入书名");
            String bookname = scan.next();
            System.out.println("请输入作者");
            String author = scan.next();
            System.out.println("请输入价格");
            float price = scan.nextFloat();
            Book book = new Book(bookname, author, price);
            /*booklist[count] = book;*/
            booklist.add(book);
            count++;
            /*if(count <= size){*/
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
        switch (choice_del) {
            case 1:
                System.out.println("请输入书本序号：");
                int num_book = scan.nextInt();
                num_book = orfind(num_book);
                if (num_book != -1) {
                    /*for(int i = num_book;i < count;i++){
                        booklist[i] = booklist[i+1];*/
                    booklist.remove(num_book);
                    count--;
                    System.out.println("删除成功");
                    printAllBook();
                } else {
                    System.out.println("输入非法");
                }
                /*  }*/
                break;
            case 2:
                System.out.println("输入书本名称：");
                String name_book = scan.next();
                int id = namefind(name_book);
               /* for(int i = id;i < count;i++) {
                    booklist[i] = booklist[i + 1];*/
                if (id != -1) {
                    booklist.remove(id);
                    count--;
                    System.out.println("删除成功");
                    printAllBook();
                    /*                }*/
                } else {
                    System.out.println("输入非法");
                }
                break;
            case 3:
                break;
            default:
                System.out.println("输入非法");
                System.out.println("请选择删除方式：1-序号 2-书名 3-返回主菜单");
        }
        printMenu();
    }
    void changeBook(){
        System.out.println("请输入你要以何种方式对图书修改：1-序号  2-书名 3-返回主菜单");
        Scanner scanner = new Scanner(System.in);
        int choice_change = scanner.nextInt();
        switch(choice_change){
            case 1:
                System.out.println("请输入图书的书号：");
                int id_book = scanner.nextInt();
                id_book = orfind(id_book);
                if(id_book != -1){
/*
                    System.out.println("原书名为：" + booklist[id_book].getBookname()+"请输入图书新名称：");
*/
                    Book book = (Book) booklist.get(id_book);
                    System.out.println("原书名："+book.getBookname()+"请输入图书新名称：");
                    String new_bookname = scanner.next();
                    System.out.println("请输入图书新作者：");
                    String new_bookauthor = scanner.next();
                    System.out.println("请输入图书新价格：");
                    float new_bookprice = scanner.nextFloat();
                    /*booklist[id_book].setBook(new_bookname,new_bookauthor,new_bookprice);*/
                    book.setBook(new_bookname,new_bookauthor,new_bookprice);
                    System.out.println("修改成功");
                    printAllBook();
                }
                else{
                    System.out.println("输入错误");
                }
                break;
            case 2:
                System.out.println("请输入图书的书名：");
                String name_book = scanner.next();
                int id = namefind(name_book);
                if(id != -1){
                    /*System.out.println("原书名为：" + booklist[id].getBookname()+"请输入图书新名称：");*/
                    Book book = (Book) booklist.get(id);
                    System.out.println("原书名为：" + book.getBookname()+"请输入图书新名称：");
                    String new_bookname = scanner.next();
                    System.out.println("请输入图书新作者：");
                    String new_bookauthor = scanner.next();
                    System.out.println("请输入图书新价格：");
                    float new_bookprice = scanner.nextFloat();
                    /*booklist[id].setBook(new_bookname,new_bookauthor,new_bookprice);*/
                    book.setBook(new_bookname,new_bookauthor,new_bookprice);
                    System.out.println("修改成功");
                    printAllBook();
                }
                else{
                    System.out.println("输入错误");
                }
                break;
            case 3:
                break;
                default:
                    System.out.println("输入非法");
                    System.out.println("请输入你要以何种方式对图书修改：1-序号  2-书名 3-返回主菜单");
        }
        printMenu();
    }
    void findBook(){
        System.out.println("请输入想要以何种方式查找图书：1-序号 2-书名 3-返回主菜单");
        Scanner scanner = new Scanner(System.in);
        int find_choice = scanner.nextInt();
        switch (find_choice){
            case 1:
                System.out.println("请输入序号：");
                int id = scanner.nextInt();
                id = orfind(id);
                if (id != -1){
                    Book book = (Book) booklist.get(id);
                    System.out.println("查找完成");
                    /*System.out.println("当前书籍的名称为：" + booklist[id].getBookname() + "当前书籍的作者为：" + booklist[id].getAuthor() + "当前书籍的价格为：" + booklist[id].getPrice());*/
                    System.out.println("当前书籍的名称为：" + book.getBookname() + "当前书籍的作者为：" + book.getAuthor() + "当前书籍的价格为：" + book.getPrice());
                }
                else {
                    System.out.println("输入错误");
                }
                break;
            case 2:
                System.out.println("请输入书名：");
                String  find_bookname = scanner.next();
                int idname = namefind(find_bookname);
                if(idname != -1){
                    Book book = (Book) booklist.get(idname);
                    System.out.println("查找完成");
                    /*System.out.println("当前书籍的名称为：" + booklist[idname].getBookname() + "当前书籍的作者为：" + booklist[idname].getAuthor() + "当前书籍的价格为：" + booklist[idname].getPrice());*/
                    System.out.println("当前书籍的名称为：" + book.getBookname() + "当前书籍的作者为：" + book.getAuthor() + "当前书籍的价格为：" + book.getPrice());
                }
                else {
                    System.out.println("输入错误");
                }
                break;
            case 3:
                break;
                default:
                    System.out.println("输入非法");
                    System.out.println("请输入想要以何种方式查找图书：1-序号 2-书名 3-返回主菜单");
        }
        printMenu();
    }
    void printAllBook(){
        System.out.println("当前图书有:");
        for(int i = 0;i < count;i++){
            Book book = (Book) booklist.get(i);
            System.out.println("第"+(i+1)+"本书：书名"+book.getBookname()+"作者："+book.getAuthor()+"价格："+book.getPrice()+"元");
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
            Book book = (Book) booklist.get(i);
            if(book.getBookname().equals(name)){
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
