public class EmailValidator {

    public static void main(String[] args) {
        String[] emails = {
            "felipe@bice.cl",
            "sin-arroba.com",
            "otro@dominio",
            "valido@test.cl"
        };

        for (String email : emails) {
            // TODO: imprimir si el email es válido o no
            // Un email válido debe contener "@" y un "." después del "@"
            int arrbaPosicion = email.indexOf("@");
            int puntoPosicion = email.indexOf(".");

            if (arrbaPosicion != -1 && puntoPosicion > arrbaPosicion){
                 System.out.println(email + " es VALIDO");
            }else {
                System.out.println(email + " es INVALIDO");
            }
        }
    }
    
}
