package com.rpg.arena;

public abstract class Karakter implements AksiBertarung { // kelas abstrak untuk karakter umum

    protected String nama; //encapsulation
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;

    public Karakter(String nama, int hp, int baseDamage) { // constructor
        this.nama = nama; 
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false; // diatur secara default ke false
    }

    //getter dan setter untuk atribut
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
    this.nama = nama;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }

    public void terimaDamage(int damage) { //logika percabangan
        if (isDefending) { // jika isDefending bernilai true
            damage = damage / 2; //damagenya bakal ngurangin setengah hp
            isDefending = false; // setelah bertahan, isDefending direset ke false
        }
        hp = hp - damage; // hp dikurangi dengan damage yang diterima
        if (hp < 0) {
            hp = 0;
        }
    }

    public abstract void tampilkanStatus(); // metode abstrak untuk menampilkan status karakter
}