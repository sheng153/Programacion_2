package com.mycompany.programacion_2;

import java.util.Scanner;

public class Empleado extends Persona {
    enum Charge {
        NONE(true, "ERROR"),
        CEO(true, "CEO"),
        PRESIDENTE(true, "Presidente"),
        VICEPRESIDENTE(true, "Vicepresidente"),
        JEFE_DE_DEPARTAMENTO(false, "Jefe de departamento"),
        GERENTE(false, "Gerente"),
        SUPERVISOR(false, "Supervisor"),
        EMPLEADO(false, "Empleado");
        
        private final boolean general;
        private final String print;
        
        Charge(boolean general, String print) {
            this.general = general;
            this.print = print;
        }
        
        public boolean is_general() { return general; }
        public String print() { return print; }
        
        public static Charge new_charge(int index) {
            Charge c;
            switch(index) {
                case 1: c = Charge.CEO;
                    break;
                case 2: c = Charge.PRESIDENTE;
                    break;
                case 3: c = Charge.VICEPRESIDENTE;
                    break;
                case 4: c = Charge.JEFE_DE_DEPARTAMENTO;
                    break;
                case 5: c = Charge.GERENTE;
                    break;
                case 6: c = Charge.SUPERVISOR;
                    break;
                case 7: c = Charge.EMPLEADO;
                    break;
                default:
                    c = Charge.NONE;
                    break;
            }
            return c;
        }
    }
    enum Sector {
        NONE(-1, "ERROR"),
        GENERAL(0, "General"),
        SISTEMAS(1, "Sistemas"),
        ADMINISTRACION(2, "Administracion"),
        PRODUCCION(3, "Produccion"),
        CAPITAL_HUMANO(4, "Capital humano");
        
        public final int value;
        private final String printer;
        
        Sector(int index, String print) {
            this.value = index;
            this.printer = print;
        }
        
        public String print() { return this.printer; }
        
        public static Sector new_sector(int index) {
            Sector s;
            switch(index) {
                case 1: s = Sector.ADMINISTRACION;
                    break;
                case 2: s = Sector.SISTEMAS;
                    break;
                case 3: s = Sector.PRODUCCION;
                    break;
                case 4: s = Sector.CAPITAL_HUMANO;
                    break;
                default:
                    s = Sector.NONE;
                    break;
            }
            return s;
        }
    }
    private float sueldo;
    private Charge posicion;
    private Sector sector;
    
    public Empleado(Scanner scan) {
        super(scan);
        set_sueldo();
        set_position();
        if(!posicion.is_general()) {
            set_sector();
        }else{
            this.sector = Sector.GENERAL;
        }
    }
    
    public final void set_sueldo() {
        System.out.println("Ingrese el sueldo del empleado: ");
        this.sueldo = scan.nextInt();
        scan.nextLine();
    }
    
    public final void set_position() {
        int option;
        while (true) {
            System.out.println("Ingrese el cargo del empleado: ");
            System.out.println("1. CEO");
            System.out.println("2. Presidente");
            System.out.println("3. Vicepresidente");
            System.out.println("4. Jefe de Departamento");
            System.out.println("5. Gerente");
            System.out.println("6. Supervisor");
            System.out.println("7. Empleado");
            option = scan.nextInt();
            scan.nextLine();
            if(option > 0 && option < 8) {
                break;
            }
            System.out.println("Ingrese un valor válido.");
        }
        this.posicion = Charge.new_charge(option);
    }
    
    public final void set_sector() {
        int option;
        while (true) {
            System.out.println("Ingrese el sector del empleado: ");
            System.out.println("1. Administración");
            System.out.println("2. Sistemas");
            System.out.println("3. Producción");
            System.out.println("4. Capital humano");
            option = scan.nextInt();
            scan.nextLine();
            if(option > 0 && option < 5) {
                break;
            }
            System.out.println("Ingrese un valor válido.");
        }
        this.sector = Sector.new_sector(option);
    }
    
    public float get_sueldo() {
        return sueldo;
    }
    
    public String get_sector() {
        return this.sector.print();
    }
    
    public String get_charge() {
        return this.posicion.print();
    }
    
    @Override
    public void print() {
        System.out.println("\tdni: " + dni);
        System.out.println("\tNombre: " + nombre);
        System.out.println("\tApellido: " + apellido);
        System.out.println("\tSueldo: " + sueldo);
        System.out.println("\tcargo: " + get_charge());
        System.out.println("\tsector: " + get_sector());
    }
}
