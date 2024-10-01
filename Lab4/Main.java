/*
 * ID: 220042162
 * Date: Sep 10, 2024
 * OOC2 Lab1
 */

public class Main {
    public static void main(String[] args) {
        String filePath = "book.json";
        BookListTracker tracker = new BookListTracker(filePath);
        BookListTracker.printReport(tracker);

    }
}
