package bai2.ra.businessImp;

import bai2.ra.business.IEmployee;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String Id;
    private String Name;
    private int Year;
    private float Rate;
    private float Commission;

    private float Salary;
    private Boolean Status;

    public Employee(String id, String name, int year, float rate, float commission, float salary, Boolean status) {
        Id = id;
        Name = name;
        Year = year;
        Rate = rate;
        Commission = commission;
        Salary = salary;
        Status = status;
    }

    public Employee() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public float getCommission() {
        return Commission;
    }

    public void setCommission(float commission) {
        Commission = commission;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    @Override
    public void inputData(Scanner scanner,boolean issAdd) {
        if (issAdd){
            this.Id=scanner.nextLine();
        }
        System.out.println("nhập tên");
        this.Name=scanner.nextLine();
        System.out.println("nhập năm sinh");

        this.Year=Integer.parseInt(scanner.nextLine());
        System.out.println("nhập hệ số lương");

        this.Rate=Float.parseFloat(scanner.nextLine());
        System.out.println("nhập hoa hồng hàng tháng");

        this.Commission=Float.parseFloat(scanner.nextLine());
        System.out.println("nhập trạng thái nhân viên");

        this.Status=Boolean.parseBoolean(scanner.nextLine());
        this.Salary= Rate * BASIC_SALARY + Commission;
    }

    @Override
    public void displayData() {
        System.out.printf("%-10s",this);
    }

    @Override
    public String toString() {
        return "nhân ciên{" +
                "Id='" + Id + '\'' +
                ", Tên='" + Name + '\'' +
                ", năm=" + Year +
                ", hệ sóo lương=" + Rate +
                ", hoa hồng=" + Commission +
                ", lươnge tháng=" + Salary +
                ", Status=" + (Status?"nghỉ":"làm") +
                '}';
    }
}
