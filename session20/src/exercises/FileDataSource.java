package exercises;

import java.util.Optional;
import java.util.regex.Pattern;

public class FileDataSource extends DataSource {
    @Override
    public Optional<String> getData(String path) {
        System.out.println(String.format("Trying to get data from file with path %s.", path));
        Pattern pattern = Pattern.compile("^(?:[\\w]\\:|\\/)(\\/[a-z_\\-\\s0-9\\.]+)+\\.(txt|gif|pdf|doc|docx|xls|xlsx|js)$");

        return pattern.matcher(path).matches()
                ? Optional.of("Data from file")
                : Optional.empty();
    }
}
