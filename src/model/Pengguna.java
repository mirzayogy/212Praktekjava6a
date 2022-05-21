package model;

import helper.MyConnection;

import java.sql.*;
import java.util.ArrayList;

public class Pengguna {

    private int id;
    private String username;
    private String password;
    private String namaLengkap;
    private String level;

    private Connection connection;

    public Pengguna() {
    }

    public Pengguna(int id, String username, String password, String namaLengkap, String level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.level = level;
    }

    //CRUD create read update delete
    public void create(){
        String createSQL = "INSERT INTO `pengguna` (`id`, `username`, `password`, `namaLengkap`, `level`) " +
                "VALUES " +
                "(NULL, ?, MD5(?), ?, ?)";

        MyConnection m = new MyConnection();
        this.connection = m.getConnection();
        try {
//            Statement statement = this.connection.createStatement();

            PreparedStatement preparedStatement = this.connection.prepareStatement(createSQL);
            preparedStatement.setString(1, this.username);
            preparedStatement.setString(2, this.password);
            preparedStatement.setString(3, this.namaLengkap);
            preparedStatement.setString(4, this.level);
            preparedStatement.execute();

            System.out.println("Berhasil Create Data");
        } catch (SQLException e) {
            System.err.println("Error Create Data");
        }

    }
    public ArrayList<Pengguna> read(){
        MyConnection m = new MyConnection();
        this.connection = m.getConnection();

        ArrayList<Pengguna> listPengguna = new ArrayList<>();

        String readSQL = "SELECT * FROM pengguna";

        try {

            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(readSQL);

            Pengguna penggunaHasilQuery;
            while (resultSet.next()){
                penggunaHasilQuery = new Pengguna(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("namalengkap"),
                        resultSet.getString("level")
                );
                listPengguna.add(penggunaHasilQuery);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listPengguna;
    }
    public void update(){}
    public void delete(){}

    public void login(){}
    public void updatePassword(){}
    public void resetPassword(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
