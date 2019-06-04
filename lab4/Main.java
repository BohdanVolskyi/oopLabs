package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static LinkedList<Books> books = new LinkedList<>();
    static Pather pather = null;

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        boolean auto = false;

        if(args.length > 0)
        {
            if(args[0].equals("-auto") || (args.length > 4 && args[4].equals("-auto")))
            {
                System.out.println("~--~ Automatic saving have been engaged...");
                auto = true;
            }
        }





        Scanner s = new Scanner(System.in);

        help();
        while (true)
        {
            pather = new Pather(new Scanner(System.in));


            if(auto)
            {
                System.out.println("Pick the file .(txt)");
                System.out.println("~--~ To move through the folders enter [go 'folder's name']\n"
                        + "~--~ To return back enter [back 'folder's name']");
                books = deserialize();
                auto = false;
            }

            String  inp = s.nextLine();
            switch(inp) {
                case "add":
                    books.add(new Books(s));
                    break;
                case "remove":

                    System.out.println("~--~ Enter the index to remove: ");
                    int inek = s.nextInt();

                    System.out.println("~--~ Removing current Album...");

                    boolean find = false;

                    int z = 1;
                    for(Books i: books)
                    {
                        if(z == inek)
                        {
                            find = true;
                            books.remove(i);
                        }
                        z++;
                    }

                    if(find == false)
                    {
                        System.out.println("~--~ The Album of entered index wasn't resolved ~--~ \n");
                    }
                    else
                        System.out.println("~--~ Album was succsessfully removed ~--~ \n");

                    break;
                case "search":

                    System.out.println("~--~ Enter the index to search: ");
                    int index = s.nextInt();

                    boolean fin = false;

                    int n = 1;
                    for(Books i: books)
                    {
                        if(n == index)
                        {
                            fin = true;
                            i.EnteredInfo();
                        }
                        n++;
                    }

                    if(fin == false)
                    {
                        System.out.println("~--~ The Album of entered index wasn't resolved ~--~ \n");
                    }

                    break;
                case "print":

                    System.out.printf("~--~ %s Albums were entered ~--~\n", books.size());
                    System.out.println("~--~ Printing...\n");

                    int j = 1;
                    for(Books indexito: books)
                    {
                        System.out.printf("%d ~--~ AudioComposition ", j);
                        indexito.EnteredInfo();
                        j++;
                        System.out.println("~-----~\n");
                    }
                    System.out.println("~--~ The info was printed ~--~ \n");

                    break;

                case "sxml":
                    serializeXML();
                    break;


                case "dxml":
                    deserializeXML();
                    break;

                case "s":

                    serialize(books);

                    break;
                case "d":

                    books = deserialize();

                    break;
                default:
                    continue;

            }
        }

    }

    public static void help(){
        System.out.println(
                "меню:\n\n" +
                        "[add]  додає нову книжку\n" +
                        "[remove]  видалення\n" +
                        "[print]  показує усі книжки\n" +
                        "[sxml]  серіалізація XML\n" +
                        "[dxml]  десеріалізація XML\n" +
                        "[s]  серіалізація \n" +
                        "[d]  десеріалізація \n" +

                        "[q] вийти з програми\n\n");
    }


    public static void serializeXML() throws FileNotFoundException
    {


        System.out.println("Create the file or Choose the file to write in \n");

        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(pather.directoryChoose())));

        encoder.writeObject(books);

        System.out.println("Serialized \n");

        encoder.close();
    }

    @SuppressWarnings("unchecked")
    public static void deserializeXML() throws FileNotFoundException
    {

        System.out.println("Choose the file to read out");


        XMLDecoder decoder = new XMLDecoder(new FileInputStream(pather.directoryChoose()));

        books = (LinkedList<Books>) decoder.readObject();

        System.out.println("Deserialized\n");

        decoder.close();
    }

    public static boolean serialize(@SuppressWarnings("rawtypes") LinkedList object)
    {
        System.out.println("~--~ Serializing...");
        System.out.println("~--~ To move through the folders enter [go 'folder's name']\n"
                + "~--~ To return back enter [back 'folder's name']");
        System.out.println("~--~ Create the file or Choose the file to write in ~--~\n");
        FileOutputStream fos;
        try
        {
            fos = new FileOutputStream(pather.directoryChoose());
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
            return false;
        }

        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            System.out.println("~--~ Serialized ~--~\n");
            oos.flush();
            oos.close();
            fos.close();
            return true;
        }
        catch (IOException e)
        {
            System.out.println(e);
            return false;
        }
    }
    @SuppressWarnings({ "rawtypes", "resource" })

    public static LinkedList deserialize()
    {
        System.out.println("~--~ Choose the file to read out ~--~");
        System.out.println("~--~ Deserializing...");
        FileInputStream fis;
        try
        {
            fis = new FileInputStream(pather.directoryChoose());
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
            return null;
        }
        try
        {
            ObjectInputStream ois = new ObjectInputStream(fis);

            LinkedList  temp = (LinkedList) ois.readObject();
            System.out.println("~--~ Deserialized ~--~\n");
            ois.close();
            return temp;
        }
        catch (IOException e)
        {
            System.out.println(e);
            return null;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
            return null;
        }
    }










}
