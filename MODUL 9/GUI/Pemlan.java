public class Pemlan extends MataKuliah {
    public Pemlan() {
        super("Pemlan");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (nilaiTugas * 0.2) + (nilaiKuis * 0.2) + (nilaiUts * 0.3) + (nilaiUas * 0.3);
    }

}
