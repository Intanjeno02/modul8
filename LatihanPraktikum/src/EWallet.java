public class EWallet extends Pembayaran implements Keamanan { //kelas EWallet yang mengimplementasikan interface Pembayaran dan Keamanan
    private String nomorHP;

    public EWallet(String namaPembayar, double nominal, String namaEWallet, String nomorHP) {
        super(namaPembayar, nominal); 
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran() { 
        System.out.println("Total tagihan: " + nominal); 
    }

    @Override
    public boolean autentikasi() { 
        System.out.println("Autentikasi berhasil " );
        return true; 
    }
    
}
