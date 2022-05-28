import model.Pengguna;

import java.util.ArrayList;

public class MainCoba {
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

        Pengguna mauLogin = new Pengguna();
        mauLogin.setUsername("user2");
        mauLogin.setPassword("inipaswordbaru");
        if(mauLogin.login()){
            System.out.println("Login Berhasil");
        } else {
            System.err.println("Gagal Login");
        }

        Pengguna gantiPassword = new Pengguna();
        gantiPassword.setUsername("user2");
        gantiPassword.setPassword("user2");

        if(gantiPassword.updatePassword("inipaswordbaru")){
            System.out.println("Update password berhasil");
        } else {
            System.err.println("Gagal update password");
        }
    }
}
