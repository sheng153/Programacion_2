package com.mycompany.programacion_2;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public final class Menu {
    private static Menu check;
    private ActualMenu state;
    private Scanner scan;
    private Register clientes;
    private Register empleados;
    
    private Menu() {
        scan = new Scanner(System.in);
        clientes = new Register(true);
        empleados = new Register(false);
        loop: while(true){
            state = ActualMenu.MAIN;
            set_options();
            switch(get_option()) {
                case 1 -> {
                    state = ActualMenu.CLIENT;
                    managing_menu();
                    continue;
                }
                case 2 -> {
                    state = ActualMenu.EMPLOYEE;
                    managing_menu();
                    continue;
                }
                case 3 -> {
                    break loop;
                }
            }
            break;
        }
    }
    
    private void managing_menu() {
        Register r = (state.is_client())? clientes : empleados;
        loop: while(true){
            set_options();
            cases: switch(get_option()) {
                case 1 -> {
                    r.add(scan);
                    continue;
                }
                case 2 -> {
                    r.remove(scan);
                    continue;
                }
                case 3 -> {
                    r.print_list();
                    continue;
                }
                case 4 -> {
                    break;
                }
            }
        break;
        }
    }
    
    private void set_options() {
        switch(state) {
            case MAIN:
                System.out.println("Menu");
                System.out.println("1. Registro de clientes.");
                System.out.println("2. Registro de empleados.");
                System.out.println("3. Salir");
                break;
            case CLIENT:
                System.out.println("Clientes");
                System.out.println("1. Cargar cliente.");
                System.out.println("2. Eliminar cliente.");
                System.out.println("3. Mostrar registro.");
                System.out.println("4. Salir");
                break;
            case EMPLOYEE:
                System.out.println("Empleados");
                System.out.println("1. Cargar empleados.");
                System.out.println("2. Eliminar empleados.");
                System.out.println("3. Mostrar registro.");
                System.out.println("4. Salir");
                break;
        }
    }
    
    private int get_option() {
        return scan.nextInt();
    }
    
    public static Menu set_menu() {
        if (check == null) {
            check = new Menu();
        }
        return check;
    }
}

enum ActualMenu {
    MAIN,
    CLIENT(true),
    EMPLOYEE(false);
    
    private boolean is_client;
    
    private ActualMenu() {}
    private ActualMenu(boolean is_client) {
        this.is_client = is_client;
    }
    
    public boolean is_client() { return is_client; }
    public boolean is_employee() { return !is_client; }
}

class Register {
    enum Type {
        CLIENTE(true),
        EMPLEADO(false);
        
        private final boolean is_client;
        
        Type(boolean is_client) {
            this.is_client = is_client;
        }
        
        public static Type new_category(boolean is_client) {
            return (is_client)? Type.CLIENTE : Type.EMPLEADO;
        }
        
        public boolean is_client() { return is_client; }
    }
    private final Type categoria;
    private final List<Persona> list;
    private int index;
    
    public Register(boolean is_client) {
        categoria = Type.new_category(is_client);
        list = new ArrayList();
        index = 0;
    }
    
    public void add(Scanner scan) {
        Persona p = (categoria == Type.CLIENTE)? 
                new Cliente(scan) :
                new Empleado(scan);
        list.add(p);
    }
    
    public void remove(Scanner scan) {
        int n;
        while (true) {
            System.out.println("Ingrese el dni a eliminar (0 para volver al menu): ");
            n = scan.nextInt();
            if (remove_from_list(n) || n == 0) { break; }
            System.out.println("Numero no existente en la base de datos.");
        }
    }
    
    public void print_list() {
        if (list.isEmpty()) { return; }
        list.get(index).print();
        index++;
        if (index < list.size()) {
            print_list();
        }
        index = 0;
    }
    
    private boolean remove_from_list(int dni) {
        index = 0;
        boolean ret = false;
        while(index < list.size()) {
            if (list.get(index).dni() == dni) {
                list.remove(index);
                ret = true;
            }
            index++;
        }
        index = 0;
        return ret;
    }
}
