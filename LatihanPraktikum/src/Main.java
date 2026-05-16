import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        KartuKredit kartuy = new KartuKredit("senjana", 2000000, 123456789); 
        EWallet Walet = new EWallet("tata", 300000, "GoPay", "08123456789"); 

        ArrayList<Pembayaran> daftarPembayaran = new ArrayList<>(); 
        daftarPembayaran.add(kartuy); 
        daftarPembayaran.add(Walet); 

        for (Pembayaran pembayaran : daftarPembayaran) { 
            pembayaran.tampilkanDetail(); 
            if (pembayaran instanceof Keamanan) { 
                pembayaran.prosesPembayaran(); 
                ((Keamanan) pembayaran).autentikasi(); 
            }
        }
    }
}
