package bai1.ra.entity;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    public static int getInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("bạn hãy nhập vào 1 số");
            }
        }
    }

    public static float getFloat(Scanner sc) {
        while (true) {
            try {
                return Float.parseFloat(sc.nextLine());
            } catch (Exception e) {
                System.out.println("bạn hãy nhập vào 1 số ");
            }
        }
    }
    public static boolean getBoolean(Scanner sc){
        while (true) {
            try {
                return Boolean.parseBoolean(sc.nextLine());
            } catch (Exception e) {
                System.out.println("bạn hãy nhập vào true(open) hoặc false(blook) ");
            }
        }
    }

    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProduct) {
        this.productId = InputID(scanner, arrProduct);
        this.productName = InputName(scanner, arrProduct);
        this.importPrice = InputImportPrice(scanner);
        this.exportPrice = InputExportPrice(scanner);
        this.profit = autoGetProfit();
        this.quantity=InputQuantity(scanner);
        this.descriptions=InputDescriptions(scanner);
        this.status=InputStatus(scanner);

    }
    public boolean InputStatus(Scanner sc){
        System.out.println("mời bạn nhập vào trang thái sản phẩm");
        return getBoolean(sc);
    }
    public String InputDescriptions(Scanner sc){
        System.out.println("mời bạn nhập mô tả");
        return sc.nextLine();
    }
public int InputQuantity(Scanner sc){
    System.out.println("mời bạn nhập vào số lượng");
    do {
        int InputQuantity = getInt(sc);
        if (InputQuantity > 0) {
            return InputQuantity;
        }
        System.out.println("giá nhập hàng phải lớn hơn 0");
    } while (true);
}
    public float autoGetProfit() {
        return exportPrice - importPrice;
    }

    public float InputExportPrice(Scanner sc) {
        System.out.println("mời bạn nhập vào giá xuất");
        do {
            float exportPrice = getFloat(sc);
            if (exportPrice > importPrice + (importPrice / 5)) {
                return exportPrice;
            }
            System.out.println("giá xuát hàng phải lớn giá nhập 20%");
        } while (true);

    }

    public float InputImportPrice(Scanner sc) {
        System.out.println("mời bạn nhập vào giá nhập");
        do {
            float importPrice = getFloat(sc);
            if (importPrice > 0) {
                return importPrice;
            }
            System.out.println("giá nhập hàng phải lớn hơn 0");
        } while (true);

    }

    public String InputName(Scanner scanner, Product[] arrProduct) {
        System.out.println("mời bạn nhập vào tên");

        do {
            String name = scanner.nextLine();
            if (!name.isBlank()) {
                for (Product product : arrProduct) {
                    if (product.productId.equals(name)) {
                        return name;
                    }
                }
                System.out.println("tên của bạn đã dc sử dụng mời nhập lại");
            } else {
                System.out.println("bạn không đươc để trống tên");
            }


        } while (true);
    }

    public String InputID(Scanner scanner, Product[] arrProduct) {
        System.out.println("mời bạn nhập vào Id");
        String regex = "^P\\w{3}$";
        do {
            String ID = scanner.nextLine();
            if (ID.matches(regex)) {
                for (Product product : arrProduct) {
                    if (product.productId.equals(ID)) {
                        return ID;
                    }
                }
                System.out.println("id của bạn đã dc sử dụng mời nhập lại");
            } else {
                System.out.println("bạn nhập chưa đúng định dạng (P___)");
            }


        } while (true);
    }


    @Override
    public String toString() {
        return "sản phẩm{" +
                "Mã='" + productId + '\'' +
                ", Tên='" + productName + '\'' +
                ", Giá nhập=" + importPrice +
                ", Giá bán=" + exportPrice +
                ", số lượng=" + quantity +
                ", Mô tả='" + descriptions + '\'' +
                ", trạng thái=" + (
                status?"đang bán":"không bán"
                ) +
                '}';
    }
}
