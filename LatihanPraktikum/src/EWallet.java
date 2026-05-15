public class EWallet extends Pembayaran implements Keamanan { //kelas EWallet yang mengimplementasikan interface Pembayaran dan Keamanan
    private String nomorHP; //atribut tambahan untuk EWallet

    public EWallet(String namaPembayar, double nominal, String namaEWallet, String nomorHP) {
        super(namaPembayar, nominal); //memanggil konstruktor dari kelas Pembayaran
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran() { //implementasi metode prosesPembayaran dari interface Pembayaran
        System.out.println("Total tagihan: " + nominal); // menampilkan total tagihan tapa biaya admin
    }

    @Override
    public boolean autentikasi() { //implementasi metode autentikasi dari interface Keamanan
        System.out.println("Autentikasi berhasil " ); //pesan bahwa autentikasi berhasil
        return true; //autentikasi berhasil
    }
    
}
