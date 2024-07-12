package exercises;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

//
//        List<String> listOfNames = List.of("john", "ana", "david", "anna");
//        Optional<String> first = listOfNames.stream()
//                .filter(Main::isNamePalindrom)
//                .findFirst();
//
//        first.ifPresentOrElse(
//                name -> System.out.println("First palindrom name is " + name),
//                () -> System.out.println("No palindrom name found")
//        );

        List<DataSource> dataSources = List.of(new FileDataSource(), new DatabaseDataSource());
        Processor processor = new Processor(dataSources);

//        processor.process("jdbc:postgres://localhost:5432/db;databaseName=example");
        processor.process("c:/data/file.txt");
    }

    private static boolean isNamePalindrom(String name) {
        return name != null
                && name.contentEquals(new StringBuilder(name).reverse());
    }
}
