public class ASD extends MataKuliah {
    public ASD() {
        super("ASD");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (nilaiTugas * 0.25) + (nilaiKuis * 0.25) + (nilaiUts * 0.25) + (nilaiUas * 0.25);
    }
}
