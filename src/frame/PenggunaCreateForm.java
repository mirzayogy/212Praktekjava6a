package frame;

import model.Pengguna;

import javax.swing.*;

public class PenggunaCreateForm extends JFrame{
    private JPasswordField tfPassword;
    private JTextField tfNamaLengkap;
    private JTextField tfLevel;
    private JTextField tfUsername;
    private JButton simpanButton;
    private JButton batalButton;
    public JPanel panelMain;


    public PenggunaCreateForm() {
        simpanButton.addActionListener(e -> {
            Pengguna p = new Pengguna();
            p.setUsername(tfUsername.getText());
            p.setPassword(tfPassword.getPassword().toString());
            p.setNamaLengkap(tfNamaLengkap.getText());
            p.setLevel(tfLevel.getText());
            p.create();

            tfUsername.setText("");
            tfPassword.setText("");
            tfNamaLengkap.setText("");
            tfLevel.setText("");

            JOptionPane.showMessageDialog(null, "Simpan data berhasil");
            dispose();
        });
        batalButton.addActionListener(e -> {
            dispose();
        });
    }

    public PenggunaCreateForm(int id) {
        Pengguna p = new Pengguna();
        p.setId(id);
        p.find();
        tfUsername.setText(p.getUsername());
        tfNamaLengkap.setText(p.getNamaLengkap());
        tfLevel.setText(p.getLevel());

        simpanButton.addActionListener(e -> {
            Pengguna pSimpan = new Pengguna();
            pSimpan.setId(id);
            pSimpan.setUsername(tfUsername.getText());
            pSimpan.setPassword(tfPassword.getPassword().toString());
            pSimpan.setNamaLengkap(tfNamaLengkap.getText());
            pSimpan.setLevel(tfLevel.getText());
            pSimpan.update();

            tfUsername.setText("");
            tfPassword.setText("");
            tfNamaLengkap.setText("");
            tfLevel.setText("");

            JOptionPane.showMessageDialog(null, "Ubah data berhasil");
            dispose();
        });
        batalButton.addActionListener(e -> {
            dispose();
        });
    }

}
