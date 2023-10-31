package com.mycompany.programacion_2;

import java.util.Scanner;

public abstract class Persona {
    int dni;
    
    public abstract void print();
    
    protected Persona(Scanner scan) {
        int tdni;
        while(true) {
            System.out.println("Ingrese el DNI: ");
            tdni = scan.nextInt();
            if (tdni > 9999999 && tdni < 10000000) { this.dni = tdni; break; }
            System.out.println("Ingrese un documento valido.");
        }
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
