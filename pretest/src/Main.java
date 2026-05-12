public class Main {
    public static void main(String[] args) throws Exception {
        Programmer programmer1 = new Programmer("John Doe", 5000.0);
        System.out.println("Nama: " + programmer1.nama);
        System.out.println("Gaji: " + programmer1.hitungGaji());
    }
}
