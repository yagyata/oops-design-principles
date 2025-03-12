import java.util.ArrayList;
import java.util.List;
class Library {
    private List<Books> book;

    public Library(){
        this.book = new ArrayList<>();
    }
    public void addBooks(Books books) {
        book.add(books);
    }
    public void showBooks() {
        for(Books books: book){
            System.out.println(books.title);
        }
    }
}

class Books{
    String title;
    private String author;

    public Books(String title,String author){
        this.title = title;
        this.author = author;
    }
}

public class LibraryBooks {
    public static void main(String[] args) {
        Library library = new Library();

        Books book1 = new Books("Pride and Prejudice", "Jane Austen");
        Books book2 = new Books("Harry Potter", "JK Rowling");

        library.addBooks(book1);
        library.addBooks(book2);

        System.out.println("Books present in the library are: ");
        library.showBooks();
    }
}
