import java.util.Scanner;

public class PrincipalRadio {
    public static void main(String[] args) throws Exception {
        
        Radio miRadio = new Radio();
        Scanner teclado = new Scanner(System.in);

        String frecuencia;
        boolean ejecucion = true;
        String opcion;
        int espacioGuardado;

        System.out.println("\nEncendiendo...");
        miRadio.on();
        System.out.println("\n----------LA SUPER RADIO----------\n");
        System.out.println("Elija la frecuencia que quiere escuchar: (AM/FM)");
        frecuencia = teclado.nextLine();
        miRadio.setFrequence(frecuencia);
        
        while (ejecucion){
            if (miRadio.getFrequence() == "AM"){
                System.out.println("\nFrecuencia: " + miRadio.getFrequence() + "\nEmisora: " + miRadio.getAMActualStation());
            } else {
                System.out.println("\nFrecuencia: " + miRadio.getFrequence() + "\nEmisora: " + miRadio.getFMActualStation());
            }

            System.out.println("\nOpciones:\n1: Cambiar frecuencia\n2: Avanzar emisora\n3: Retroceder Emisora\n4: Guardar emisora\n5: Cargar emisora\n6: Apagar radio");
            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    if (miRadio.getFrequence() == "AM"){
                        miRadio.setFrequence("FM");
                    } else {
                        miRadio.setFrequence("AM");
                    }
                    break;
                case "2":
                    miRadio.Forward();
                    break;
                case "3":
                    miRadio.Backward();
                    break;
                case "4":
                    System.out.println("En qué espacio va a guardar la emisora: (1-12)");
                    try {
                        espacioGuardado = teclado.nextInt();
                        teclado.nextLine();
                        if (miRadio.getFrequence() == "AM"){
                            miRadio.saveAMStation(miRadio.getAMActualStation(), espacioGuardado-1);
                            System.out.println("Guardado exitoso");
                        } else {
                            miRadio.saveFMStation(miRadio.getFMActualStation(), espacioGuardado-1);
                            System.out.println("Guardado exitoso");
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        teclado.nextLine();
                        System.out.println("El espacio ingresado es inválido");
                    }
                    break;
                case "5":
                    System.out.println("Ingrese el espacio de emisora que quiere cargar: (1-12)");
                    try {
                        espacioGuardado = teclado.nextInt();
                        teclado.nextLine();
                        if (miRadio.getFrequence() == "AM"){
                            System.out.println("Se ha cargado la emisora: " + miRadio.getAMSlot(espacioGuardado));
                        } else {
                            System.out.println("Se ha cargado la emisora: " + miRadio.getFMSlot(espacioGuardado));
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        teclado.nextLine();
                        System.out.println("El espacio ingresado es inválido");
                    }
                    break;
                case "6":
                    ejecucion = false;
                    System.out.println("\nApagando...");
                    break;

                default:
                    break;
            }
        }
        
    }
}