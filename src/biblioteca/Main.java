/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import javax.swing.JOptionPane;

/**
 *
 * @author francescosapioli
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	HashMapLibrary libA = new HashMapLibrary("Library A");//instance of HashMapLibrary 
        
    	//few instances of Book 
        Book a1 = new Book("TPSI", "Francesco", "hoepli", "arh33", 12.9);
        Book a2 = new Book("sistemi", "Giovanni", "hoepli", "cdisuhi", 14.0);
        Book a3 = new Book("informatica", "Michele", "hoepli", "dsnjdsk", 11.3);
        Book a4 = new Book("italiano", "De CArlo", "hoepli", "sddj", 15.23);
        Book a5 = new Book("storia", "De Chirico", "hoepli", "h4md2", 21.5);
        Book a6 = new Book("matematica", "Quelali", "hoepli", "m5os3", 23.1);
        
        //ADD TO libA
        libA.addBook(a1);
        libA.addBook(a2);
        libA.addBook(a3);
        libA.addBook(a4);
        libA.addBook(a5);
        libA.addBook(a6);
        
        
        //search for a book in a library
        //if the book already exisits
        //output: the book already exisists
        //else
        //book added to the library 
        
        //variabili utilizzate per controllare il tempo di esecuzione dei due diversi modi di procedere
        long startTime1;
        long startTime2;
        long endTime1;
        long endTime2;
        long duration1;
        long duration2;
        //Dopo aver eseguito il programma dai un'occhiata ai tempi di esecuzione
        //Nella libreria sono presenti 6 libri 
        //E se ne avessi 50?
        //E se ne avessi 300?
        //E se ne avessi 1000?
        
        //INSERT BOOK
        String title = JOptionPane.showInputDialog("Inserisci il titolo di un libro da aggiungere alla libreria \n");
        
         //#############################################
        //FIRST WAY
        startTime1 = System.nanoTime();
        if(libA.getBooks().containsKey(title)){//check if the book is already in the library
        	JOptionPane.showMessageDialog(null, "Un libro con questo titolo è gia presente nella libreria.\n");
        	endTime1 = System.nanoTime();
        	duration1 = endTime1 - startTime1;//timeCheck
        }
        else{
        	endTime1 = System.nanoTime();
        	duration1 = endTime1 - startTime1;//timeCheck
        	//ask for books attributes
        	String writer = JOptionPane.showInputDialog("Inserisci lo scrittore del libro \n");
        	String editor = JOptionPane.showInputDialog("Inserisci l'editore del libro \n");
        	String isbn = JOptionPane.showInputDialog("Inserisci l'isbn del libro \n");
        	String string_price = JOptionPane.showInputDialog("Inserisci il prezzo del libro nel formato 00.00 (ex. 14.94) \n");
        	Double double_price = Double.parseDouble(string_price);
        	
        	Book new_book = new Book(title, writer, editor, isbn, double_price);
        	
        	//add book to the library and check it works
        	if(libA.addBook(new_book))
        		JOptionPane.showMessageDialog(null, "Il libro è stato aggiunto con successo.\n");
        	else
        		JOptionPane.showMessageDialog(null, "Non è stato possibile aggiungere il libro alla libreria.\n");
        }
        
       //#############################################
        
        
        
        //#############################################
        //SECOND WAY
        //i go through the map like i would do on a list or an array
        startTime2 = System.nanoTime();
        boolean check = false;
        for(Book temp : libA.getBooks().values()){
        	if(temp.getTitle().compareToIgnoreCase(title) == 0){
        		check =true;
        		break;
        	}
        }
        if(check){
        	JOptionPane.showMessageDialog(null, "Un libro con questo titolo è gia presente nella libreria.\n");
        	endTime2 = System.nanoTime();
        	duration2 = endTime2 - startTime2;//timeCheck
        }
        else{
            endTime2 = System.nanoTime();
        	duration2 = endTime2 - startTime2;//timeCheck
        	//ask for books attributes
        	String writer = JOptionPane.showInputDialog("Inserisci lo scrittore del libro \n");
        	String editor = JOptionPane.showInputDialog("Inserisci l'editore del libro \n");
        	String isbn = JOptionPane.showInputDialog("Inserisci l'isbn del libro \n");
        	String string_price = JOptionPane.showInputDialog("Inserisci il prezzo del libro nel formato 00.00 (ex. 14.94) \n");
        	Double double_price = Double.parseDouble(string_price);
        	
        	Book new_book = new Book(title, writer, editor, isbn, double_price);
        	
        	//add book to the library and check it works
        	if(libA.addBook(new_book))
        		JOptionPane.showMessageDialog(null, "Il libro è stato aggiunto con successo.\n");
        	else
        		JOptionPane.showMessageDialog(null, "Non è stato possibile aggiungere il libro alla libreria.\n");
        }
        
       //#############################################
      
          System.out.println("Duration time first way = " + duration1);
          System.out.println("Duration time second way = " + duration2);
          
          
         
         
        
    }
    
}