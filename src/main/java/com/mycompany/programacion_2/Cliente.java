package com.mycompany.programacion_2;

public class Cliente {
    int dni;
    
    public void print() {
        System.out.println("dni: " + dni);
    }
    
    public boolean dni(int n) {
        if(n > 9999999 && n < 100000000) {
            dni = n;
            return true;
        }
        return false;
    }
    
    public int dni() {
        return dni;
    }
}
