public class KartuKredit extends Pembayaran implements Keamanan { 
    private int nomorKartu; 

    public KartuKredit(String namaPembayar, double nominal, int nomorKartu) {
        super(namaPembayar, nominal); 
        this.nomorKartu = nomorKartu;
    }

    @Override
    public void prosesPembayaran() { 
        double admin = nominal * 0.02;
        double total = nominal + admin; 
        System.out.println("Biaya admin: " + admin);
        System.out.println("Total pembayaran dengan Kartu Kredit: " + (nominal + admin));
    }

    @Override
    public boolean autentikasi() { 
        System.out.println("Autentikasi PIN berhasil");
        return true; 
    }
}
