import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        String texto = "error login error timeout login error conexion timeout";

        String[] palabras = texto.split(" ");

        Map<String, Integer> contador = new HashMap<>();

        for (String palabra : palabras) {
            // TODO: si la palabra ya existe en el mapa, sumar 1
            if (contador.containsKey(palabra)) {
                contador.put(palabra, contador.get(palabra) + 1);
             // TODO: si no existe, agregarla con valor 1
            } else {
                contador.put(palabra, 1);
            }
        }

        // TODO: imprimir cada palabra y su cantidad
        for (Map.Entry<String, Integer> entrada : contador.entrySet()) {
            System.out.println("Palabra: " + entrada.getKey() + " - Cantidad: " + entrada.getValue());
        }
    }
    
}
