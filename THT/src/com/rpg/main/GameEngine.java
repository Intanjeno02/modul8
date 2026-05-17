package com.rpg.main; // kelas utama untuk menjalankan game
import com.rpg.entitas.Monster; // mengimpor kelas Monster dari package com.rpg.entitas
import com.rpg.entitas.Pahlawan; // mengimpor kelas Pahlawan dari package com.rpg.entitas
import java.util.Scanner; // mengimpor kelas Scanner untuk membaca input dari pengguna
 
public class GameEngine { // kelas utama untuk menjalankan game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // membuat objek Scanner untuk membaca input dari pengguna

        System.out.print("Masukkan nama Pahlawanmu: "); // meminta pengguna untuk memasukkan nama pahlawan
        String namaPahlawan = scanner.nextLine(); // membaca nama pahlawan yang dimasukkan oleh pengguna
        Pahlawan pahlawan = new Pahlawan(namaPahlawan, 100, 15, 95, 4); // membuat objek Pahlawan dengan nama, hp, baseDamage, mana, dan level tertentu

        Monster[] gua = new Monster[] { // membuat array Monster yang berisi 3 monster yang akan dilawan oleh pahlawan
            new Monster("Go blind",      60,  12, "Goblin"), // data dummy
            new Monster("Orres",    100,  20, "Orc"),
            new Monster("drag eny",   160,  30, "Dragon")
        };

        for (int i = 0; i < gua.length; i++) { // loop untuk setiap monster di dalam array gua
            Monster monsterSaatIni = gua[i]; // mengambil monster saat ini dari array gua berdasarkan indeks i
            System.out.println(" PERTARUNGAN " + (i + 1) + " dari " + gua.length); // menampilkan informasi tentang pertarungan saat ini, termasuk nomor pertarungan dan total jumlah monster yang akan dilawan
            monsterSaatIni.tampilkanStatus(); // menampilkan status monster saat ini sebelum pertarungan dimulai
            pahlawan.tampilkanStatus(); // menampilkan status pahlawan sebelum pertarungan dimulai

            int pilihan; // variabel untuk menyimpan pilihan aksi
            int damageKePahlawan;
            int damageKeMonster;

            do { // loop selama hp pahlawan dan monster saat ini masih lebih besar dari 0, artinya pertarungan masih berlangsung
                System.out.println("Giliran " + pahlawan.getNama() ); // menampilkan giliran pahlawan untuk melakukan aksi
                System.out.println("  1. Serang Lawan");
                System.out.println("  2. Gunakan Skill (Mana: " + pahlawan.getMana() + ")");
                System.out.println("  3. Bertahan / Gunakan Item (Heal +30 HP)");
                System.out.print("Pilihan kamu (1/2/3): "); // pilihan aksi
                pilihan = scanner.nextInt(); // membaca pilihan aksi yang dimasukkan oleh pengguna

                if (pilihan < 1 || pilihan > 3) { // cek dulu sebelum lanjut
                System.out.println("maaf, pilihan tidak termasuk ke dalam list");
                }
            } while (pilihan < 1 || pilihan > 3); // loop berjalan kalo pilihan valid

                switch (pilihan) {
                    case 1:
                        damageKeMonster = pahlawan.serang();
                        monsterSaatIni.terimaDamage(damageKeMonster);
                        break;

                    case 2:
                        damageKeMonster = pahlawan.serang("Petir Sakti", 25);
                        if (damageKeMonster > 0) {
                            monsterSaatIni.terimaDamage(damageKeMonster);
                        }
                        break;

                    case 3:
                        pahlawan.bertahan();
                        pahlawan.gunakanItem();
                        break;

                    default:
                        System.out.println("  Pilihan tidak dikenali! Giliran dilewati.");
                        break;
                }

                if (monsterSaatIni.getHp() > 0) { // jika monster saat ini masih hidup setelah serangan pahlawan, maka monster akan menyerang balik
                    damageKePahlawan = monsterSaatIni.serang(); // monster menyerang pahlawan dan menghasilkan damage yang akan diterima oleh pahlawan
                    pahlawan.terimaDamage(damageKePahlawan); // pahlawan menerima damage dari serangan monster, yang akan mengurangi hp pahlawan sesuai dengan logika yang ada di metode terimaDamage
                }

                pahlawan.tampilkanStatus(); // menampilkan status pahlawan setelah aksi dilakukan
                if (monsterSaatIni.getHp() > 0) { // jika monster saat ini masih hidup, maka tampilkan status monster setelah aksi dilakukan
                    monsterSaatIni.tampilkanStatus();
                }
            

            if (pahlawan.getHp() <= 0) { // jika hp pahlawan sudah habis, maka pertarungan dihentikan dan game over
                break;
            }
        }
            
        if (pahlawan.getHp() > 0) { // jika hp pahlawan masih tersisa setelah melawan semua monster, maka tampilkan pesan bahwa pahlawan berhasil menamatkan dungeon
            System.out.println("-----------------------------------------");
            System.out.println("|        berhasil menamatkan DUNGEON      |");
            System.out.println("-----------------------------------------");
            System.out.println("  " + pahlawan.getNama() + " menamatkan Dungeon dengan HP tersisa: " + pahlawan.getHp());
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("|               GAME OVERR!!            |");
            System.out.println("-----------------------------------------");
            System.out.println("  " + pahlawan.getNama() + " telah dikalahkan di Dungeon");
        }

        scanner.close();
    }
}