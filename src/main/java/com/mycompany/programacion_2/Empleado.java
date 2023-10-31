package com.mycompany.programacion_2;

import java.util.Scanner;

public class Empleado extends Persona {
    private float sueldo;
    
    public Empleado(Scanner scan) {
        super(scan);
        set_sueldo();
    }
    
    public final void set_sueldo() {
        System.out.println("Ingrese el sueldo del empleado: ");
        this.sueldo = scan.nextInt();
    }
    
    public float get_sueldo() {
        return sueldo;
    }
    
    @Override
    public void print() {
        System.out.println("dni: " + dni);
    }
}
