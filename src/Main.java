import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        AddressBook directorio = new AddressBook();
        directorio.load();

        int opc = 0;
        do {
            System.out.println("Elige una opcion: ");
            System.out.println();
            System.out.println("1. Listar contactos");
            System.out.println("2. Aggregar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Editar contacto");
            System.out.println();
            System.out.print("Opcion: ");
            opc = Integer.parseInt(directorio.teclado.nextLine());

            switch (opc) {
                default:
                    System.out.println("Opcion invalida");
                    break;
                case 0:
                    break;
                case 1:
                    directorio.list();
                    break;
                case 2:
                    directorio.create();
                    break;
                case 3:
                    directorio.delete();
                    break;
                case 4:
                    break;
            }
        } while (opc != 0);
        directorio.save();
    }

    static class AddressBook {
        public Map<String, String> contactos = new HashMap<>();
        Scanner teclado = new Scanner(System.in);

        AddressBook() {
            contactos.put("222345187", "Juan Perez");
            contactos.put("777562149", "Marcela Gomez");
            contactos.put("557562111", "Castañon Garcia");
            contactos.put("817563510", "Fernanda Ortiz");
            contactos.put("907569875", "Laura Jimenez");
        }

        public void load() {
            try (BufferedReader buffer = Files.newBufferedReader(Paths.get("contactos.csv"))) {
                String line;
                while ((line = buffer.readLine()) != null) {
                    String[] kv = line.split(",");
                    contactos.put(kv[0], kv[1]);
                }
            } catch (NoSuchFileException e) {
            } catch (IOException e) {
                System.out.println("No se pudo cargar el archivo de contactos");
            }
        }

        public void save() {
            try {
                FileWriter fileWriter = new FileWriter("contactos.cvs");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                contactos.forEach((k,v) -> printWriter.println(String.format("%s,%s", k, v)));
                printWriter.close();
            } catch (IOException e){

            }
        }

        /**
         * list: mostrar los contactos de la agenda.
         */
        public void list() {
            System.out.println("Contactos:");
            contactos.forEach((numero, nombre) -> System.out.printf("{%s}:{%s}%n", numero, nombre));
        }

        public void create() {
            try {
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();
                System.out.print("Numero: ");
                String numero = teclado.nextLine();

                //Si el usuarion ingresa un telefono invalido muestra error y no guarda el contacto
                if (numero.matches("\\d{10}")) {
                    contactos.put(numero, nombre);
                    System.out.println("Se guardó el contacto!");
                    return;
                }

                System.out.println("Número de telefono es inválido. No se guardó el contacto.");
            } catch (Exception e) {
                System.out.println("Error al realiza la operacion");
                System.out.println("oprime <<Enter>> tecla para seguir");
                teclado.nextLine();
            }
        }

        public void delete() {
            System.out.print("Numero: ");
            String numero = teclado.nextLine();

            //Si el usuarion ingresa un telefono invalido muestra error y no guarda el contacto
            if (numero.matches("\\d{10}")) {
                contactos.remove(numero);
                System.out.println("Se guardó el contacto!");
                return;
            }

            System.out.println("Número de telefono es inválido. No se elimino el contacto.");
        }

        public void update() {
            System.out.println("Ingresa los datos del contacto");
            delete();
            System.out.println("Ingresa los datos nuevos del contacto");
            create();
        }
    }
}