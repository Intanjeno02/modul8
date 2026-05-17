package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Monster extends Karakter { // kelas untuk monster yang mewarisi dari Karakter

    private String jenisMonster; // atribut khusus untuk monster

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) { // constructor untuk monster
        super(nama, hp, baseDamage); // memanggil constructor dari kelas induk (Karakter)
        this.jenisMonster = jenisMonster;
    }
    
    // getter dan setter untuk jenisMonster
    public String getJenisMonster() {
        return jenisMonster;
    }

    public void setJenisMonster(String jenisMonster) {
        this.jenisMonster = jenisMonster;
    }

    @Override
    public int serang() { // implementasi metode serang untuk monster
        int damage = baseDamage; // monster memberikan damage sesuai dengan baseDamage
        return baseDamage; // mengembalikan nilai damage yang diberikan
    }

    @Override
    public void bertahan() { // implementasi metode bertahan untuk monster
        int pulih = 15; // monster bisa pulih 15 HP saat bertahan
        hp = hp + pulih; // hp monster bertambah saat bertahan
    }

    @Override // wajib override karena menggunakan interface AksiBertarung dan abstrak dari Karakter
    public void gunakanItem() {
    hp = hp + 20; // monster pulih 20 hp
    }

    @Override // override untuk menampilkan status monster, termasuk jenis monster
    public void tampilkanStatus() {
    System.out.println("Nama: " + nama + ", Hp: " + hp + ", Jenis: " + jenisMonster);
    }
}