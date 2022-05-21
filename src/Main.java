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
        coba.setUsername("user4");
        coba.setPassword("user4");
        coba.setNamaLengkap("User Empat");
        coba.setLevel("user");
        coba.create();
    }
}
