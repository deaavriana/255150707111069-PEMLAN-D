public class Jaket {

    private final int hargaNormal;
    private final int hargaDiskon;

    public Jaket(int hargaNormal, int hargaDiskon) {
        this.hargaNormal = hargaNormal;
        this.hargaDiskon = hargaDiskon;
    }

    public int getHarga(int jumlah) {
        if (jumlah > 100) {
            return hargaDiskon;
        } else {
            return hargaNormal;
        }
    }

    public static void printRupiah(String label, int nilai) {
        String hasil = String.format("%,d", nilai).replace(",", ".");
        System.out.printf("%-12s : Rp %s%n", label, hasil);
    }

    public int getHargaNormal() {
        return hargaNormal;
    }

    public int getHargaDiskon() {
        return hargaDiskon;
    }
}