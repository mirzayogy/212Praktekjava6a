package model;

public class Pengguna {

    private int id;
    private String username;
    private String password;
    private String namaLengkap;
    private String level;

    public Pengguna() {
    }

    public Pengguna(int id, String username, String password, String namaLengkap, String level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.level = level;
    }
}
