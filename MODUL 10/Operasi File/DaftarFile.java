import java.io.File;

public class DaftarFile {
    public static void main(String[] args) {

        File direktori = new File(".");

        String[] daftarFile = direktori.list();

        if (daftarFile != null) {
            System.out.println("Daftar file dalam direktori:");

            for (String namaFile : daftarFile) {
                System.out.println(namaFile);
            }
        } else {
            System.out.println("Direktori tidak ditemukan");
        }
    }
}
