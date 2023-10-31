package com.mycompany.programacion_2;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public final class Menu {
    private static Menu check;
    private Scanner scan;
    private ClientRegister clientes;
    
    private Menu() {
        scan = new Scanner(System.in);
        clientes = new ClientRegister();
        loop: while(true){
            set_options();
            switch(get_option()) {
                case 1 -> {
                    clientes.add_client(scan);
                    continue;
                }
                case 2 -> {
                    clientes.remove_client(scan);
                    continue;
                }
                case 3 -> {
                    clientes.print_list();
                    continue;
                }
                case 4 -> {
                    break loop;
                }
            }
            break;
        }
    }
    
    private void set_options() {
        System.out.println("MENU");
        System.out.println("1. Cargar cliente.");
        System.out.println("2. Eliminar cliente.");
        System.out.println("3. Mostrar registro.");
        System.out.println("4. Salir");
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

class ClientRegister {
    private final List<Cliente> clientes;
    private int index;
    
    public ClientRegister() {
        clientes = new ArrayList();
        index = 0;
    }
    
    public void add_client(Scanner scan) {
        Cliente c = new Cliente();
        while (true) {
            System.out.println("Ingrese el dni del cliente: ");
            if (c.dni(scan.nextInt())) { break; }
        }
        clientes.add(c);
    }
    
    public void remove_client(Scanner scan) {
        int n;
        while (true) {
            System.out.println("Ingrese el dni del cliente a eliminar (0 para volver al menu): ");
            n = scan.nextInt();
            if (remove_from_list(n) || n == 0) { break; }
            System.out.println("Numero no existente en la base de datos.");
        }
    }
    
    public void print_list() {
        if (clientes.isEmpty()) { return; }
        clientes.get(index).print();
        index++;
        if (index < clientes.size()) {
            print_list();
        }
        index = 0;
    }
    
    private boolean remove_from_list(int dni) {
        index = 0;
        boolean ret = false;
        while(index < clientes.size()) {
            if (clientes.get(index).dni() == dni) {
                clientes.remove(index);
                ret = true;
            }
            index++;
        }
        index = 0;
        return ret;
    }
}
