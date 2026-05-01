import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame {

    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;

    Checkbox rbPemlan, rbASD, rbMatkomlan, rbProbstat;
    CheckboxGroup group;

    Button btnHitung, btnTampil;

    TextArea area;

    String hasilSemua = "";

    public MainFrame() {

        setLayout(null);
        setSize(400, 500);
        setTitle("Hitung Nilai Akhir dengan GUI");

        // ===== JUDUL =====
        lbJudul = new Label("Hitung Nilai Akhir", Label.CENTER);
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        lbJudul.setBounds(100, 30, 200, 20);
        add(lbJudul);

        // ===== RADIO BUTTON =====
        group = new CheckboxGroup();

        rbASD = new Checkbox("ASD", group, false);
        rbPemlan = new Checkbox("Pemlan", group, true);
        rbMatkomlan = new Checkbox("Matkomlan", group, false);
        rbProbstat = new Checkbox("Probstat", group, false);

        rbASD.setBounds(50, 60, 60, 20);
        rbPemlan.setBounds(120, 60, 80, 20);
        rbMatkomlan.setBounds(200, 60, 90, 20);
        rbProbstat.setBounds(300, 60, 80, 20);

        add(rbASD);
        add(rbPemlan);
        add(rbMatkomlan);
        add(rbProbstat);

        // ===== LABEL =====
        lbTugas = new Label("Tugas :");
        lbKuis = new Label("Kuis :");
        lbUTS = new Label("UTS :");
        lbUAS = new Label("UAS :");
        lbHasil = new Label("Hasil :");

        lbTugas.setBounds(80, 100, 60, 20);
        lbKuis.setBounds(80, 130, 60, 20);
        lbUTS.setBounds(80, 160, 60, 20);
        lbUAS.setBounds(80, 190, 60, 20);
        lbHasil.setBounds(80, 220, 60, 20);

        add(lbTugas);
        add(lbKuis);
        add(lbUTS);
        add(lbUAS);
        add(lbHasil);

        // ===== TEXTFIELD =====
        txtTugas = new TextField();
        txtKuis = new TextField();
        txtUTS = new TextField();
        txtUAS = new TextField();
        txtHasil = new TextField();
        txtHasil.setEditable(false);

        txtTugas.setBounds(160, 100, 100, 20);
        txtKuis.setBounds(160, 130, 100, 20);
        txtUTS.setBounds(160, 160, 100, 20);
        txtUAS.setBounds(160, 190, 100, 20);
        txtHasil.setBounds(160, 220, 100, 20);

        add(txtTugas);
        add(txtKuis);
        add(txtUTS);
        add(txtUAS);
        add(txtHasil);

        // ===== BUTTON =====
        btnHitung = new Button("Hitung");
        btnHitung.setBounds(140, 260, 100, 25);
        add(btnHitung);

        // ===== TEXTAREA =====
        Label lbArea = new Label("HASIL NILAI SEMUA MATA KULIAH");
        lbArea.setBounds(80, 300, 250, 20);
        add(lbArea);

        area = new TextArea();
        area.setBounds(80, 330, 240, 100);
        add(area);

        btnTampil = new Button("Tampilkan nilai semua matkul");
        btnTampil.setBounds(80, 440, 240, 30);
        add(btnTampil);

        // ===== RESET =====
        ItemListener reset = e -> {
            txtTugas.setText("");
            txtKuis.setText("");
            txtUTS.setText("");
            txtUAS.setText("");
            txtHasil.setText("");
        };

        rbPemlan.addItemListener(reset);
        rbASD.addItemListener(reset);
        rbMatkomlan.addItemListener(reset);
        rbProbstat.addItemListener(reset);

        // ===== HITUNG =====
        btnHitung.addActionListener(e -> {
            try {
                double t = Double.parseDouble(txtTugas.getText());
                double k = Double.parseDouble(txtKuis.getText());
                double uts = Double.parseDouble(txtUTS.getText());
                double uas = Double.parseDouble(txtUAS.getText());

                MataKuliah mk;

                if (rbPemlan.getState())
                    mk = new Pemlan();
                else if (rbASD.getState())
                    mk = new ASD();
                else if (rbMatkomlan.getState())
                    mk = new Matkomlan();
                else
                    mk = new Probstat();

                mk.setNilai(t, k, uts, uas);

                double hasil = mk.hitungNilaiAkhir();

                txtHasil.setText(String.format("%.1f", hasil));

                hasilSemua += String.format("%-14s : %.1f\n", mk.getNama(), hasil);

            } catch (Exception ex) {
                txtHasil.setText("Error");
            }
        });

        // ===== TAMPIL =====
        btnTampil.addActionListener(e -> {
            area.setText(hasilSemua);
        });

        // ===== CLOSE =====
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}