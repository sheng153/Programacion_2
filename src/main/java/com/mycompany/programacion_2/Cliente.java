package com.mycompany.programacion_2;

import java.util.Scanner;

public class Cliente extends Persona {
    
    public Cliente(Scanner scan) {
        super(scan);
        
    }
    
    @Override
    public void print() {
        System.out.println("\tdni: " + dni);
    }
}
