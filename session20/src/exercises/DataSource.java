package exercises;

import java.util.Optional;

public abstract class DataSource {
    public abstract Optional<String> getData(String path);
}
