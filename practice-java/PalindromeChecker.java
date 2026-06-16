public class PalindromeChecker {

    public static void main(String[] args) {
        String[] palabras = {
            "reconocer",
            "java",
            "anita lava la tina",
            "selenium"
        };

        for (String palabra : palabras) {
            // TODO: limpiar el string (quitar espacios, pasar a minúsculas)
            String limpio = palabra.replace(" ", "").toLowerCase();
            // TODO: comparar el string con su versión invertida
            // TODO: imprimir si es palíndromo o no
            String invertido = new StringBuilder(limpio).reverse().toString();
            if (limpio.equals(invertido)){
                System.out.println(palabra + " → es PALINDROMO");
            }else {
                 System.out.println(palabra + " → NO es palindromo");

            }
        }
    }
}