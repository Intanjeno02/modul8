public class KartuKredit extends Pembayaran implements Keamanan { //kelas KartuKredit yang mengimplementasikan interface Pembayaran dan Keamanan
    private int nomorKartu; //atribut tambahan untuk KartuKredit

    public KartuKredit(String namaPembayar, double nominal, int nomorKartu) {
        super(namaPembayar, nominal); //memanggil konstruktor dari kelas Pembayaran
        this.nomorKartu = nomorKartu;
    }

    @Override
    public void prosesPembayaran() { //implementasi metode prosesPembayaran dari interface Pembayaran
        double admin = nominal * 0.02;
        double total = nominal + admin; //perhitungan admin sebesar 2% dari nominal
        System.out.println("Biaya admin: " + admin);
        System.out.println("Total pembayaran dengan Kartu Kredit: " + (nominal + admin));
    }

    @Override
    public boolean autentikasi() { //implementasi metode autentikasi dari interface Keamanan
        System.out.println("Autentikasi PIN berhasil");
        return true; //autentikasi berhasil
    }
}
