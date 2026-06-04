import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfExporter {

    public static void exportPDF() {

        try {

            Document document = new Document();

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream("LaporanSurat.pdf"));

            document.open();

            document.add(new Paragraph("LAPORAN DATA SURAT"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Data Surat Masuk dan Surat Keluar"));
            document.add(new Paragraph("Tanggal Cetak: " + java.time.LocalDate.now()));

            document.close();

            System.out.println("PDF berhasil dibuat!");

        } catch (Exception e) {

            System.out.println("Gagal membuat PDF!");
            System.out.println(e.getMessage());
        }
    }
}