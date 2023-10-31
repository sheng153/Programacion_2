package com.mycompany.programacion_2;

import java.util.Scanner;

public class Empleado extends Persona {
    
    public Empleado(Scanner scan) {
        super(scan);
        
    }
    
    @Override
    public void print() {
        System.out.println("dni: " + dni);
    }
}
