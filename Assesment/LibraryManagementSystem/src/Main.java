import com.library.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static String password = "admin123";// Default password
    static List<Book> books = new ArrayList<>();// Store books
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//  Authenticate user
        if(!authenticate()){
            System.out.println("Invalid Password. Existing...");
            return;
        }

//  Display menu
        while(true){
            System.out.println("****** LIBRARY MANAGEMENT SYSTEM MENU *****");
            System.out.println("1. Add Books");
            System.out.println("2. Delete Book");
            System.out.println("3. Search Book");
            System.out.println("4. View Book List");
            System.out.println("5. Edit Book Record");
            System.out.println("6. Change Password");
            System.out.println("7. Close Application");

            int choice = scanner.nextInt();
            scanner.nextLine();

//  Process user choice
         switch (choice){
             case 1 -> addBook(); // Add a Book
             case 2 -> deleteBook(); // Delete a Book
             case 3 -> searchBook(); // Search for a Book
             case 4 -> viewAllBooks(); // View All Books
             case 5 -> editBookRecords();//Edit books
             case 6 -> changePassword(); // Change Password
             case 7 -> exitSystem(); // Exit System
             default -> System.out.println("Invalid choice. Please try again.");
         }
        }
    }
    //  Password authentication
    private static boolean authenticate(){
        System.out.println("Enter the password to access the system");
        String inputPassword=scanner.nextLine();
        return inputPassword.equals(password);
    }
//  Add a book
    private static void addBook() {
        System.out.println("Choose a category:");
        System.out.println("1. Fiction");
        System.out.println("2. Non-Fiction");
        System.out.println("3. Science");
        System.out.println("4. History");
        System.out.print("Enter your choice: ");

        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String category = switch (categoryChoice) {
            case 1 -> "Fiction";
            case 2 -> "Non-Fiction";
            case 3 -> "Science";
            case 4 -> "History";
            default -> "Unknown";
        };

        System.out.println("Enter Book Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Book author");
        String author = scanner.nextLine();
        System.out.print("Enter Book Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Book Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        books.add(new Book(id,title,author,category,price,quantity));
        System.out.println("Books added successfully");
    }
//  Delete a book
    private static void deleteBook() {
        System.out.println("Enter a book id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = books.removeIf(book -> book.id == id  );
        if(removed){
            System.out.println("Book deleted successfully");
        }else{
            System.out.println("Book not found.");
        }
    }

    private static void searchBook() {
        System.out.print("Search by (title/author/category): ");
        String criterion = scanner.nextLine().toLowerCase();
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        boolean found=false;
        for (Book book:books){
            if ((criterion.equals("title")&&book.title.toLowerCase().contains(searchTerm))||
                    (criterion.equals("author")&&book.author.toLowerCase().contains(searchTerm))||
                    (criterion.equals("category"))&&book.category.toLowerCase().contains(searchTerm)){
                System.out.println(book);
                found=true;
            }
        }
        if(!found){
            System.out.println("No books found matching the search criteria.");
        }
    }
//  View all books
    private static void viewAllBooks() {
        if (books.isEmpty()){
            System.out.println("No books found");
        }else{
            System.out.println("List of books: ");
            for(Book book:books){
                System.out.println(book);
            }
        }
    }
//  Edit book records
    private static void editBookRecords() {
        System.out.println("Enter a book id to edit");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book bookToEdit=null;
        for (Book book:books){
            if(book.id==id){
                bookToEdit=book;
                break;
            }
        }
        if (bookToEdit!=null){
            System.out.println("Editing Book: "+bookToEdit);
            System.out.println("Enter new Title (leave blank to keep current): ");
            String newTitle = scanner.nextLine();
            if (!newTitle.isBlank()){
                bookToEdit.title=newTitle;
            }

            System.out.print("Enter new Author (leave blank to keep current): ");
            String newAuthor = scanner.nextLine();
            if (!newAuthor.isBlank()) {
                bookToEdit.author = newAuthor;
            }

            System.out.print("Enter new Category (leave blank to keep current): ");
            String newCategory = scanner.nextLine();
            if (!newCategory.isBlank()) {
                bookToEdit.category = newCategory;
            }

            System.out.print("Enter new Price (leave blank to keep current): ");
            String newPriceInput = scanner.nextLine();
            if (!newPriceInput.isBlank()) {
                bookToEdit.price = Double.parseDouble(newPriceInput);
            }

            System.out.print("Enter new Quantity (leave blank to keep current): ");
            String newQuantityInput = scanner.nextLine();
            if (!newQuantityInput.isBlank()) {
                bookToEdit.quantity = Integer.parseInt(newQuantityInput);
            }

            System.out.println("Book updated successfully");
        }else {
            System.out.println("Book not found.");
        }
    }
//  change the password
    private static void changePassword() {
        System.out.println("Enter current password: ");
        String currentPassword = scanner.nextLine();
        if (currentPassword.equals(password)){
            System.out.println("Enter new password: ");
            password=scanner.nextLine();
            System.out.println("Password changes successfully!");
        }else{
            System.out.println("Incorrect password.");
        }
    }
// exit the system
    private static void exitSystem() {
        System.out.println("Existing the system in 3 second...");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error during exist delay");
        }
        System.exit(0);
    }
}