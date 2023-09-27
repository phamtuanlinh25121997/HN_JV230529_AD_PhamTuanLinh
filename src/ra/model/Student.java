package ra.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    private Date birthDay;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
    }

    public Student(int studentId, String studentName, Date birthDay, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void inputData() {
        System.out.println("Nhập tên học sinh");
        Scanner scanner = new Scanner(System.in);
        this.studentName = scanner.nextLine();

        // Nhập ngày tháng năm sinh
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                String dateStr = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                this.birthDay = dateFormat.parse(dateStr);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            }
        }


        System.out.println("Nhập địa chỉ");
        this.address = scanner.nextLine();

        System.out.println("Nhập giới tính");
        this.gender = Boolean.parseBoolean(scanner.nextLine());

        // Nhập số điện thoại
        boolean validPhone = false;
        while (!validPhone) {
            System.out.print("Nhập số điện thoại (10 hoặc 11 số, bắt đầu bằng số 0): ");
            this.phone = scanner.next();
            if (this.phone.matches("0\\d{9,10}")) {
                validPhone = true;
            } else {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    public void displayData() {
        System.out.println("Tên học sinh: " + this.getStudentName());
        System.out.println("Ngày sinh: " + this.getBirthDay());
        System.out.println("Địa chỉ: " + this.getAddress());
        System.out.println("Giới tính: " + (this.isGender() ? "Nam" : "Nữ"));
        System.out.println("Số điện thoại: " + this.getPhone());
    }
}
