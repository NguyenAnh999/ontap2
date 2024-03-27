package bai2.ra.presentation;

import bai1.ra.entity.Product;
import bai2.ra.businessImp.Employee;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class EmployeeManagement {
    public static Employee[] arrEmployee = new Employee[100];
    public static int length = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("" +
                    "********************MENU********************* \n" +
                    "1. Nhập thông tin cho n nhân viên \n" +
                    "2. Hiển thị thông tin nhân viên \n" +
                    "3. Tính lương cho các nhân viên \n" +
                    "4. Tìm kiếm nhân viên theo tên nhân viên \n" +
                    "5. Cập nhật thông tin nhân viên \n" +
                    "6. Xóa nhân viên theo mã nhân viên \n" +
                    "7. Sắp xếp nhân viên theo lương tăng dần (Comparable) \n" +
                    "8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator) \n" +
                    "9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator) \n" +
                    "10. Thoát");
            System.out.println("mời bạn chọn");
            int choice = Product.getInt(sc);
            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    calSalary();
                    break;
                case 4:
                    searchByName(sc);
                    break;
                case 5:
                    updateEmployee(sc);
                    break;
                case 6:
                    deleteEmployee(sc);
                    break;
                case 7:
                    sortBySalary();
                    break;
                case 8:
                    sortByName();
                    break;
                case 9:
                    sortByYear();
                    break;
                case 10:
                    System.exit(0);
                    break;
            }

        } while (true);
    }

    static void addEmployee(Scanner sc) {
        System.out.println("Mời bạn nhập vào số phần tử muốn thêm");
        int quantity = Product.getInt(sc);
        for (int i = 0; i < quantity; i++) {
            Employee employee = new Employee();
            employee.inputData(sc, true);
            arrEmployee[length] = employee;
            length++;
        }
    }

    static void displayData() {
        for (Employee employee : arrEmployee) {
            employee.displayData();
        }
    }

    static void calSalary() {
        for (Employee employee : arrEmployee) {
            System.out.printf("Tên nhân viên : %-10s | tiền lương : %f", employee.getName(), employee.getSalary());
        }
    }

    static void searchByName(Scanner sc) {
        System.out.println("mời bạn nhập vào tên nhân viên");
        String name = sc.nextLine();
        for (int i = 0; i < length; i++) {
            if (name.contains(arrEmployee[i].getName())) {
                System.out.println(arrEmployee[i].toString());
            }
        }

    }

    static void updateEmployee(Scanner sc) {
        displayData();
        System.out.println("mời bạn nhập vào ID nhan viên");
        String ID = sc.nextLine();
        for (int i = 0; i < length; i++) {
            if (ID.equals(arrEmployee[i].getId())) {
                System.out.println("mời bạn nhập vào thông tin mới");
                arrEmployee[i].inputData(sc, false);
                System.out.println("cập nhật thành công");
                return;
            }
        }
        System.err.println("id sai");
    }

    static void deleteEmployee(Scanner sc) {
        displayData();
        System.out.println("mời bạn nhập vào ID nhan viên muốn xóa");
        String ID = sc.nextLine();
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (ID.equals(arrEmployee[i].getId())) {
                index = i;
            }
        }
        if (index >= 0) {
            for (int i = index; i < length - 2; i++) {
                arrEmployee[i] = arrEmployee[i + 1];
            }
            arrEmployee[length - 1] = null;
            length--;
        }
    }

    static void sortBySalary() {
        Arrays.sort(arrEmployee, 0, length, (o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
    }

    static void sortByName() {
        Arrays.sort(arrEmployee, 0, length, (o2, o1) -> (o1.getName().compareTo(o2.getName())));

    }

    static void sortByYear() {
        Arrays.sort(arrEmployee, 0, length, (o1, o2) -> (o1.getYear() - o2.getYear()));

    }

}
