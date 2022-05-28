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
        });
        batalButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}
