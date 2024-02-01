import java.sql.*;
import java.util.*;
import java.util.Map.Entry;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

public class Pegawai implements CRUD {
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3306/tugasbesar";
    public String user = "root";
    public String pass = "";

    public Connection conn;
    public Statement stat;
    public ResultSet result;

    Scanner Str = new Scanner(System.in);
    Scanner inte = new Scanner(System.in);

    String username = "gar"; // username admin
    String inputUserName;
    String pw = "123"; // pw admin
    String inputPw;
    String cap = "TG11"; // captcha
    String inputCap;

    TreeMap<Integer, String> uhu = new TreeMap<>();// buat objek treemap

    @Override
    //method untuk mengkoneksikan ke database
    public void Connection() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    //method untuk menambah produk yang di 
    public void Add () {
        Connection (); 
        try {
            stat = conn.createStatement();
            System.out.println("Masukkan Id Produk");
            String Id = Str.nextLine();
            System.out.println("Nama");
            String Nama = Str.nextLine();
            System.out.println("Total_Berat");
            String Nama_Cymbal = Str.nextLine();
            System.out.println("Id_Laundry");
            String Id_Cymbal = Str.nextLine();
            System.out.println("Harga");
            Integer Harga = inte.nextInt();
            System.out.println("Total_Bayar");
            Integer Jumlah = inte.nextInt();

            uhu.put(Jumlah, Nama_Cymbal);// memasukkan isi treemap
            String sql = "INSERT INTO laundry (Id, Nama, Total_Berat, Id_Laundry, Harga, Jumlah, Total_Bayar) VALUE ('%s', '%s', '%s', '%s', %d, %d)";
            sql = String.format(sql, Id, Nama, Total_Berat, Id_Laundry, Harga, Total_Bayar);
            stat.execute(sql);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void view() {
        System.out.println("\nmenampilkan berat barang dari yang paling kecil:");
        for (Entry<Integer, String> entry : uhu.entrySet()) {
            System.out.println("Total Bayar\t: " + entry.getKey() + "\tKode Laundry\t: " +
                    entry.getValue());
        }
    }


    @Override
    //
    public void Delete () {
        Connection ();
        try {
            stat = conn.createStatement();

            System.out.print("Masukkan kode Id yang mau di hapus : ");
            String inputId = Str.nextLine();

            String sql = String.format("DELETE FROM laundry WHERE Id = '%s'", inputId);

            stat.execute(sql);
            System.out.println("Data terhapus");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    @Override
    //
    public void Update () {
        Connection ();
        try {
            System.out.println("Masukkan Id yang mau di edit");
            String Id = Str.nextLine();
            System.out.println("Nama pelanggan baru");
            String Nama = Str.nextLine();
            System.out.println("Total Berat Laundry baru");
            String Nama_Cymbal = Str.nextLine();
            System.out.println("Id Laundry baru");
            String Id_Cymbal = Str.nextLine();
            System.out.println("Harga baru");
            Integer Harga = inte.nextInt();
            System.out.println("Total Bayar baru");
            Integer Jumlah = inte.nextInt();

            String sql = "UPDATE laundry SET Nama='%s', Total_Berat='%s', Id_Laundry = '%s', Harga = %d, Total_Bayar = %d, Jumlah = %d WHERE Id = '%s'";
            sql = String.format(sql, Nama, Nama_Cymbal, Id_Cymbal, Harga, Total_Bayar, Jumlah, Id);

            try (Statement updateStatement = conn.createStatement()) {
                updateStatement.executeUpdate(sql);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    //
    public void Show () {
        Connection ();
        String sql = "SELECT * FROM laundry";
        try {
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                String Id = result.getString("Id");
                String Nama = result.getString("Nama");
                String Nama_Cymbal = result.getString("Total_Berat");
                String Id_Cymbal = result.getString("Id_Laundry");
                Integer Harga = result.getInt("Harga");
                Integer Total_Bayar = result.getInt("Total_Bayar");
                Integer Jumlah = result.getInt("Jumlah");

                System.out.println("Id Barang = " + Id);
                System.out.println("Nama = " + Nama );
                System.out.println("Nama Cymbal = " + Total_Berat);
                System.out.println("Id Cymbal = " + Id_Laundry);
                System.out.println("Harga = " + Harga);
                System.out.println("Total Bayar = " + Total_Bayar);
                System.out.println("Jumlah = " + Jumlah); 
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

   public void loginn(){

   }





}
