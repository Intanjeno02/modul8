public class Main {
    public static void main(String[] args) {
        PengirimanDarat darat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        darat.updateStatus("Sedang di jalan tol Cipali");

        PengirimanUdara udara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");

        LayananPengiriman[] armada = { darat, udara };
        for (LayananPengiriman layanan : armada) {
            System.out.println("=======================================================");
            layanan.cetakResi();
            System.out.println("-------------------------------------------------------");

            if (layanan instanceof LacakKargo lacakKargo) {
                System.out.println("  Lokasi Terakhir : " + lacakKargo.cekLokasiTerakhir());
            }
            double ongkosKirim = layanan.hitungOngkosKirim();
            System.out.println("  Ongkos Kirim    : Rp " + ongkosKirim);
            double totalTagihan = ongkosKirim;

            if (layanan instanceof Asuransi asuransi) {
                System.out.println("-------------------------------------------------------");
                asuransi.cetakPolis();
                double nilaiBarang = ((PengirimanUdara) layanan).nilaiBarang;
                double premi = asuransi.hitungPremi(nilaiBarang);
                System.out.println("  Premi Asuransi  : Rp " + premi + " (3% dari nilai barang Rp " + nilaiBarang + ")");
                totalTagihan += premi;
            }

            System.out.println("-------------------------------------------------------");
            System.out.println("  TOTAL TAGIHAN   : Rp " + totalTagihan);
        }

        System.out.println("=======================================================");
    }
}