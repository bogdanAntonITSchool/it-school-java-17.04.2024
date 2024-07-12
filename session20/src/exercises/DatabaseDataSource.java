package exercises;

import java.util.Optional;
import java.util.regex.Pattern;

public class DatabaseDataSource extends DataSource {
    @Override
    public Optional<String> getData(String path) {
        System.out.println(String.format("Trying to get data from database with path %s.", path));
        Pattern pattern = Pattern.compile(";databaseName=([^;]*)");

        return pattern.matcher(path).matches()
                ? Optional.of("Data from database")
                : Optional.empty();
    }
}
