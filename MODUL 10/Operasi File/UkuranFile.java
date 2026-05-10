import java.io.File;

public class UkuranFile {
    public static void main(String[] args) {

        File file = new File("test.txt");

        if (file.exists()) {

            double ukuranBytes = file.length();
            double ukuranKB = ukuranBytes / 1024;
            double ukuranMB = ukuranKB / 1024;

            if (ukuranMB >= 1) {
                System.out.printf("Ukuran file: %.2f MB\n", ukuranMB);
            } else {
                System.out.printf("Ukuran file: %.2f KB\n", ukuranKB);
            }

        } else {
            System.out.println("File tidak ditemukan");
        }
    }
}