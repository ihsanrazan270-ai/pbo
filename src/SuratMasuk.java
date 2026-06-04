import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SuratMasuk {

    Scanner input = new Scanner(System.in);

    public void tambahSurat() {

        try {

            Connection conn = Koneksi.getConnection();

            System.out.print("Nomor Surat : ");
            String nomor = input.nextLine();

            System.out.print("Pengirim : ");
            String pengirim = input.nextLine();

            System.out.print("Perihal : ");
            String perihal = input.nextLine();

            System.out.print("Tanggal (YYYY-MM-DD) : ");
            String tanggal = input.nextLine();

            String sql = "INSERT INTO surat_masuk (nomor_surat,pengirim,perihal,tanggal) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nomor);
            ps.setString(2, pengirim);
            ps.setString(3, perihal);
            ps.setString(4, tanggal);

            ps.executeUpdate();

            System.out.println("Data berhasil disimpan!");

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }
    }

    public void tampilSurat() {

        try {

            Connection conn = Koneksi.getConnection();

            String sql = "SELECT * FROM surat_masuk";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== DATA SURAT MASUK =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | "
                        + rs.getString("nomor_surat") + " | "
                        + rs.getString("pengirim") + " | "
                        + rs.getString("perihal") + " | "
                        + rs.getString("tanggal"));
            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }
    }
}