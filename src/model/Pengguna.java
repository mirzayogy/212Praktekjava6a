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
    public void update(){
        String updateSQL = "UPDATE `pengguna` SET `username` = ?, `password` = MD5(?), `namaLengkap` = ?, `level` = ? WHERE `pengguna`.`id` = ?";

        MyConnection m = new MyConnection();
        this.connection = m.getConnection();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, this.username);
            preparedStatement.setString(2, this.password);
            preparedStatement.setString(3, this.namaLengkap);
            preparedStatement.setString(4, this.level);
            preparedStatement.setInt(5, this.id);
            preparedStatement.execute();

            System.out.println("Berhasil Update Data");
        } catch (SQLException e) {
            System.err.println("Error Update Data");
        }
    }
    public void delete(){
        String deleteSQL = "DELETE FROM `pengguna` WHERE `pengguna`.`id` = ?";

        MyConnection m = new MyConnection();
        this.connection = m.getConnection();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();

            System.out.println("Berhasil Hapus Data");
        } catch (SQLException e) {
            System.err.println("Error Hapus Data");
        }
    }

    public boolean login(){
        boolean hasil;
        MyConnection m = new MyConnection();
        this.connection = m.getConnection();

        ArrayList<Pengguna> listPengguna = new ArrayList<>();

        String loginSQL = "SELECT * FROM pengguna WHERE username=? AND password = MD5(?)";

        try {

            PreparedStatement preparedStatement = this.connection.prepareStatement(loginSQL);
            preparedStatement.setString(1, this.username);
            preparedStatement.setString(2, this.password);
            ResultSet resultSet = preparedStatement.executeQuery();

            hasil = false;
            while (resultSet.next()){
               hasil = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }
    public boolean updatePassword(String passwordLama){
        boolean passwordLamaBenar;
        boolean hasil = false;
        String cariSQL = "SELECT * FROM pengguna WHERE username=? AND password = MD5(?)";

        MyConnection m = new MyConnection();
        this.connection = m.getConnection();

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(cariSQL);
            preparedStatement.setString(1, this.username);
            preparedStatement.setString(2, passwordLama);
            ResultSet resultSet = preparedStatement.executeQuery();

            passwordLamaBenar = false;
            while (resultSet.next()){
                passwordLamaBenar = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(passwordLamaBenar){
            String updateSQL = "UPDATE `pengguna` SET `password` = MD5(?) WHERE `pengguna`.`username` = ?";
            try {
                PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
                preparedStatement.setString(1, this.password);
                preparedStatement.setString(2, this.username);
                preparedStatement.execute();

                System.out.println("Berhasil Update Password");

                hasil = true;
            } catch (SQLException e) {
                System.err.println("Error Update Password");
            }
        }
        return hasil;
    }
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
