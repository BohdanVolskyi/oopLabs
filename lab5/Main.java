package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main
{

    public static void help()
    {
        System.out.println
                (
                        "comands:\n\n" +
                                "add  "
                                + "\n" +
                                "random  "
                                + "\n" +
                                "clear  "
                                + "\n" +
                                "print  "
                                + "\n" +
                                "menu "
                                + "\n" +
                                "thread "
                                + "\n" +
                                "nothread"
                                + "\n" +
                                "comands:\n"
                                +"algo\n"
                                +"start \n"
                                +"result\n"
                                +"thread\n"+
                                 "exit\n"
                );
    }


    static String wordSearch = "";

    static String wordCalc = "";

    static char letterCalc;

    static int cont = 0;

    public static void main(String[] args) throws Exception
    {
        @SuppressWarnings("resource")
        Scanner reader = new Scanner(System.in);

        Container test = new Container();

        Container numOfTests = new Container();
        int count12 = 1;
        int timeEnd = 0;

        double threadTime = 0;

        double noThreadTime = 0;

        int counter1 = 0;

        help();

        System.out.println("Enter the comand");

        while(true)
        {
            System.out.print("- ");

            switch(reader.nextLine())
            {
                case "thread":

                    System.out.println("interruption time");



                    timeEnd = 1000 * Integer.parseInt(reader.nextLine());

                    break;

                case"algo":
                {
                    System.out.println
                            (
                                    "Length"
                                            + "\n" +
                                            "WordSearch"
                                            + "\n" +
                                            "Letter"
                                            + "\n" +
                                            "done"
                            );

                    String chosen;
                    while(true)
                    {
                        chosen = reader.nextLine();

                        if(chosen.equals("done"))
                        {
                            break;
                        }
                        else if(chosen.equals("Letter"))
                        {
                            System.out.println("Enter the word to find:");

                            String sek0 = reader.nextLine();

                            wordCalc = sek0;

                            System.out.println("Enter the letter to find:");

                            char sek1 = reader.nextLine().charAt(0);

                            letterCalc= sek1;

                            numOfTests.add(chosen);

                        }
                        else if(chosen.equals("WordSearch"))
                        {
                            System.out.println("Enter the word to find:");

                            String sek = reader.nextLine();

                            wordSearch = sek;

                            numOfTests.add(chosen);

                        }
                        else
                            numOfTests.add(chosen);

                    }

                    break;
                }

                case"start":
                {
                    if(numOfTests == null)
                    {
                        System.out.println("Choose tests before starting");

                        break;
                    }

                    WordSearch search = null;

                    Letter lettercalc = null;

                    Length max = null;

                    double time = System.currentTimeMillis();

                    for(String i : numOfTests)
                    {
                        if(i.equals("Letter"))
                        {

                            lettercalc = new Letter(test,wordCalc,timeEnd,letterCalc,counter1);
                        }
                        else if (i.equals("WordSearch"))
                        {

                            search = new WordSearch(test,wordSearch,timeEnd);
                        }

                        if(i.equals("Length"))
                        {
                            max = new Length(test,timeEnd);
                        }
                    }


                    if(search != null)
                    {
                        search.thread.join();
                    }

                    if(lettercalc != null)
                    {
                        lettercalc.thread.join();
                    }

                    if(max != null)
                    {
                        max.thread.join();
                    }

                    threadTime = (System.currentTimeMillis() - time) / 1000;

                    break;
                }

                case"result":
                {
                    System.out.print
                            (


                                             " With Thread  "+ threadTime +"\n"
                                            +" Without Thread "+ noThreadTime +"\n"
                                            +" With Thread vs Without Thread \n"
                                            +""+ noThreadTime / threadTime + " \n"

                            );

                    break;
                }

                case"nothread":
                {
                    noThreadTime = System.currentTimeMillis();
                    for(String i: numOfTests)
                    {
                        if(i.equals("Letter"))
                        {
                            letter(test);
                        }
                        else if (i.equals("WordSearch"))
                        { wordsearch(test);
                        }
                        else if(i.equals("Length"))
                        {
                            length(test);
                        }
                    }

                    noThreadTime = (System.currentTimeMillis() - noThreadTime) / 1000;

                    break;
                }

                case "menu":

                    help();

                    break;

                case "add":

                    System.out.print("Enter the string to add: ");

                    test.add(reader.nextLine());

                    cont++;

                    break;

                case "clear":

                    test.clear();

                    System.out.println("Container was cleared.");

                    break;
                case "random":
                    create(test);
                    break;
                case "print":

                    System.out.println("List of strings: ");

                    for(String string: test)
                    {
                        System.out.printf("%d \n",count12);
                        System.out.println(string);
                        count12++;
                        System.out.println();
                    }

                    break;

                case "exit":
                    return;

            }
        }
    }


    @SuppressWarnings("static-access")
    public static void wordsearch(Container con)
    {
        Thread thread = Thread.currentThread();

        for(String i: con)
        {
            try
            {
                thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if(i.equals(wordSearch))
            {
                System.out.println("NoThread: WordSearch - yes");

                return;
            }
        }

        System.out.println("NoThread: WordSearch - no");
    }


    @SuppressWarnings("static-access")
    public static void length(Container con)
    {
        int max = 0;

        int k = cont;

        Thread thread = Thread.currentThread();

        for(int i = 0; i < k; i++)
        {
            try
            {
                thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if(max  < con.at(i).length())
            {
                max = con.at(i).length();
            }

        }

        System.out.println("NoThread: length - "+ max);
    }


    @SuppressWarnings({ "unlikely-arg-type", "static-access" })
    public static void letter(Container con)
    {
        ArrayList<String> m = new ArrayList<String>();
        m.add(wordCalc);
        int counter = 0;

        Thread thread = Thread.currentThread();

        for(String i: con)
        {
            try
            {
                thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if(m.contains(wordCalc) && i.equals(wordCalc))
            {
                StringBuilder wor = new StringBuilder(wordCalc.subSequence(0, wordCalc.length()));

                for(int j = 0; j < wor.length(); j++)
                {
                    if(wor.charAt(j) == letterCalc)
                    {
                        counter++;
                    }

                }
                System.out.println("NoThread: There are " + counter + " letters");

                return ;
            }
        }

        System.out.println("NoThread: No Word Found");
    }

    public static void create(Container con)
    {
        int o;

        Scanner scan = new Scanner(System.in);

        System.out.println("How many objects do u want to create?");

        o = scan.nextInt();

        String[] randomStrings = new String[o];

        Random random = new Random();

        for(int i = 0; i < o; i++)
        {
            char[] word = new char[random.nextInt(200)+100];

            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }

            randomStrings[i] = new String(word);

            con.add(randomStrings[i]);
            cont++;
        }
    }
}