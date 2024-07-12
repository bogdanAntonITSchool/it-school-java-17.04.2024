package exercises;

import java.util.List;

public class Processor {

    private final List<DataSource> dataSources;

    public Processor(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public void process(String path) {
        for (DataSource dataSource : dataSources) {
            dataSource.getData(path).ifPresentOrElse(
                    data -> System.out.println("Data found: " + data),
                    () -> System.out.println("No data found")
            );
        }

        dataSources.stream()
                .map(dataSource -> dataSource.getData(path))
                .map(optional -> optional.orElse("No data found"))
                .forEach(data -> {
                    if (!data.startsWith("No data found")) {
                        System.out.println("Data found: " + data);
                    } else {
                        System.out.println(data);
                    }
                });
    }
}
