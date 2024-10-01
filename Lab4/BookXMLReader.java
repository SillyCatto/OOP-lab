import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BookXMLReader implements BookFileReader {

    @Override
    public ArrayList<Book> readFile(String filePath) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.findAndRegisterModules(); // Ensures LocalDate handling
        ArrayList<Book> books = null;

        try {
            // Here, we're reading the root <books> element
            // which contains multiple <book> elements
            BookXMLWrapper booksWrapper = xmlMapper.readValue(new File(filePath), BookXMLWrapper.class);
            // Extract the list of books from the wrapper
            books = booksWrapper.getBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}

