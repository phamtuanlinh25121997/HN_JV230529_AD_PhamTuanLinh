package ra.model;

import java.util.Scanner;

public class Mark {
    private int markId;
    private Student student;
    private Subject subject;
    private double point;

    public Mark() {
    }

    public Mark(int markId, Student student, Subject subject, double point) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
    public void inputData(Scanner scanner,Subject subject,Student student){
        // Hiển thị danh sách học sinh và môn học
        System.out.println("Danh sách học sinh:");
        student.displayData();
        System.out.println("Danh sách môn học:");
        subject.displayData();

        // Nhập id của học sinh
        System.out.print("Nhập ID học sinh: ");
        int studentId = scanner.nextInt();

        // Nhập id của môn học
        System.out.print("Nhập ID môn học: ");
        int subjectId = scanner.nextInt();

        // Nhập điểm số
        System.out.print("Nhập điểm số (từ 0 đến 10): ");
        this.point = scanner.nextDouble();

        // Kiểm tra điểm hợp lệ
        while (this.point < 0 || this.point > 10) {
            System.out.print("Điểm số không hợp lệ. Vui lòng nhập lại: ");
            this.point = scanner.nextDouble();
        }
    }
    public void displayData() {
        System.out.println("Mark ID: " + this.getMarkId());
        System.out.println("Student Name: " + this.student.getStudentName());
        System.out.println("Subject Name: " + this.subject.getSubjectName());
        System.out.println("Point: " + this.getPoint());
    }
}
