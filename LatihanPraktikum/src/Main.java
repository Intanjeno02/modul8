import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        KartuKredit kartuy = new KartuKredit("senjana", 2000000, 123456789); //membuat objek KartuKredit
        EWallet Walet = new EWallet("tata", 300000, "GoPay", "08123456789"); //membuat objek EWallet

        ArrayList<Pembayaran> daftarPembayaran = new ArrayList<>(); //membuat ArrayList untuk menyimpan objek Pembayaran
        daftarPembayaran.add(kartuy); //menambahkan objek KartuKredit
        daftarPembayaran.add(Walet); //menambahkan objek EWallet

        for (Pembayaran pembayaran : daftarPembayaran) { //iterasi melalui daftarPembayaran
            pembayaran.tampilkanDetail(); //memanggil metode tampilkanDetail untuk setiap objek Pembayaran
            if (pembayaran instanceof Keamanan) { //memeriksa apakah objek Pembayaran juga mengimplementasikan interface Keamanan
                pembayaran.prosesPembayaran(); //memanggil metode prosesPembayaran untuk memproses pembayaran
                ((Keamanan) pembayaran).autentikasi(); //memanggil metode autentikasi jika objek tersebut mengimplementasikan Keamanan
            }
        }
    }
}
