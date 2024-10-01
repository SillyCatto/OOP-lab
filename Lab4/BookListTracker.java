import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookListTracker {
    private final ArrayList<Book> bookList;

    public BookListTracker(String filePath) {
        BookFileReader reader = BookReaderFactory.getReader(filePath);
        if (reader != null) {
            this.bookList = reader.readFile(filePath);
        } else {
            System.err.println("No suitable reader found for the file: " + filePath);
            this.bookList = new ArrayList<>(); // Initialize to an empty list
        }
    }

//    public void loadBooks(String filePath) throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get(filePath));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        for(String line : lines){
//            String[] parts = line.split(",");
//
//            if(parts.length == 5){
//                String title = parts[0].trim();
//                String author = parts[1].trim();
//                String genre = parts[2].trim();
//                int pages = Integer.parseInt(parts[3].trim());
//                LocalDate finishedDate = LocalDate.parse(parts[4].trim(), formatter);
//
//                bookList.add(new Book(title, author, genre, pages, finishedDate));
//            }
//        }
//    }



    public int getTotalBooksRead() {
        return bookList.size();
    }

    public Map<String, Integer> getBooksReadPerMonth() {
        Map<String, Integer> booksReadPerMonth = new HashMap<>();

        for(Book book : bookList){
            String month = book.finishedDate().getMonth().toString();

            if(booksReadPerMonth.containsKey(month)){
                booksReadPerMonth.put(month, booksReadPerMonth.get(month) + 1);
            } else {
                booksReadPerMonth.put(month, 1);
            }
        }

        return booksReadPerMonth;
    }

    public List<Book> getTopLongestBookByPages(int limit) {
        List<Book> sortedBooks = new ArrayList<>(bookList);

        sortedBooks.sort((b1, b2) -> b2.pages() - b1.pages());

        return sortedBooks.subList(0, Math.min(limit, sortedBooks.size()));

    }

    public String getMostReadGenre() {
        Map<String, Integer> genreCount = new HashMap<>();

        for (Book book : bookList){
            String genre = book.genre();

            if(genreCount.containsKey(genre)){
                genreCount.put(genre, genreCount.get(genre) + 1);
            } else {
                genreCount.put(genre, 1);
            }
        }

        String mostReadGenre = null;
        int maxCount = 0;
        for (String genre : genreCount.keySet()){
            if(genreCount.get(genre) > maxCount){
                mostReadGenre = genre;
                maxCount = genreCount.get(genre);
            }
        }
        return mostReadGenre;
    }

    public double getAveragePageCount() {
        int totalPages = 0;
        for (Book book : bookList) {
            totalPages += book.pages();
        }

        if (!bookList.isEmpty()){
            return (double) totalPages/bookList.size();
        } else {
            return 0;
        }
    }

    public static void printReport(BookListTracker tracker) {
        System.out.println("Total books read last year: " + tracker.getTotalBooksRead());

        System.out.println("\nBooks read per month:");
        Map<String, Integer> booksReadPerMonth = tracker.getBooksReadPerMonth();
        for(String month : booksReadPerMonth.keySet()){
            System.out.println(month + ": " + booksReadPerMonth.get(month));
        }

        System.out.println("\nTop 10 longest books:");
        List<Book> topBooks = tracker.getTopLongestBookByPages(10);
        for(Book book : topBooks){
            System.out.println(book.title() + " - " + book.pages() + " pages");
        }

        System.out.println("\nMost read genre: " + tracker.getMostReadGenre());

        System.out.println("\nAverage length of books: " + tracker.getAveragePageCount() + " pages");
    }
}


