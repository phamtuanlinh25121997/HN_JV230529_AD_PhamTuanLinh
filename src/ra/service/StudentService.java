package ra.service;

import ra.model.Student;
import ra.model.Subject;

public class StudentService {
    private Student[] students = new Student[100];
    public int size = 0;

    public Student[] getAllStuden() {
        return students;
    }

    public int getSize() {
        return size;
    }

    public void save(Student student) {
        if (findById(student.getStudentId()) == null) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    size++;
                    System.out.println("Thêm mới thành công");
                    return;
                }
            }
        } else {
            for (int i = 0; i < students.length;i++){
                students[i] = student;
                System.out.println("Cập nhật thành công");
                return;
            }
        }
    }

    public Student findById(int id) {
        for (Student students : students) {
            if (students != null && students.getStudentId() == id) {
                return students;
            }
        }
        return null;
    }
    public void deleteStudent(int idDel){
        if(findById(idDel) == null){
            // không ttoonf tại
            System.err.println("ID không tồn tại");
            return;
        }
        // cho phép xóa
        for (int i = 0; i < students.length; i++) {
            if(students[i]!=null && students[i].getStudentId() == idDel) {
                students[i] = null;
                size--;
                System.out.println("Xóa thành công");
                break;
            }
        }
    }
    public int getNewId(){
        // id tự tăng
        int max=0;
        for (Student st : students
        ) {
            if(st!=null && st.getStudentId()> max){
                max = st.getStudentId();
            }
        }
        return max+1;
    }


}
