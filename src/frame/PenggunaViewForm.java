package frame;

import model.Pengguna;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class PenggunaViewForm extends JFrame{
    public JPanel panelMain;
    private JPanel panelJudul;
    private JTextField textField1;
    private JButton cariButton;
    private JTable tablePengguna;
    private JButton tambahButton;
    private JButton ubahButton;
    private JButton hapusButton;
    private JButton batalButton;
    private JButton tutupButton;
    private JScrollPane scrollPane1;

    public PenggunaViewForm() {
        tutupButton.addActionListener(e -> {
            System.exit(0);
        });
        tambahButton.addActionListener(e -> {
            PenggunaCreateForm f = new PenggunaCreateForm();
            f.setContentPane(f.panelMain);
            f.setTitle("Input Data Pengguna");
            f.pack();
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
        hapusButton.addActionListener(e -> {
            int barisTerpilih = tablePengguna.getSelectedRow();
            int pilihan = JOptionPane.showConfirmDialog(null,
                    "Yakin mau hapus?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
                    );
            if(pilihan == 0){
                if(barisTerpilih >= 0){
                    TableModel tm = tablePengguna.getModel();
                    Pengguna p = new Pengguna();
                    int id = Integer.parseInt(tm.getValueAt(barisTerpilih,0).toString());
                    p.setId(id);
                    p.delete();
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih data dulu");
                }
            }
            refreshTable();
        });
        batalButton.addActionListener(e -> {
            refreshTable();
        });

        ubahButton.addActionListener(e -> {

            int barisTerpilih = tablePengguna.getSelectedRow();
            if(barisTerpilih >= 0){
                TableModel tm = tablePengguna.getModel();
                int id = Integer.parseInt(tm.getValueAt(barisTerpilih,0).toString());

                PenggunaCreateForm f = new PenggunaCreateForm(id);
                f.setContentPane(f.panelMain);
                f.setTitle("Input Data Pengguna");
                f.pack();
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data dulu");
            }


        });
    }

    public void refreshTable(){
        Pengguna p = new Pengguna();
        ArrayList<Pengguna> list = p.read();

        Object[][] row = new Object[list.size()][4];

        for (int i = 0; i < list.size() ; i++) {
            row[i][0]= list.get(i).getId();
            row[i][1]= list.get(i).getUsername();
            row[i][2]= list.get(i).getNamaLengkap();
            row[i][3]= list.get(i).getLevel();
        }

        String penggunaHeader[] = {"Id","Username","Nama Lengkap","Level"};
        TableModel tm = new DefaultTableModel(row,penggunaHeader);
        tablePengguna.setModel(tm);
    }


    private void createUIComponents() {
        Pengguna p = new Pengguna();
        ArrayList<Pengguna> list = p.read();

        Object[][] row = new Object[list.size()][4];

        for (int i = 0; i < list.size() ; i++) {
            row[i][0]= list.get(i).getId();
            row[i][1]= list.get(i).getUsername();
            row[i][2]= list.get(i).getNamaLengkap();
            row[i][3]= list.get(i).getLevel();
        }

        String penggunaHeader[] = {"Id","Username","Nama Lengkap","Level"};
        TableModel tm = new DefaultTableModel(row,penggunaHeader);
        tablePengguna = new JTable(tm);
    }

}
