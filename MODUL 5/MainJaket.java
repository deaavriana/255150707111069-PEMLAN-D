import java.util.Scanner;

public class MainJaket {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // objek jaket
        Jaket jaketA = new Jaket(100000, 95000);
        Jaket jaketB = new Jaket(125000, 120000);
        Jaket jaketC = new Jaket(175000, 160000);

        System.out.println("\nCV. LABKOMDAS - Penjualan Jaket");
        System.out.println("====================================");

        System.out.println("\nHarga Jaket:");
        System.out.println("Jaket A : Rp 100.000");
        System.out.println("Jaket B : Rp 125.000");
        System.out.println("Jaket C : Rp 175.000");

        System.out.println("\nDiskon berlaku jika beli > 100 buah:");
        System.out.println("Jaket A : Rp 95.000");
        System.out.println("Jaket B : Rp 120.000");
        System.out.println("Jaket C : Rp 160.000");

        System.out.println("------------------------------------");

        // input
        System.out.print("\nMasukkan jumlah Jaket A : ");
        int a = input.nextInt();

        System.out.print("Masukkan jumlah Jaket B : ");
        int b = input.nextInt();

        System.out.print("Masukkan jumlah Jaket C : ");
        int c = input.nextInt();

        // harga satuan
        int hargaA = jaketA.getHarga(a);
        int hargaB = jaketB.getHarga(b);
        int hargaC = jaketC.getHarga(c);

        // total per jaket
        int totalA = a * hargaA;
        int totalB = b * hargaB;
        int totalC = c * hargaC;

        int grandTotal = totalA + totalB + totalC;

        // output
        System.out.println("\n========== STRUK PEMBELIAN ==========");

        // Jaket A
        System.out.printf("%-12s : %d buah%n", "Jaket A", a);
        if (a > 100) {
            System.out.printf("%-12s : Rp 95.000%n", "Harga diskon");
        } else {
            System.out.printf("%-12s : Rp 100.000%n", "Harga normal");
        }
        Jaket.printRupiah("Total", totalA);

        // Jaket B
        System.out.printf("\n%-12s : %d buah%n", "Jaket B", b);
        if (b > 100) {
            System.out.printf("%-12s : Rp 120.000%n", "Harga diskon");
        } else {
            System.out.printf("%-12s : Rp 125.000%n", "Harga normal");
        }
        Jaket.printRupiah("Total", totalB);

        // Jaket C
        System.out.printf("\n%-12s : %d buah%n", "Jaket C", c);
        if (c > 100) {
            System.out.printf("%-12s : Rp 160.000%n", "Harga diskon");
        } else {
            System.out.printf("%-12s : Rp 175.000%n", "Harga normal");
        }
        Jaket.printRupiah("Total", totalC);

        System.out.println("------------------------------------");
        Jaket.printRupiah("GRAND TOTAL", grandTotal);
        System.out.println("====================================");

        input.close();
    }
}