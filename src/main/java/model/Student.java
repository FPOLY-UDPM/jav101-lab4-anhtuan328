package model;

public class Student {

    private int id;
    private String masv;
    private String hoten;

    public Student() {
    }

    public Student(String masv, String hoten) {
        this.masv = masv;
        this.hoten = hoten;
    }

    public Student(int id, String masv, String hoten) {
        this.id = id;
        this.masv = masv;
        this.hoten = hoten;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getMasv() {
        return masv;
    }

    public String getHoten() {
        return hoten;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", masv='" + masv + '\'' +
                ", hoten='" + hoten + '\'' +
                '}';
    }
}