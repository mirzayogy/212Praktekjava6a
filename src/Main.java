import helper.MyConnection;
import model.Pengguna;

public class Main {
    public static void main(String[] args) {
//        MyConnection m = new MyConnection();
//        m.getConnection();

        Pengguna pengguna = new Pengguna();
        pengguna.read();
    }
}
