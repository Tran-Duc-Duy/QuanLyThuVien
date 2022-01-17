package QuanLy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    static List<Book> bookList;
    static Scanner scan; // lam nhu nay se toi uu hon, de cho phan quan ly bo nho

    public static void main(String[] args) {
        bookList=new ArrayList<>();
        scan =new Scanner(System.in);

        int choose = 1;

        //dung show menu thi nen dung do while
        do{
            showMenu();
            choose = Integer.parseInt(scan.nextLine());
            switch (choose){
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    sortByAuthorName();
                    display();
                    break;
                case 4:
                    saveObjectFile();
                    break;
                case 5:
                    saveTextFile();
                    break;
                case 6:
                    readObjectFile();
                    display();
                    break;
                case 7:
                    choose=checkOut(choose);
                    break;
                default:
                    System.out.println("Nhap loi");
                    break;
            }
        }while(choose!=7);
    }

    private static int checkOut(int choose) {
        System.out.println("Thoat that khong?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        int choose1 = Integer.parseInt(scan.nextLine());
        if ((choose1 == 1)) {
            System.out.println("U thi thoat T_T");
            choose = 7;
        } else {
            choose = 9;
        }
        return choose;
    }

    private static void readObjectFile() {
        FileInputStream fis = null;
        ObjectInputStream ois =null;

        try {
            fis = new FileInputStream("data.obj");
            ois = new ObjectInputStream(fis);

            List<Book> dataList = (List<Book>) ois.readObject();
            for (Book book:dataList){
                bookList.add(book);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois !=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void saveTextFile() {
        FileOutputStream fos =null;
        try {
            fos=new FileOutputStream("data.txt");
            for (Book book:bookList){
                String line =book.getFileLine();
                byte[] data = line.getBytes(StandardCharsets.UTF_8);
                fos.write(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void saveObjectFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos =null;

        try {
            fos = new FileOutputStream("data.obj");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(bookList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos !=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void sortByAuthorName() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthorName().compareToIgnoreCase(o2.getAuthorName());
            }
        });
    }

    private static void display() {
        System.out.println("Hien thi thong tin sach:");
        for (Book book:bookList){
            book.display();
        }
    }

    private static void input() {
        System.out.println(" Nhap so cuon sach N");
        int N = Integer.parseInt(scan.nextLine());

        for (int i =0; i<N;i++){
            Book book = new Book();
            book.input();

            bookList.add(book);
        }
    }

    static void showMenu(){
        System.out.println("1. Nhap N quyen sach");
        System.out.println("2. Hien thi thong tin cuon sach");
        System.out.println("3. Sap xep theo ten tac gia a-z");
        System.out.println("4. Luu data.obj");
        System.out.println("5. Luu data.txt");
        System.out.println("6. Doc du lieu data.obj");
        System.out.println("7. Thoat");
    }
}