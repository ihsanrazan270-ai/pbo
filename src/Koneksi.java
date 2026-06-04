import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getConnection() {

        try {

            if (koneksi == null || koneksi.isClosed()) {

                String url = "jdbc:mysql://localhost:3306/db_surat";
                String user = "root";
                String password = "";

                koneksi = DriverManager.getConnection(url, user, password);

                System.out.println("Koneksi database berhasil!");
            }

        } catch (Exception e) {

            System.out.println("Koneksi database gagal!");
            System.out.println(e.getMessage());
        }

        return koneksi;
    }
}