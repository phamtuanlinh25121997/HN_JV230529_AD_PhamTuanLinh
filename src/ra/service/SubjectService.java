package ra.service;

import ra.model.Student;
import ra.model.Subject;

public class SubjectService {
    private Subject[] subjects = new Subject[20];
    public int size = 0;
    public Subject[] getAllSubject() {
        return subjects;
    }

    public int getSize() {
        return size;
    }

    public void save(Subject newsubject) {
        if (findById(newsubject.getSubjectId()) == null) {
            for (int i = 0; i < subjects.length; i++) {
                if (subjects[i] == null) {
                    subjects[i] = newsubject;
                    size++;
                    System.out.println("Thêm mới thành công");
                    return;
                }
            }
        } else {
            for (int i = 0; i < subjects.length;i++){
                subjects[i] = newsubject;
                System.out.println("Cập nhật thành công");
                return;
            }
        }
    }

    public Subject findById(String id) {
        for (Subject subjects : subjects) {
            if (subjects != null && subjects.getSubjectId() == id) {
                return subjects;
            }
        }
        return null;
    }
    public void deleteStudent(String idDel){
        if(findById(idDel) == null){
            // không ttoonf tại
            System.err.println("ID không tồn tại");
            return;
        }
        // cho phép xóa
        for (int i = 0; i < subjects.length; i++) {
            if(subjects[i]!=null && subjects[i].getSubjectId() == idDel) {
                subjects[i] = null;
                size--;
                System.out.println("Xóa thành công");
                break;
            }
        }
    }
}
