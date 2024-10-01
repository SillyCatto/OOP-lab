import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class BookXMLWrapper {

    // This tells Jackson to expect a list of <book> elements inside <books>
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "book") // Each element is <book>
    private ArrayList<Book> books;

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}

