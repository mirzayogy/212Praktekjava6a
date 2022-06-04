import frame.PenggunaCreateForm;
import frame.PenggunaCreateFrame;
import frame.PenggunaViewForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        PenggunaCreateFrame frame = new PenggunaCreateFrame();
//        frame.meletakkanKomponen();
//        frame.menambahkanListener();
//        frame.setVisible(true);



        PenggunaViewForm vf = new PenggunaViewForm();
        vf.setContentPane(vf.panelMain);
        vf.pack();
        vf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vf.setLocationRelativeTo(null);
        vf.setVisible(true);
    }
}
