import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public record Book(String title, String author, String genre, int pages, LocalDate finishedDate) {

    public Book(
            @JsonProperty("title") String title,
            @JsonProperty("author") String author,
            @JsonProperty("genre") String genre,
            @JsonProperty("pages") int pages,
            @JsonProperty("date_read") LocalDate finishedDate
    ) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.finishedDate = finishedDate;
    }
}
