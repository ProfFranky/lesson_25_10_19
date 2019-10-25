/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author francescosapioli
 */
public class HashMapLibrary {
    
    //ATTRIBUTES
    private String name;
    private int numBooks; //Used to notice how many books are in the library
    private Map <String,Book> books;

     
    //CONSTRUCTOR
    public HashMapLibrary(String name) {
        this.books = new HashMap<String,Book>();
        this.name = name;
        this.numBooks = 0;
        
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }

    
    //GETTERS
    public String getName() {
        return name;
    }

    public int getNumBooks() {
        return numBooks;
    }

    public Map<String, Book> getBooks() {
        return books;
    }
    
    //add a book to the library method
    //return true if it works otherwise false
    public boolean addBook(Book a){
        books.put(a.getTitle(), a);
        numBooks++;
        if(books.containsKey(a.getTitle()))
        	return true;
        else
        	return false;
        
    }
    
    
}
