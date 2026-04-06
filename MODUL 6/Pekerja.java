import java.time.LocalDate;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jenisKelamin, String nik, boolean menikah,
            double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        int lamaKerja = LocalDate.now().getYear() - tahunMasuk.getYear();

        if (lamaKerja >= 0 && lamaKerja <= 5) {
            return gaji * 0.05;
        } else if (lamaKerja >= 6 && lamaKerja <= 10) {
            return gaji * 0.10;
        } else {
            return gaji * 0.15;
        }
    }

    public double getGaji() {
        return gaji + getBonus();
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20);
    }

    @Override
    public double getPendapatan() {
        return getTunjangan() + getGaji();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                 String.format(
                "Tahun Masuk   : %s\n" +
                "Jumlah Anak   : %d",tahunMasuk, jumlahAnak
                );
    }
}
