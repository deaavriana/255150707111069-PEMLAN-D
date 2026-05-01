import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormMahasiswa extends JFrame {

    JTextField tNama, tTTL, tNoDaftar, tTelp, tEmail;
    JTextArea tAlamat;
    JButton submit;

    public FormMahasiswa() {
        setTitle("Form Daftar Ulang Mahasiswa");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // label dan inputan
        addLabel("Nama Lengkap", 20, 20);
        tNama = addTextField(150, 20);

        addLabel("Tanggal Lahir", 20, 50);
        tTTL = addTextField(150, 50);

        addLabel("Nomor Pendaftaran", 20, 80);
        tNoDaftar = addTextField(150, 80);

        addLabel("No. Telp", 20, 110);
        tTelp = addTextField(150, 110);

        addLabel("Alamat", 20, 140);
        tAlamat = new JTextArea();
        JScrollPane sp = new JScrollPane(tAlamat);
        sp.setBounds(150, 140, 200, 60);
        add(sp);

        addLabel("E-mail", 20, 210);
        tEmail = addTextField(150, 210);

        submit = new JButton("Submit");
        submit.setBounds(260, 250, 90, 25);
        add(submit);

        // tombol submit
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prosesSubmit();
            }
        });

        setVisible(true);
    }

    // method untuk menambahkan label
    JLabel addLabel(String text, int x, int y) {
        JLabel l = new JLabel(text);
        l.setBounds(x, y, 130, 20);
        add(l);
        return l;
    }

    JTextField addTextField(int x, int y) {
        JTextField t = new JTextField();
        t.setBounds(x, y, 200, 20);
        add(t);
        return t;
    }

    void prosesSubmit() {

        if (tNama.getText().isEmpty() ||
                tTTL.getText().isEmpty() ||
                tNoDaftar.getText().isEmpty() ||
                tTelp.getText().isEmpty() ||
                tAlamat.getText().isEmpty() ||
                tEmail.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Semua kolom harus diisi!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // konfirmasi data sebelum ditampilkan
        int pilih = JOptionPane.showConfirmDialog(this,
                "Apakah anda yakin data yang Anda isi sudah benar?",
                "Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION);

        if (pilih == JOptionPane.OK_OPTION) {
            tampilData();
        }
        // kalau cancel → otomatis kembali ke form
    }

    void tampilData() {
        JFrame hasil = new JFrame("Data Mahasiswa");
        hasil.setSize(350, 300);
        hasil.setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        area.setFont(new Font("Monospaced", Font.PLAIN, 12));

        String data = String.format(
                "        Data Mahasiswa\n\n" +
                        "%-17s : %s\n" +
                        "%-17s : %s\n" +
                        "%-17s : %s\n" +
                        "%-17s : %s\n" +
                        "%-17s : %s\n" +
                        "%-17s : %s\n",

                "Nama", tNama.getText(),
                "Tanggal Lahir", tTTL.getText(),
                "No. Pendaftaran", tNoDaftar.getText(),
                "No. Telp", tTelp.getText(),
                "Alamat", tAlamat.getText(),
                "E-mail", tEmail.getText());

        area.setText(data);

        area.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        hasil.add(area);
        hasil.setVisible(true);
    }

    public static void main(String[] args) {
        new FormMahasiswa();
    }
}
