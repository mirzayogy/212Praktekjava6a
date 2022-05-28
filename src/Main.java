import frame.PenggunaCreateForm;
import frame.PenggunaCreateFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        PenggunaCreateFrame frame = new PenggunaCreateFrame();
//        frame.meletakkanKomponen();
//        frame.menambahkanListener();
//        frame.setVisible(true);

        PenggunaCreateForm f = new PenggunaCreateForm();
        f.setContentPane(f.panelMain);
        f.setTitle("Input Data Pengguna");
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
