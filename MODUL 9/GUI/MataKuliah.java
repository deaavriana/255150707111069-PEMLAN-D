public abstract class MataKuliah {
    protected String nama;
    protected double nilaiTugas, nilaiKuis, nilaiUts, nilaiUas;

    public MataKuliah(String namaString) {
        this.nama = namaString;
    }

    public String getNama() {
        return nama;
    }

    public void setNilai(double tugas, double kuis, double uts, double uas) {
        this.nilaiTugas = tugas;
        this.nilaiKuis = kuis;
        this.nilaiUts = uts;
        this.nilaiUas = uas;
    }

    public abstract double hitungNilaiAkhir();

    public String getGrade() {
        double nilaiAkhir = hitungNilaiAkhir();
        if (nilaiAkhir >= 85)
            return "A";
        else if (nilaiAkhir >= 70)
            return "B";
        else if (nilaiAkhir >= 55)
            return "C";
        else if (nilaiAkhir >= 40)
            return "D";
        else
            return "E";
    }
}