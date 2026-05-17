package com.rpg.entitas; // kelas untuk pahlawan yang mewarisi dari Karakter

import com.rpg.arena.Karakter; // mengimpor kelas Karakter dari package com.rpg.arena

public class Pahlawan extends Karakter { // kelas untuk pahlawan yang mewarisi dari Karakter
    private double mana; // atribut khusus untuk pahlawan
    private int level;

    public Pahlawan(String nama, int hp, int baseDamage, double mana, int level) { // constructor untuk pahlawan
        super(nama, hp, baseDamage);
        this.mana = mana;
        this.level = level;
    }

    public double getMana() {
    return mana; // getter buat mana
    }

    public int getLevel() {
    return level; // getter buat level
    }

    @Override
    public int serang() { // implementasi metode serang untuk pahlawan
        int damage = baseDamage * level; // pahlawan memberikan damage sesuai dengan baseDamage dikalikan level saat ini
        return damage; // mengembalikan nilai damage yang diberikan
    }

    public int serang(String namaSkill, int manaCost) { // metode serang dengan skill khusus yang membutuhkan mana
        if (mana >= manaCost) { // cek apakah mana cukup untuk menggunakan skill
            mana = mana - manaCost; // mengurangi mana dengan biaya mana yang diperlukan untuk skill
            int damage = baseDamage * level * 2; // skill memberikan damage yang lebih besar, misalnya 2 kali baseDamage dikalikan level
            return damage;
        } else {
            System.out.println("Mana tidak cukup"); // jika mana tidak cukup, skill tidak bisa digunakan dan memberikan pesan kalo mana tidak cukup
            return 0; // mengembalikan 0 damage 
        }
    }

    @Override
    public void bertahan() { // implementasi metode bertahan untuk pahlawan
        isDefending = true; // mengubah status isDefending menjadi true
        System.out.println("Pahlawan bersiaga");
    }

    @Override // wajib override karena menggunakan interface AksiBertarung dan abstrak dari Karakter
    public void gunakanItem() {
    hp = hp + 30; // nambah hp 30
    System.out.println(nama + " minum potion, hp sekarang: " + hp);
    }

    @Override
    public void tampilkanStatus() {
        System.out.println("Nama: " + nama + ", Hp: " + hp + ", Mana: " + mana + ", Level: " + level);
    }
}

