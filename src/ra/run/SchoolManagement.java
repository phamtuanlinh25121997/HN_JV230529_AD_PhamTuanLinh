package ra.run;

import ra.model.Student;
import ra.model.Subject;
import ra.service.MarkService;
import ra.service.StudentService;
import ra.service.SubjectService;

import java.util.Scanner;

public class SchoolManagement {
    private final static StudentService studentService = new StudentService();
    private final static SubjectService subjectService = new SubjectService();
    private final static MarkService markService = new MarkService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("Quản lý học sinh");
            System.out.println("Quản lý môn học");
            System.out.println("Quản lí điểm thi");
            System.out.println("Thoát");
            System.out.print("Chọn 1, 2, 3 hoặc 4 để thực hiện: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng trống

            switch (choice) {
                case 1:
                    studentManagement();
                    break;
                case 2:
                    subjectManagement();
                    break;
                case 3:
                    markManagement();
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void studentManagement() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************STUDENT-MANAGEMENT************************");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3. Thay đổi thông tin học sinh theo mã id");
            System.out.println("4. Xóa học sinh theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Chọn 1, 2, 3, 4 hoặc 5 để thực hiện: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng trống

            switch (choice) {
                case 1:
                    createNewStudent();
                    break;
                case 2:
                    showListStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void createNewStudent() {
        int size = studentService.getSize();
        int maxInput = studentService.getAllStuden().length - size;
        System.out.println("Nhập vào số lượng cần thêm mới");
        int n = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin học sinh thứ " + (i + 1));

            Student newStudent = new Student();
            // id tự tăng
            int newId = studentService.getNewId();
            newStudent.setStudentId(newId);
            System.out.println("New ID : " + newId);
            // nhập nhưngx thông tin còn lại
            newStudent.inputData();
            // tiến hành them mới vào mảng
            studentService.save(newStudent);
        }
    }

    private static void showListStudent() {
        if (studentService.getSize() == 0){
            System.out.println("Không có học sinh nào");
            return;
        }
        for (Student student: studentService.getAllStuden()) {
            if (student != null){
                student.displayData();
            }
        }
    }

    private static void editStudent() {
        System.out.println("Nhập vào id cần sửa");
        int idEdit = new Scanner(System.in).nextInt();
        Student student = studentService.findById(idEdit);
        if (student == null){
            System.out.println("Không tìm thấy học sinh");
            return;
        }
        student.inputData();
        studentService.save(student);
    }

    private static void deleteStudent() {
        System.out.println("Nhập vào id cần xóa");
        int idDel = new Scanner(System.in).nextInt();
        studentService.deleteStudent(idDel);
    }

    private static void subjectManagement() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("**********************SUBJECT-MANAGEMENT************************");
            System.out.println("1. Thêm mới môn học");
            System.out.println("2. Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3. Thay đổi thông tin môn học theo mã id");
            System.out.println("4. Xóa môn học theo mã id (kiểm tra xem nếu môn học có điểm thi thì không xóa được)");
            System.out.println("5. Thoát");
            System.out.print("Chọn 1, 2, 3, 4 hoặc 5 để thực hiện: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createNewSubject();
                    break;
                case 2:
                    showListSubject();
                    break;
                case 3:
                    editSubject();
                    break;
                case 4:
                    deleteSubject();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void createNewSubject() {
        int size = subjectService.getSize();
        System.out.println("Nhập vào số lượng cần thêm mới");
        int n = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin thêm mới thứ " + (i + 1));
            Subject newSubject = new Subject();
            newSubject.displayDataSubject();
            // tiến hành them mới vào mảng
            subjectService.save(newSubject);
        }
    }

    private static void showListSubject() {
        if (subjectService.getSize() == 0){
            System.out.println("Không có học sinh nào");
            return;
        }
        for (Subject subject: subjectService.getAllSubject()) {
            if (subject != null){
                subject.displayDataSubject();
            }
        }
    }

    private static void editSubject(){
        System.out.println("Nhập vào id cần sửa");
        int idEdit = new Scanner(System.in).nextInt();
        Subject subject = subjectService.findById(String.valueOf(idEdit));
        if (subject == null){
            System.out.println("Không tìm thấy học sinh");
            return;
        }
        subject.inputDataSubject();
        subjectService.save(subject);

    }
    private static void deleteSubject() {
        System.out.println("Nhập vào id cần xóa");
        String idDel = new Scanner(System.in).nextLine();
        subjectService.deleteStudent(idDel);
    }

    private static void markManagement() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*********************MARK-MANAGEMENT************************");
            System.out.println("1. Thêm mới điểm thi cho 1 sinh viên");
            System.out.println("2. Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần");
            System.out.println("3. Thay đổi điểm theo mã id");
            System.out.println("4. Xóa điểm theo mã id");
            System.out.println("5. Hiển thị danh sách điểm thi theo mã môn học");
            System.out.println("6. Hiển thị đánh giá học lực của từng học sinh theo mã môn học");
            System.out.println("7. Thoát");
            System.out.print("Chọn 1, 2, 3, 4, 5, 6 hoặc 7 để thực hiện: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng trống

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
    }
}

