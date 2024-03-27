package bai1.ra.ipm;

import bai1.ra.entity.Product;


import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

import static java.util.Collection.*;

public class ProductImp {
    public static int length = 0;
    public static Product[] arrProduct = new Product[100];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("" +
                    "***********************MENU************************** \n" +
                    "1. Nhập thông tin n sản phẩm (n nhập từ bàn phím) \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Tính lợi nhuận các sản phẩm \n" +
                    "4. Sắp xếp các  sản phẩm theo lợi nhuận giảm dần \n" +
                    "5. Thống kê các sản phẩm theo giá \n" +
                    "6. Tìm các sản phẩm theo tên sản phẩm \n" +
                    "7.  Nhập sản phẩm \n" +
                    "8. Bán sản phẩm \n" +
                    "9. Cập nhật trạng thái sản phẩm \n" +
                    "10.  Thoát");
            System.out.println("mời bạn chọn");
            int choice = Product.getInt(sc);
            switch (choice) {
                case 1:
                    addPr0duct(sc);
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    calProfit(sc);
                    break;
                case 4:
                    sortByteProfit(sc);
                    break;
                case 5:
                    sortBytePrice(sc);
                    break;
                case 6:
                    searchByName(sc);
                    break;
                case 7:
                    byeProduct(sc);
                    break;
                case 8:
                    saleProduct(sc);
                    break;
                case 9:
                    updateStatus(sc);
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
    static void updateStatus(Scanner sc){
       do {
           System.out.println("mời bạn nhập vào id sản phẩm muốn sửa trạng thái");
          int index= getIndexById(sc);
          if (index>=0){
              arrProduct[index].setStatus(Product.getBoolean(sc));
          }else {
              System.out.println("ID bạn nhập vào không tông tại");
          }

       }while (true);

    }
    static void saleProduct(Scanner sc) {
        displayData();
        System.out.println("mời bạn nhập vào id sản phẩm muốn bán");
        String Id = sc.nextLine();
        for (int i = 0; i < length; i++) {
            if (Id.contains(arrProduct[i].getProductId())) {
                System.out.println(arrProduct[i].toString());
                System.out.println("mời bạn nhập vào số lượng muốn bán");
                int quantity=Product.getInt(sc);
                if (quantity>arrProduct[i].getQuantity()){
                    System.err.println("bạn không thể bán quá số lượng đang có");
                }else {
                    arrProduct[i].setQuantity(arrProduct[i].getQuantity()-quantity);
                    System.out.println("bán thành công");
                }
            }
        }
    }
    static void byeProduct(Scanner sc) {
        displayData();

        System.out.println("mời bạn nhập vào id sản phẩm muốn mua");
        String Id = sc.nextLine();
        for (int i = 0; i < length; i++) {
            if (Id.contains(arrProduct[i].getProductId())) {
                System.out.println(arrProduct[i].toString());
                System.out.println("mời bạn nhập vào số lượng muốn mua");
                int quantity=Product.getInt(sc);

                    arrProduct[i].setQuantity(arrProduct[i].getQuantity()+quantity);
                    System.out.println("mua thành công");
            }
        }
    }
    static void searchByName(Scanner sc){
        System.out.println("mời bạn nhập vào tên sản phẩm");
        String name = sc.nextLine();
        for (int i = 0; i < length; i++) {
            if (name.contains(arrProduct[i].getProductName())){
                System.out.println(arrProduct[i].toString());
            }
        }

    }
    static void sortByteProfit(Scanner sc){
        Product temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arrProduct[i].getProfit()>arrProduct[j].getProfit()){
                    temp=arrProduct[i];
                    arrProduct[i]=arrProduct[j];
                    arrProduct[j]=temp;
                }
            }
        }
        System.out.println("mời bạn nhập vào khoảng giá");
        System.out.println("mời bạn nhập vào khoảng bắt đầu");
        int from = Product.getInt(sc);
        System.out.println("mời bạn nhập vào khoảng kết thúc");
        int to = Product.getInt(sc);
        for (Product product : arrProduct) {
           if (product.getProfit()>=from&&product.getProfit()<=to){
               System.out.printf("sản phẩm: %s | lợi nhuận: %f\n",product.getProductName(),product.getProfit());
           }
        }
    }
    static void sortBytePrice(Scanner sc){
        System.out.println("mời bạn nhập vào khoảng giá");
        System.out.println("mời bạn nhập vào khoảng bắt đầu");
        int from = Product.getInt(sc);
        System.out.println("mời bạn nhập vào khoảng kết thúc");
        int to = Product.getInt(sc);
        for (Product product : arrProduct) {
            if (product.getExportPrice()>=from&&product.getExportPrice()<=to){
                System.out.printf("sản phẩm: %s | giá bán ra: %f\n",product.getProductName(),product.getExportPrice());
            }
        }
    }
    static void calProfit(Scanner sc){
        displayData();
        do {
            int index = getIndexById(sc);
            if (index>=0){
                System.out.printf("sản phẩm %-10s | có lợi nhuận là %-5f",arrProduct[index].getProductName(),arrProduct[index].getProfit());
            }else {
                System.err.println("id bạn nhập không tồn tại mời nhập lại");
            }
        }while (true);
    }

    static void addPr0duct(Scanner sc) {
        System.out.println("Mời bạn nhập vào số phần tử muốn thêm");
        int quantity = Product.getInt(sc);
        for (int i = 0; i < quantity; i++) {
            Product product = new Product();
            product.inputData(sc, arrProduct);
            arrProduct[length] = product;
            length++;
        }
    }

    static void displayData() {
        for (int i = 0; i < length; i++) {
            System.out.printf("%-10s", arrProduct[i].toString());
        }
    }

    static int getIndexById(Scanner sc) {
        System.out.println("mời bạn nhập vào id cần tìm");
        String ID = sc.nextLine();
        for (int i = 0; i < length; i++) {
            if (ID.equals(arrProduct[i].getProductId())) {
                return i;
            }
        }
        return -1;
    }
}
