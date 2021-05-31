

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.Scanner;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

public class Tools {

  public static void netejaPantalla() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        //Runtime.getRuntime().exec("clear");
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (IOException | InterruptedException ex) {
      System.out.println("Error en netejar pantalla: " + ex.getMessage());
    }
  }

  public static void pausaFinsTecla() {
    try {
      Terminal terminal = TerminalBuilder.builder()
        .jna(true)
        .system(true)
        .build();

      // raw mode means we get keypresses rather than line buffered input
      terminal.enterRawMode();
      NonBlockingReader reader = terminal.reader();
      reader.read();
      reader.close();
      terminal.close();
    } catch (IOException ex) {
      System.out.println("Error d'entrada/sortida: " + ex.getMessage());
    }
  }

  public static int llegeixEnterRang(Scanner in, int min, int max) {
    boolean correcte = false;
    int nombre = 0;
    while (!correcte) {
      System.out.printf("Insereix un nombre enter entre %d i %d: ", min, max);
      try {
        nombre = Integer.parseInt(in.nextLine());
        if (nombre < min || nombre > max) {
          System.out.printf("ERROR: el nombre no es troba dintre del rang permés [%d - %d]%n", min, max);
        } else {
          correcte = true;
        }
      } catch (NumberFormatException ex) {
        System.out.println("ERROR: no és un nombre enter");
      }
    }
    return nombre;
  }

  public static String retallaZeros(String str) {
    int pos = str.indexOf(0);
    return pos == -1 ? str : str.substring(0, pos);
  }
  
  static String afegeixZeros(String str, int length){
    StringBuffer resultat = new StringBuffer(str);
    for (int i = str.length(); i < length; i++) {
      resultat.append((char)0);
    }
    return resultat.toString();
  }
  
  static int min(int valor1, int valor2){
      if(valor1 < valor2){
          return valor1;
      }else{
          return valor2;
      }
  }
}
