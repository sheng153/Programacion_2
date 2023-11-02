package com.mycompany.programacion_2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Persona {
    private final List<Transaccion> compras;
    
    public Cliente(Scanner scan) {
        super(scan);
        compras = new ArrayList();
    }
    
    public void add_transaction() {
        compras.add(new Transaccion(scan));
    }
    
    @Override
    public void print() {
        System.out.println("\tdni: " + dni);
        System.out.println("\tNombre: " + nombre);
        System.out.println("\tApellido: " + apellido);
        for(Transaccion t: compras) {
            t.print();
        }
    }
}

class Transaccion {
    enum ModoDePago {
        NONE("ERROR"),
        EFECTIVO("Efectivo"),
        TARJETA("Tarjeta"),
        TRANSFERENCIA("Transferencia"),
        BILLETERA_VIRTUAL("Billetera Virtual");
        
        private final String print;
        
        ModoDePago(String print) {
            this.print = print;
        }
        
        public static ModoDePago new_instance(int in) {
            ModoDePago ret;
            switch(in) {
                case 1:
                    ret = ModoDePago.EFECTIVO;
                    break;
                case 2:
                    ret = ModoDePago.TARJETA;
                    break;
                case 3:
                    ret = ModoDePago.TRANSFERENCIA;
                    break;
                case 4:
                    ret = ModoDePago.BILLETERA_VIRTUAL;
                    break;
                default:
                    ret = ModoDePago.NONE;
                    break;
            }
            return ret;
        }
        
        public String print() {
            return print;
        }
    }
    
    static int op;
    private final int numero_de_registro;
    private final String producto;
    private final ModoDePago modo;
    private final int precio;
    
    public int registro() { return numero_de_registro; }
    public String producto() { return producto; }
    public String modo() { return modo.print(); }
    public int precio() { return precio; }
    
    public void print() {
        System.out.println("\tNumero de registro: " + numero_de_registro);
        System.out.println("\t\tProducto comprado: " + producto);
        System.out.println("\t\tPrecio del producto: $" + precio);
        System.out.println("\t\tModo de pago: " + modo.print());
    }
    
    public Transaccion(Scanner scan) {
        op += 1;
        this.numero_de_registro = op;
        System.out.println("Indique el producto comprado:");
        producto = scan.nextLine();
        System.out.println("Indique el precio del producto:");
        precio = scan.nextInt();
        scan.nextLine();
        int option;
        while(true) {
            System.out.println("Indique el modo de pago:");
            System.out.println("1. Efectivo");
            System.out.println("2. Tarjeta");
            System.out.println("3. Transferencia");
            System.out.println("4. Billetera virtual");
            option = scan.nextInt();
            scan.nextLine();
            if(option > 0 && option < 5) {
                break;
            }
            System.out.println("Ingrese un valor valido");
        }
        modo = ModoDePago.new_instance(option);
    }
}