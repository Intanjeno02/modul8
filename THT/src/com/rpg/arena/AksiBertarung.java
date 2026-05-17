package com.rpg.arena;
 
public interface AksiBertarung { // Interface untuk aksi bertarung
    int serang(); // metode untuk nyerang, ngembaliin jumlah damage yang diberikan
    void bertahan(); // metode untuk bertahan, mngurangin damage yang diterima
    void gunakanItem(); // metode untuk menggunakan item
}