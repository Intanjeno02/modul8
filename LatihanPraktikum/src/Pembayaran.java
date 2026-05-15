public abstract class Pembayaran { //kelas abstrak Pembayaran yang mendefinisikan atribut dan metode untuk pembayaran
    protected String namaPembayar; //atribut untuk nama pembayar
    protected double nominal;

    public Pembayaran (String namaPembayar, double nominal) { //konstruktor untuk menginisialisasi nama pembayar dan nominal
    this.namaPembayar = namaPembayar; //inisialisasi nama pembayar
    this.nominal = nominal;
}

    public void tampilkanDetail() { //metode untuk menampilkan detail pembayaran
        System.out.println("Nama Pembayar: " + namaPembayar); //menampilkan nama pembayar
        System.out.println("Nominal Transaksi: " + nominal); //menampilkan nominal transaksi
    }

    public abstract void prosesPembayaran(); //metode abstrak untuk memproses pembayaran yang harus diimplementasikan oleh kelas turunan
}

