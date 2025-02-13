import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner xd= new Scanner(System.in);
        ArrayList<Persona> lista= new ArrayList<>();
        // lista.add(new Persona("Pablo", 4));
        // lista.add(new Persona("Maria", 5));
        // lista.add(new Persona("Juan", 18));
        // lista.add(new Persona("David", 60));
        // lista.add(new Persona("Mateo", 25));
        // lista.add(new Persona("Diego",12));
        // lista.add(new Persona("Ana", 8));
        // lista.add(new Persona("Alicia", 9));
        // lista.add(new Persona("Jaime", 40));

        int cantidad;
        do {
            System.out.print("Ingrese cantidad de personas (mayor que 0): ");
            cantidad = xd.nextInt();
            if (cantidad <= 0) {
                System.out.println("Número inválido. Por favor, ingrese un número mayor que 0.");
            }
        } while (cantidad <= 0);

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Agregue persona "+(i+1)+" :");
            System.out.print("Nombre: ");
            String nombre= xd.next();
            int edad;
            do {
                System.out.print("Ingrese la edad (mayor que 0): ");
                edad = xd.nextInt();
                if (edad <= 0) {
                    System.out.println("Edad inválida. Por favor, ingrese una edad mayor que 0.");
                }
            } while (edad <= 0); 

            Persona p= new Persona(nombre, edad);
            lista.add(p);
        }
        System.out.println("\nLista de personas ingresada: ");
        for (Persona p : lista) {
            System.out.print(p);
        }

        MetodoBus b= new MetodoBus();
        b.insercionAsc(lista);

        System.out.println("\n\nLista de personas ordenada: ");
        for (Persona p : lista) {
            System.out.print(p);
        }

        System.out.println("\n\nPersona que desea encontrar: ");
        int bus= xd.nextInt();

        int cond = b.busquedaBinaria(lista, bus);

        if (cond != -1) {
            System.out.println("ENCONTRADO: " + lista.get(cond));
        } else {
            System.out.println("Persona no encontrada.");
        }

        System.out.println("\nLa persona con la edad "+bus+" es: "+lista.get(cond).getNombre());

        xd.close();
    }
}
