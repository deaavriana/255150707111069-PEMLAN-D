public class Probstat extends MataKuliah {
    public Probstat() {
        super("Probstat");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (nilaiTugas * 0.1) + (nilaiKuis * 0.2) + (nilaiUts * 0.3) + (nilaiUas * 0.4);
    }

}
