import helper.MyConnection;
import model.Pengguna;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        MyConnection m = new MyConnection();
//        m.getConnection();

        Pengguna pengguna = new Pengguna();
        ArrayList<Pengguna> listPengguna = pengguna.read();

        for (Pengguna value: listPengguna){
            System.out.println(value.getNamaLengkap());
        }

//        Pengguna coba = new Pengguna(4,"user3","user3","User Tiga","user");
        Pengguna coba = new Pengguna();
        coba.setId(6);
//        coba.setUsername("user6");
//        coba.setPassword("user6");
//        coba.setNamaLengkap("User Enam");
//        coba.setLevel("user");
//        coba.create();
//        coba.update();
        coba.delete();
    }
}
