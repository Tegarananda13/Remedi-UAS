import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Pegawai gar = new login();
       boolean lanjut = true;

       gar.loginn();

       while(lanjut){
        System.out.println("\n        Laundry HaloGar ");
        System.out.println("==============================");
        System.out.println("1. tambah produk");
        System.out.println("2. update produk");
        System.out.println("3. hapus produk");
        System.out.println("4. tampilkan produk");
        System.out.println("5. lihat treemap");
        System.out.println("0. keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        Scanner str = new Scanner(System.in);
        String input = str.nextLine();

        switch (input) {
            case "0":
                System.out.println("sampai jumpa kembali:)");
                System.exit(0);
                lanjut = false;
                break;

            case "1":
                gar.Add();
                break;

            case "2":
                gar.Update();
                break;

            case "3":
                gar.Delete();
                break;

            case "4":
                gar.Show();
                break;
            
            case "5":
                gar.view();
                break;

       }



        

    }
}
}
