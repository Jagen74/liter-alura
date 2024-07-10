package com.aluracursos.literalura.principal;

import java.util.Scanner;

public class MenuPrincipal {
    public void menu(){
        System.out.println("""
                《Bienvenido a LiterAlura》                
                ⬇ Selecciona una opcion ⬇
                1. Buscar Libro.
                2. Listar Libros registrados.
                3. Listar autores registrados
                4. Listar autores vivos en un determinado año.
                5. Listar libros por idioma
                
                0. Salir.
                """);

    }

    public void selectOption () {
        menu();
        Scanner kb = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            menu();
            try {
                System.out.print("Seleccione una opción: ");
                option = kb.nextInt();

                switch (option) {
                    case 1:
                        Principal principal = new Principal();
                        principal.muestraMenu();
                        break;
                    case 2:
                        System.out.println("En construcción...");
                        break;
                    case 3:
                        System.out.println("En construcción...");
                        break;
                    case 4:
                        System.out.println("En construcción...");
                        break;
                    case 5:
                        System.out.println("En construcción...");
                        break;

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción Inválida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error! Número no válido");
                kb.nextLine();
            }
        }
        kb.close();
    }
}
