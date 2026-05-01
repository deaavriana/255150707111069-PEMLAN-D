public class Matkomlan extends MataKuliah {
    public Matkomlan() {
        super("Matkomlan");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (nilaiTugas * 0.3) + (nilaiKuis * 0.2) + (nilaiUts * 0.2) + (nilaiUas * 0.3);
    }

}
