
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author garrido
 */
public class HeroesOfVannaria {

    private ArrayList<Personaje> personajes;
    private ArrayList<Arma> armas;
    private Scanner in;
    private int[] nivels = {100, 200, 500, 1000, 2000};

    public HeroesOfVannaria() {
        in = new Scanner(System.in);
        personajes = new ArrayList();
        armas = new ArrayList();
        crearArmas();
    }

    private void crearArmas() {
        armas.add(new Arma("Daga", 5, 15));
        armas.add(new Arma("Espada", 10, 10));
        armas.add(new Arma("Martillo", 15, 5));
    }

    /**
     * Método que leerá los datos de los personajes desde un archivo csv
     */
    public void leerDatos(String nomArxiu) {

        Path path = Paths.get(nomArxiu);
        try {
            BufferedReader in = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            String linea = in.readLine(); //línea plantilla
            linea = in.readLine();
            while (linea != null) {
                String[] dades = linea.split(";");
                Arma arma = new Arma();
                if (dades[9].equalsIgnoreCase("Daga")) {
                    arma = armas.get(0);
                } else if (dades[9].equalsIgnoreCase("Espada")) {
                    arma = armas.get(1);
                } else if (dades[9].equals("Martillo")) {
                    arma = armas.get(2);
                }
                
                switch(dades[1]){
            case "Guerrero": 
                if(dades[10].equals("Orden")){
                     GuerreroOrden personaje = new GuerreroOrden(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]),
                        Integer.parseInt(dades[4]), Integer.parseInt(dades[5]), Integer.parseInt(dades[6]),
                        Integer.parseInt(dades[7]), Integer.parseInt(dades[8]), arma, dades[10]);
                      personajes.add(personaje);
                }else{
                    GuerreroCaos personaje = new GuerreroCaos(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]),
                        Integer.parseInt(dades[4]), Integer.parseInt(dades[5]), Integer.parseInt(dades[6]),
                        Integer.parseInt(dades[7]), Integer.parseInt(dades[8]), arma, dades[10]);
                     personajes.add(personaje);
                }
                break;
            case "Caballero": 
                if(dades[10].equals("Orden")){
                    CaballeroOrden personaje = new CaballeroOrden(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]),
                        Integer.parseInt(dades[4]), Integer.parseInt(dades[5]), Integer.parseInt(dades[6]),
                        Integer.parseInt(dades[7]), Integer.parseInt(dades[8]), arma, dades[10]);
                     personajes.add(personaje);
                }else{
                    CaballeroCaos personaje = new CaballeroCaos(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]),
                        Integer.parseInt(dades[4]), Integer.parseInt(dades[5]), Integer.parseInt(dades[6]),
                        Integer.parseInt(dades[7]), Integer.parseInt(dades[8]), arma, dades[10]);
                     personajes.add(personaje);
                }
                break;
            case "Valquiria": 
                if(dades[10].equals("Orden")){
                    ValquiriaOrden personaje = new ValquiriaOrden(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]),
                        Integer.parseInt(dades[4]), Integer.parseInt(dades[5]), Integer.parseInt(dades[6]),
                        Integer.parseInt(dades[7]), Integer.parseInt(dades[8]), arma, dades[10]);
                     personajes.add(personaje);
                }else{
                     ValquiriaCaos personaje = new ValquiriaCaos(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]),
                        Integer.parseInt(dades[4]), Integer.parseInt(dades[5]), Integer.parseInt(dades[6]),
                        Integer.parseInt(dades[7]), Integer.parseInt(dades[8]), arma, dades[10]);
                     personajes.add(personaje);
                }
                break;
            case "Asesino": 
                if(dades[10].equals("Orden")){
                    AsesinoOrden personaje = new AsesinoOrden(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]),
                        Integer.parseInt(dades[4]), Integer.parseInt(dades[5]), Integer.parseInt(dades[6]),
                        Integer.parseInt(dades[7]), Integer.parseInt(dades[8]), arma, dades[10]);
                     personajes.add(personaje);
                }else{
                     AsesinoCaos personaje = new AsesinoCaos(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]),
                        Integer.parseInt(dades[4]), Integer.parseInt(dades[5]), Integer.parseInt(dades[6]),
                        Integer.parseInt(dades[7]), Integer.parseInt(dades[8]), arma, dades[10]);
                     personajes.add(personaje);
                }
                break;
        }
                linea = in.readLine();
            }
        } catch (IOException ex) {
            System.out.println("No se ha podido abrir el archivo: " + nomArxiu);
        }
    }

    /**
     * Método que muestra menú con diferentes opciones hasta que el usuario
     * escoge "salir"
     */
    public void jugar() {
        boolean salir = false;
        while (!salir) {
            switch (mostraMenu()) {
                case "1":
                    //Tools.netejaPantalla();
                    crearPersonaje();
                    //Tools.pausaFinsTecla();
                    break;
                case "2":
                    //Tools.netejaPantalla();
                    mostrarArrayPersonajes(personajes);
                    //Tools.pausaFinsTecla();
                    break;
                case "3":
                    //Tools.netejaPantalla();
                    combate();
                    //Tools.pausaFinsTecla();
                    break;
                case "x":
                case "X":
                    System.out.println("Fin de la partida...");
                    salir = true;
                    break;
                case "4":
                    //Tools.netejaPantalla();
                    modificarPersonaje(personajes);
                    //Tools.pausaFinsTecla();
                    break;
                default:
                    System.out.println("ERROR: opción incorrecta");
                    System.out.println("Presione ENTER para continuar");
                    in.nextLine();
                    break;
            }
        }
    }

    /**
     * Método que pide los datos de un personaje y lo agrega al ArrayList, para
     * guardarlo en el archivo csv al finalizar el programa.
     */
    private void crearPersonaje() {
        
        int fuerza = 0, constitucion = 0, velocidad = 0, inteligencia = 0, suerte = 0, devocion = 0, categoria = 0;
        int puntosIniciales = 45;

        System.out.println("===NUEVO PERSONAJE===");
        System.out.println("█▓▒▓█▀██▀█▄░░▄█▀██▀█▓▒▓█\n"
                + "█▓▒░▀▄▄▄▄▄█░░█▄▄▄▄▄▀░▒▓█\n"
                + "█▓▓▒░░░░░▒▓░░▓▒░░░░░▒▓▓█");
        System.out.println("Escoge un NOMBRE LEGENDARIO! ");
        String nom = in.nextLine();
        System.out.println("");
        System.out.println("¿A qué CATEGORÍA pertenecerá tu personaje?");
        System.out.println("1. GUERRERO");
        System.out.println("2. CABALLERO");
        System.out.println("3. VALQUIRIA");
        System.out.println("4. ASESINO");
        categoria = Tools.llegeixEnterRang(in, 1, 4);
        System.out.println("");
        System.out.println("Escoge la DEVOCIÓN");
        System.out.println("1. Orden");
        System.out.println("2. Caos");
        devocion = Tools.llegeixEnterRang(in, 1, 2);
        System.out.println("");
        System.out.println("ESTADÍSTICAS:");
        System.out.printf("Reparte %d puntos entre...\n", puntosIniciales);
        System.out.println("1. FUERZA");
        System.out.println("2. CONSTITUCIÓN");
        System.out.println("3. VELOCIDAD");
        System.out.println("4. INTELIGENCIA");
        System.out.println("5. SUERTE");

        System.out.println("(Escribe [número atributo] [ENTER] [número puntos])");
        System.out.println("");
        do {
            int num = Tools.llegeixEnterRang(in, 1, 5);
            switch (num) {
                case 1:
                    System.out.print("FUERZA --> ");
                    fuerza = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - fuerza + 3) + " puntos");
                    break;
                case 2:
                    System.out.print("CONSTITUCIÓN --> ");
                    constitucion = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - constitucion + 3) + " puntos");
                    break;
                case 3:
                    System.out.print("VELOCIDAD --> ");
                    velocidad = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - velocidad + 3) + " puntos");
                    break;
                case 4:
                    System.out.print("INTELIGENCIA --> ");
                    inteligencia = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - inteligencia + 3) + " puntos");
                    break;
                case 5:
                    System.out.print("SUERTE --> ");
                    suerte = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - suerte + 3) + " puntos");
                    break;
                default:
                    System.out.printf("Aún quedan %d puntos por repartir!\n", puntosIniciales);
            }
        } while (puntosIniciales > 0);

        System.out.println("");
        System.out.println("Escoge un arma para el combate!");
        System.out.println("1. " + armas.get(0));
        System.out.println("2. " + armas.get(1));
        System.out.println("3. " + armas.get(2));
        int op = Tools.llegeixEnterRang(in, 1, 3); 
        
        switch(categoria){
            case 1: //Guerrero
                if(devocion == 1){ // Orden
                     GuerreroOrden personaje = new GuerreroOrden(nom, "Guerrero", fuerza, constitucion, velocidad, inteligencia, suerte, armas.get(op - 1), "Orden");
                      personajes.add(personaje);
                }else{
                    GuerreroCaos personaje = new GuerreroCaos(nom, "Guerrero", fuerza, constitucion, velocidad, inteligencia, suerte, armas.get(op - 1), "Caos");
                     personajes.add(personaje);
                }
                break;
            case 2: //Caballero
                if(devocion == 1){
                    CaballeroOrden personaje = new CaballeroOrden(nom, "Caballero", fuerza, constitucion, velocidad, inteligencia, suerte, armas.get(op - 1), "Orden");
                     personajes.add(personaje);
                }else{
                    CaballeroCaos personaje = new CaballeroCaos(nom, "Caballero", fuerza, constitucion, velocidad, inteligencia, suerte, armas.get(op - 1), "Caos");
                     personajes.add(personaje);
                }
                break;
            case 3: //Valquiria
                if(devocion == 1){
                    ValquiriaOrden personaje = new ValquiriaOrden(nom, "Valquiria", fuerza, constitucion, velocidad, inteligencia, suerte, armas.get(op - 1), "Orden");
                     personajes.add(personaje);
                }else{
                    ValquiriaCaos personaje = new ValquiriaCaos(nom, "Valquiria", fuerza, constitucion, velocidad, inteligencia, suerte, armas.get(op - 1), "Caos");
                     personajes.add(personaje);
                }
                break;
            case 4: //Asesino
                if(devocion == 1){
                    AsesinoOrden personaje = new AsesinoOrden(nom, "Asesino", fuerza, constitucion, velocidad, inteligencia, suerte, armas.get(op - 1), "Orden");
                     personajes.add(personaje);
                }else{
                    AsesinoCaos personaje = new AsesinoCaos(nom, "Asesino", fuerza, constitucion, velocidad, inteligencia, suerte, armas.get(op - 1), "Caos");
                     personajes.add(personaje);
                }
                break;
        }
        
       
        System.out.println("");
        System.out.println("NUEVO PERSONAJE CREADO!");
        System.out.println("");
        System.out.println("Presione una tecla para volver al menú principal...");

    }
        

    private void modificarPersonaje(ArrayList<Personaje> personajes){
        int fuerza = 0, constitucion = 0, velocidad = 0, inteligencia = 0, suerte = 0;
        int puntosIniciales = 45;
        System.out.println("Selecciona un personaje");
        for (int i = 0; i < personajes.size(); i++) {
            Personaje personaje = personajes.get(i);
            System.out.println((i + 1) + " " + personaje.getNom());
            System.out.println("");
        }
        System.out.println("");
        int opcio = Tools.llegeixEnterRang(in, 0, personajes.size()-1);
        System.out.println("NUEVO NOMBRE para " + personajes.get(opcio).getNom());
        String nom = in.nextLine();
         System.out.println("ESTADÍSTICAS:");
        System.out.printf("Reparte %d puntos entre...\n", puntosIniciales);
        System.out.println("1. FUERZA");
        System.out.println("2. CONSTITUCIÓN");
        System.out.println("3. VELOCIDAD");
        System.out.println("4. INTELIGENCIA");
        System.out.println("5. SUERTE");

        System.out.println("(Escribe [número atributo] [ENTER] [número puntos])");
        System.out.println("");
        do {
            int num = Tools.llegeixEnterRang(in, 1, 5);
            switch (num) {
                case 1:
                    System.out.print("FUERZA --> ");
                    fuerza = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - fuerza + 3) + " puntos");
                    break;
                case 2:
                    System.out.print("CONSTITUCIÓN --> ");
                    constitucion = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - constitucion + 3) + " puntos");
                    break;
                case 3:
                    System.out.print("VELOCIDAD --> ");
                    velocidad = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - velocidad + 3) + " puntos");
                    break;
                case 4:
                    System.out.print("INTELIGENCIA --> ");
                    inteligencia = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - inteligencia + 3) + " puntos");
                    break;
                case 5:
                    System.out.print("SUERTE --> ");
                    suerte = 3 + Tools.llegeixEnterRang(in, 0, Tools.min(15, puntosIniciales));
                    System.out.println("Restan " + (puntosIniciales = puntosIniciales - suerte + 3) + " puntos");
                    break;
            }
        } while (puntosIniciales > 0);
        
        personajes.get(opcio).setNom(nom);
        personajes.get(opcio).setFuerza(fuerza);
        personajes.get(opcio).setConstitucion(constitucion);
        personajes.get(opcio).setInteligencia(inteligencia);
        personajes.get(opcio).setSuerte(suerte);
        personajes.get(opcio).setVelocidad(velocidad);
        
        System.out.println("");
        System.out.println("Guardando Cambios");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("Hecho!");
         System.out.println("");
        System.out.println("Presione una tecla para volver al menú principal...");      
    }
    
    private void reescribeCSV(String ruta) {

        Path path = Paths.get(ruta);

        try {
            BufferedWriter sortida = Files.newBufferedWriter(path, Charset.forName("UTF-8"),
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            sortida.write("nom;" + "classe;" + "fuerza;" + "constitucion;" + "velocidad;" + "inteligencia;"
                    + "suerte;" + "nivel;" + "pExperiencia;" + "arma" + "devocion");
            sortida.newLine();
            for (int i = 0; i < personajes.size(); i++) {
                Personaje personaje = personajes.get(i);
                sortida.write(((AsesinoCaos)personaje).getNom() + ";" + personaje.getCategoria() + ";" + personaje.getFuerza()
                        + ";" + personaje.getConstitucion() + ";" + personaje.getVelocidad() + ";"
                        + personaje.getInteligencia() + ";" + personaje.getSuerte() + ";"
                        + personaje.getNivel() + ";" + personaje.getpExperiencia() + ";"
                        + personaje.getArma().getNom() + personaje.getDevocion());
                sortida.newLine();
            }
            sortida.close();
        } catch (IOException ex) {
            System.out.println("No se puede leer el archivo");
        }
    }

    public void mostrarArrayPersonajes(ArrayList<Personaje> personajes) {

        for (int i = 0; i < personajes.size(); i++) {
            Personaje personaje = personajes.get(i);
            System.out.println((i + 1) + " " + personaje);
            System.out.println("");
        }
        System.out.println("");
        //System.out.println("Presione una tecla para volver al menú principal...");
    }

    /**
     * Pide al usuario escoger entre dos personajes distintos y simula un
     * combate entre ellos.
     */
    private void combate() {

        Dado dado1 = new Dado(20);
        Dado dado2 = new Dado(20);
        Dado dado3 = new Dado(20);
        System.out.println("Selecciona el primer contrincante: ");
        mostrarArrayPersonajes(personajes);

        int c1 = Tools.llegeixEnterRang(in, 1, personajes.size());
        Personaje atacante = personajes.remove(c1 - 1);

        System.out.println("Selecciona el segundo contrincante:");
        mostrarArrayPersonajes(personajes);
        int c2 = Tools.llegeixEnterRang(in, 1, personajes.size());
        Personaje defensor = personajes.get(c2 - 1);

        personajes.add(c1 - 1, atacante);
        Personaje tmp;
        if (atacante.getVelocidad() < defensor.getVelocidad()) {
            tmp = atacante;
            atacante = defensor;
            defensor = tmp;
        }
        System.out.println("");
        System.out.println("===INICIO DEL COMBATE===");
        System.out.println("         />_________________________________\n"
                + "[########[]_________________________________>\n"
                + "         \\>");
        System.out.println(atacante.getNom().toUpperCase() +"("+ atacante.getCategoria() + "-"+atacante.getDevocion()+")" + " VS " + 
                defensor.getNom().toUpperCase() +"("+ defensor.getCategoria() + "-"+defensor.getDevocion()+")");
        boolean combateFinalizado = false;
        int ronda = 1;
        while (!combateFinalizado) {
            System.out.println("---Ronda " + ronda + "---");
            ronda++;
            if (atacante.ataca(dado1, dado2, dado3)) {
                System.out.println(atacante.getNom() + " ataca!");
                if (!defensor.esquiva(dado1, dado2, dado3)) {
                    defensor.repDany(atacante);
                    System.out.println(defensor.getNom() + " recibe " + atacante.getpDany() + " puntos de Daño...");
                    int ps = defensor.getpSalud();
                    if (ps < 0) {
                        ps = 0;
                    }
                    System.out.println("✚ Puntos de salud restantes ---> " + ps);
                } else {
                    System.out.println(defensor.getNom() + " esquiva el ataque!");
                }
            } else {
                System.out.println(atacante.getNom() + " ha fallado el ataque...");
            }

            if (defensor.getpSalud() <= 0) {
                System.out.println("");
                System.out.println("¡" + atacante.getNom() + " ha ganado el combate!");
                combateFinalizado = true;
            } else {
                tmp = defensor;
                defensor = atacante;
                atacante = tmp;
            }
        }
        atacante.restauraPSalud();
        defensor.restauraPSalud();

        atacante.sumarPExperiencia(defensor.getpSalud());

        if (atacante.getpExperiencia() >= nivels[atacante.getNivel()]) {
            atacante.setpExperiencia(atacante.getpExperiencia() - nivels[atacante.getNivel()]);
            atacante.subirNivel();
        }

        System.out.println("");
        System.out.println("Presione una tecla para volver al menú principal...");
    }

    private String mostraMenu() {

        System.out.println(" __ _________  ____  ________  ____  ____  _   _____   _  ___  _____   ___  _______ \n"
                + "  / // / __/ _ \\/ __ \\/ __/ __/ / __ \\/ __/ | | / / _ | / |/ / |/ / _ | / _ \\/  _/ _ |\n"
                + " / _  / _// , _/ /_/ / _/_\\ \\  / /_/ / _/   | |/ / __ |/    /    / __ |/ , _// // __ |\n"
                + "/_//_/___/_/|_|\\____/___/___/  \\____/_/     |___/_/ |_/_/|_/_/|_/_/ |_/_/|_/___/_/ |_|\n"
                + "                                                                                      ");
        System.out.println("Al legendario mundo de Vannaria se está librando una cruenta batalla con las fuerzas de la oscuridad\n"
                + "que acabará decidiendo el futuro de sus habitantes...");
        System.out.println("");
        System.out.println("1. Crear Personaje");
        System.out.println("2. Mostrar Personajes");
        System.out.println("3. Iniciar Combate");
        System.out.println("4. Modificar Personaje");
        System.out.println("X. Salir");
        return in.nextLine();
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Falta indicar el nombre del archivo de datos.");
        } else {
            HeroesOfVannaria partida = new HeroesOfVannaria();
            partida.leerDatos(args[0]);
            partida.jugar();
            partida.reescribeCSV(args[0]);
        }
    }

}
