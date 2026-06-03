package dao;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();

        String sql = """
                SELECT ID, MASV,
                       Ho + ' ' + TenLot + ' ' + Ten AS HoTen
                FROM SINHVIEN
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("ID"),
                        rs.getString("MASV"),
                        rs.getString("HoTen")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Student findById(int id) {

        String sql = """
                SELECT ID, MASV,
                       Ho + ' ' + TenLot + ' ' + Ten AS HoTen
                FROM SINHVIEN
                WHERE ID = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("ID"),
                        rs.getString("MASV"),
                        rs.getString("HoTen")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(Student s) {

        String sql = """
                INSERT INTO SINHVIEN(MASV, Ho, TenLot, Ten)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getMasv());

            String[] parts = s.getHoten().split(" ", 3);

            ps.setString(2, parts.length > 0 ? parts[0] : "");
            ps.setString(3, parts.length > 2 ? parts[1] : "");
            ps.setString(4, parts.length > 2 ? parts[2] : "");

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Student s) {

        String sql = """
                UPDATE SINHVIEN
                SET MASV = ?, Ho = ?, TenLot = ?, Ten = ?
                WHERE ID = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String[] parts = s.getHoten().split(" ", 3);

            ps.setString(1, s.getMasv());
            ps.setString(2, parts.length > 0 ? parts[0] : "");
            ps.setString(3, parts.length > 2 ? parts[1] : "");
            ps.setString(4, parts.length > 2 ? parts[2] : "");
            ps.setInt(5, s.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM SINHVIEN WHERE ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}