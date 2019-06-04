package com.company;

import com.sun.prism.impl.Disposer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;





public class Main {

    static ArrayList<Books> books = new ArrayList<>();
    static Pather pather = null;

    public static void main(String[] args) throws FileNotFoundException{





        Scanner s = new Scanner(System.in);

        help();
        while (true) {
            pather = new Pather(new Scanner(System.in));

            char inp = s.nextLine().charAt(0);
            switch(inp) {
                case 'a':
                    books.add(new Books(s));
                    break;
                case 'b':
                    books.clear();
                    break;
                case 'c':
                    for(Books books: books){
                        books.print();

                    }

                    break;
                case 'd':
                    serialize();
                    break;


                case 'e':
                    deserialize();
                    break;

                case  'q':
                    return;
                default:
                    continue;
            }
        }

    }

    public static void help(){
        System.out.println(
                "меню:\n\n" +
                        "[a]  додає нову книжку\n" +
                        "[b]  видалення\n" +
                        "[c]  показує усі книжки\n" +
                        "[d]  серіалізація\n" +
                        "[e]  десеріалізація \n" +

                        "[q] вийти з програми\n\n");
    }


    public static void serialize() throws FileNotFoundException
    {


        System.out.println("Create the file or Choose the file to write in \n");

        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(pather.directoryChoose())));

        encoder.writeObject(books);

        System.out.println("Serialized \n");

        encoder.close();
    }

    @SuppressWarnings("unchecked")
    public static void deserialize() throws FileNotFoundException
    {

        System.out.println("Choose the file to read out");


        XMLDecoder decoder = new XMLDecoder(new FileInputStream(pather.directoryChoose()));

        books = (ArrayList<Books>) decoder.readObject();

        System.out.println("Deserialized\n");

        decoder.close();
    }








}
