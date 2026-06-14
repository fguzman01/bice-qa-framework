import java.util.*;
import java.util.stream.*;

public class UsersStreamExercise {


   record User(int id, String firstName, String lastName, String email) {}

   public static void main(String[] args) {
    List <User> users = List.of(
        new User(7, "Michael", "Lawson", "michael.lawson@reqres.in"),
            new User(8, "Lindsay", "Ferguson", "lindsay.ferguson@reqres.in"),
            new User(9, "Tobias", "Funke", "tobias.funke@gmail.com"),
            new User(10, "Byron", "Fields", "byron.fields@reqres.in")
    );

    // TODO 1: Filtrar usuarios con email @reqres.in

    List<User> reqresUsers = users.stream()
    .filter(user -> user.email().endsWith("@reqres.in"))
    .collect(Collectors.toList());
    System.out.println("Usuarios @reqres.in: " + reqresUsers);

    // TODO 2: Transformar a lista de nombres completos en mayúsculas
    List<String> fullNames = reqresUsers.stream()
    .map(user -> (user.firstName() + " " + user.lastName()).toUpperCase())
    .collect(Collectors.toList());
    System.out.println("Nombres completos: " + fullNames);

    // TODO 3: Contar cuántos cumplen la condición
    long count = users.stream()
    .filter(user -> user.email().endsWith("@reqres.in"))
    .count();

    System.out.println("Usuarios con email @reqres.in: " + count);





   }
    
}
