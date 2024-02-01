public class login extends Pegawai {

    @Override
    public void loginn() {

        System.out.println("\tSelamat Datang Di Laundry HaloGar");
        System.out.println("      -------------------------------");
        while (true) { // perulangan jka username dan password tidak valid

            System.out.print("username\t: ");
            inputUserName = Str.nextLine();

            System.out.print("password\t: ");
            inputPw = Str.nextLine();

            if (inputPw.equals(pw) && inputUserName.equals(username)) {// memberhentikan perulangan jika input valid
                System.out.println("");
                break;
            } else {
                System.out.println("username atau password salah\n"); // message jika input tidak valid
            }

        }

        while (true) {// perulangan bila input captcha tidak valid
            System.out.println("kode captcha\t: " + cap);
            System.out.print("entry cap\t: ");
            inputCap = Str.nextLine();

            if (inputCap.equalsIgnoreCase(cap)) {// meberhentikan perulangan jika input valid
                break;
            } else {
                System.out.println("\nsilahkan masukkan lagi"); // message jika input tidak valid
            }

        }
        System.out.println("==============================================\n");
    }

}
