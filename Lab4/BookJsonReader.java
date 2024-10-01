import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookJsonReader implements BookFileReader {

    @Override
    public ArrayList<Book> readFile(String filePath) {
        ArrayList<Book> books = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            // Print the absolute path for debugging
            File file = new File(filePath);
            System.out.println("Trying to read file: " + file.getAbsolutePath());
            CollectionType listType = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Book.class);
            books = objectMapper.readValue(new File(filePath), listType);
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + filePath);
            e.printStackTrace();
        }

        return books;
    }
}


