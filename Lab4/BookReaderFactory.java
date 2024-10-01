public class BookReaderFactory {

    public static BookFileReader getReader(String filePath){
        String fileExtension = getFileExtension(filePath);
        if (fileExtension.equals("json")){
            return new BookJsonReader();
        } else if (fileExtension.equals("xml")){
            return new BookXMLReader();
        } else {
            return null;
        }
    }

    private static String getFileExtension(String filePath) {
        int dotIndex = filePath.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < filePath.length() - 1) {
            return filePath.substring(dotIndex + 1);
        }
        return "";
    }
}
