package com.mycompany.programacion_2;

import java.util.Scanner;

public abstract class Persona {
    protected int dni;
    protected String nombre;
    protected String apellido;
    protected final Scanner scan;
    
    public abstract void print();
    
    protected Persona(Scanner scan) {
        this.scan = scan;
        set_dni();
        set_name();
        set_last_name();
    }
    
    public final void set_dni() {
        int tdni;
        while(true) {
            System.out.println("Ingrese el DNI: ");
            tdni = scan.nextInt();
            if (tdni > 9999999 && tdni < 100000000) { this.dni = tdni; break; }
            System.out.println("Ingrese un documento valido.");
        }
    }
    
    public final void set_name() {
        System.out.println("Ingrese el nombre: ");
        nombre = scan.nextLine();
    }
    
    public final void set_last_name() {
        System.out.println("Ingrese el apellido: ");
        apellido = scan.nextLine();
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
