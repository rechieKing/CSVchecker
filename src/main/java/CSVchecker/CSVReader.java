package CSVchecker;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVReader {
    public List<Map<String, String>> read (Path path) {
        List<Map<String, String>> list = List.of();
        try {
            int initialCapacity = (int) Files.lines(path).count();
            list = new ArrayList<>(initialCapacity);

            // Read CSV file. For each row, instantiate and collect `DailyProduct`.
            BufferedReader reader = Files.newBufferedReader( path );
            Iterable <CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse( reader );
            for (CSVRecord record : records) {
                list.add(record.toMap());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
