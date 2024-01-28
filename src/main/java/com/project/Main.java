package com.project;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {

   public static void main(String[] args) {
      
      String basePath = System.getProperty("user.dir") + "/data/";

      File dir = new File(basePath);
      if (!dir.exists()){
         if(!dir.mkdirs()) {
               System.out.println("Error while creating 'Data' folder");
         }
      }

      Manager.createSessionFactory();

      Book theKingdomOfFantasy1 = Manager.addBook("The Kingdom Of Fantasy 1", "Geronimo Stilton");
      Book theKingdomOfFantasy2 = Manager.addBook("The Kingdom Of Fantasy 2", "Geronimo Stilton");
      Book theKingdomOfFantasy3 = Manager.addBook("The Kingdom Of Fantasy 3", "Geronimo Stilton");
      Book theKingdomOfFantasy4 = Manager.addBook("The Kingdom Of Fantasy 4", "Geronimo Stilton");
      Book theKingdomOfFantasy5 = Manager.addBook("The Kingdom Of Fantasy 5", "Geronimo Stilton");

      Book harryPotter1 = Manager.addBook("Harry Potter 1", "Salamandra");
      Book harryPotter2 = Manager.addBook("Harry Potter 2", "Salamandra");
      Book harryPotter3 = Manager.addBook("Harry Potter 3", "Salamandra");
      Book harryPotter4 = Manager.addBook("Harry Potter 4", "Salamandra");
      Book harryPotter5 = Manager.addBook("Harry Potter 5", "Salamandra");

      Book percyJackson1 = Manager.addBook("Percy Jackson 1", "Santillana");
      Book percyJackson2 = Manager.addBook("Percy Jackson 2", "Santillana");
      Book percyJackson3 = Manager.addBook("Percy Jackson 3", "Santillana");
      Book percyJackson4 = Manager.addBook("Percy Jackson 4", "Santillana");
      Book percyJackson5 = Manager.addBook("Percy Jackson 5", "Santillana");

      Library library1 = Manager.addLibrary("Library 1", "City 1");
      Set<Book> books1 = new HashSet<Book>();
      books1.add(theKingdomOfFantasy1);
      books1.add(theKingdomOfFantasy2);
      books1.add(theKingdomOfFantasy3);
      books1.add(theKingdomOfFantasy4);
      books1.add(theKingdomOfFantasy5);
      Manager.updateLibrary(library1.getLibraryId(), library1.getName(), library1.getCity(), books1);

      Library library2 = Manager.addLibrary("Library 2", "City 2");
      Set<Book> books2 = new HashSet<Book>();
      books2.add(harryPotter1);
      books2.add(harryPotter2);
      books2.add(harryPotter3);
      books2.add(harryPotter4);
      books2.add(harryPotter5);
      Manager.updateLibrary(library2.getLibraryId(), library2.getName(), library2.getCity(), books2);

      Library library3 = Manager.addLibrary("Library 3", "City 3");
      Set<Book> books3 = new HashSet<Book>();
      books3.add(percyJackson1);
      books3.add(percyJackson2);
      books3.add(percyJackson3);
      books3.add(percyJackson4);
      books3.add(percyJackson5);
      Manager.updateLibrary(library3.getLibraryId(), library3.getName(), library3.getCity(), books3);

      Person person1 = Manager.addPerson("99999999A", "Person 1", "+34 000 00 00 00");
      Set<Book> person1Books = new HashSet<Book>();
      person1Books.add(theKingdomOfFantasy1);
      person1Books.add(theKingdomOfFantasy2);
      person1Books.add(percyJackson1);
      Manager.updatePerson(person1.getPersonId(),
              person1.getDni(), person1.getName(), person1.getPhoneNumber(), person1Books);

      Person person2 = Manager.addPerson("98765432B", "Jane Smith", "+34 555 66 77 88");
      Set<Book> person2Books = new HashSet<Book>();
      person2Books.add(harryPotter1);
      person2Books.add(percyJackson2);
      person2Books.add(theKingdomOfFantasy3);
      Manager.updatePerson(person2.getPersonId(), person2.getDni(), person2.getName(), person2.getPhoneNumber(), person2Books);

      Person person3 = Manager.addPerson("24681357C", "Alice Johnson", "+34 999 88 77 66");
      Set<Book> person3Books = new HashSet<Book>();
      person3Books.add(percyJackson5);
      person3Books.add(harryPotter3);
      person3Books.add(theKingdomOfFantasy4);
      Manager.updatePerson(person3.getPersonId(), person3.getDni(), person3.getName(), person3.getPhoneNumber(), person3Books);

      Person person4 = Manager.addPerson("13579246D", "Bob Anderson", "+34 333 44 55 66");
      Set<Book> person4Books = new HashSet<Book>();
      person4Books.add(harryPotter4);
      person4Books.add(theKingdomOfFantasy5);
      person4Books.add(percyJackson1);
      Manager.updatePerson(person4.getPersonId(), person4.getDni(), person4.getName(), person4.getPhoneNumber(), person4Books);

      Person person5 = Manager.addPerson("98765432E", "Eva Martinez", "+34 777 88 99 00");
      Set<Book> person5Books = new HashSet<Book>();
      person5Books.add(percyJackson3);
      person5Books.add(harryPotter5);
      person5Books.add(theKingdomOfFantasy2);
      Manager.updatePerson(person5.getPersonId(), person5.getDni(), person5.getName(), person5.getPhoneNumber(), person5Books);

      Person person6 = Manager.addPerson("11223344F", "Frank Rodriguez", "+34 123 45 67 89");
      Set<Book> person6Books = new HashSet<Book>();
      person6Books.add(theKingdomOfFantasy1);
      person6Books.add(harryPotter1);
      person6Books.add(percyJackson2);
      Manager.updatePerson(person6.getPersonId(), person6.getDni(), person6.getName(), person6.getPhoneNumber(), person6Books);

      Person person7 = Manager.addPerson("55667788G", "Grace Lee", "+34 555 11 22 33");
      Set<Book> person7Books = new HashSet<Book>();
      person7Books.add(harryPotter2);
      person7Books.add(theKingdomOfFantasy3);
      person7Books.add(percyJackson4);
      Manager.updatePerson(person7.getPersonId(), person7.getDni(), person7.getName(), person7.getPhoneNumber(), person7Books);

      Person person8 = Manager.addPerson("12345678A", "John Doe", "+34 111 22 33 44");
      Set<Book> person8Books = new HashSet<Book>();
      person1Books.add(theKingdomOfFantasy1);
      person1Books.add(harryPotter2);
      person1Books.add(percyJackson4);
      Manager.updatePerson(person8.getPersonId(), person8.getDni(), person8.getName(), person8.getPhoneNumber(), person8Books);

      Author geronimoStilton = Manager.addAuthor("Geronimo Stilton");
      Set<Book> geronimoStiltonBooks = new HashSet<Book>();
      geronimoStiltonBooks.add(theKingdomOfFantasy1);
      geronimoStiltonBooks.add(harryPotter1);
      geronimoStiltonBooks.add(percyJackson1);
      Manager.updateAuthor(geronimoStilton.getAuthorId(), geronimoStilton.getName(), geronimoStiltonBooks);

      Author theaStilton = Manager.addAuthor("Thea Stilton");
      Set<Book> theaStiltonBooks = new HashSet<Book>();
      theaStiltonBooks.add(theKingdomOfFantasy2);
      theaStiltonBooks.add(harryPotter2);
      theaStiltonBooks.add(percyJackson2);
      Manager.updateAuthor(theaStilton.getAuthorId(), theaStilton.getName(), theaStiltonBooks);

      Author benjaminStilton = Manager.addAuthor("Benjamin Stilton");
      Set<Book> benjaminStiltonBooks = new HashSet<Book>();
      benjaminStiltonBooks.add(theKingdomOfFantasy3);
      benjaminStiltonBooks.add(harryPotter3);
      benjaminStiltonBooks.add(percyJackson3);
      Manager.updateAuthor(benjaminStilton.getAuthorId(), benjaminStilton.getName(), benjaminStiltonBooks);

      Author jkRowling = Manager.addAuthor("J. K. Rowling");
      Set<Book> jkRowlingBooks = new HashSet<Book>();
      jkRowlingBooks.add(theKingdomOfFantasy4);
      jkRowlingBooks.add(harryPotter4);
      jkRowlingBooks.add(percyJackson4);
      Manager.updateAuthor(jkRowling.getAuthorId(), jkRowling.getName(), jkRowlingBooks);

      Author rickJordan = Manager.addAuthor("Rick Jordan");
      Set<Book> rickJordanBooks = new HashSet<Book>();
      rickJordanBooks.add(theKingdomOfFantasy5);
      rickJordanBooks.add(harryPotter5);
      rickJordanBooks.add(percyJackson5);
      Manager.updateAuthor(rickJordan.getAuthorId(), rickJordan.getName(), rickJordanBooks);

      @SuppressWarnings("unchecked")
      Collection<Book> books = (Collection<Book>) Manager.listCollection(Book.class, "");
      System.out.println(Manager.collectionToString(Book.class, Manager.listCollection(Book.class, "")));
      @SuppressWarnings("unchecked")
      Collection<Library> libraries = (Collection<Library>) Manager.listCollection(Library.class, "");
      System.out.println(Manager.collectionToString(Library.class, libraries));
      @SuppressWarnings("unchecked")
      Collection<Person> persons = (Collection<Person>) Manager.listCollection(Person.class, "");
      System.out.println(Manager.collectionToString(Person.class, persons));
      @SuppressWarnings("unchecked")
      Collection<Author> authors = (Collection<Author>) Manager.listCollection(Author.class, "");
      System.out.println(Manager.collectionToString(Author.class, authors));

      Manager.close();
   }
}