package com.company;

import java.util.Iterator;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;




public class Container implements Iterable<String>, Serializable
{

    String[] array = new String[16];

    int currentLength = 0;


    public static Container deserialize(String fname) {
        Container obj = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
            obj = (Container) ois.readObject();
            ois.close();
            return obj;
        } catch (ClassNotFoundException e) {
            System.out.println("The file does not contain StringIterable class.");
        } catch (StreamCorruptedException e) {
            System.out.println("Serialized data is corrupted.");
        } catch (IOException e) {
            System.out.println("Error with opening the file.");
        }
        return obj;
        }

    public void serializeTo(String fname)
            throws Exception
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
        oos.writeObject(this);
        oos.close();
    }



        public Iterator<String> iterator() {
            return new Iterator<String>() {

                private int num = -1;

                public boolean hasNext() {
                    return num + 1 < array.length;
                }

                public String next() {
                    return array[++num];
                }

                public void remove() {
                    String[] massive = new String[--currentLength];
                    int j = 0;

                    for (int i = 0; i < array.length; i++) {
                        if (i != num) {
                            massive[j++] = array[i];
                        }
                    }

                    array = massive;
                }

            };
        }


        public String toString() {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < array.length; i++)
                str.append(array[i]);

            return str.toString();
        }

        public void add(String string) {

            String[] newData = new String[array.length + 1];
            System.arraycopy(array, 0, newData, 0, array.length);
            newData[currentLength] = string;
            array = newData;
            currentLength++;
        }

        public void clear() {

            array = new String[0];
            currentLength = 0;

        }

    public boolean remove(String string)
    {
        Iterator<String> iter = this.iterator();

        while(iter.hasNext())
        {
            if(string.equals(iter.next()))
            {
                iter.remove();
                return true;
            }
        }

        return false;
    }

        public String[] toArray() {
            return array;
        }


        public int size() {
            return currentLength;
        }

        public boolean contains(String string) {
            for (int i = 0; i < currentLength; i++)
                if (string.equals(array[i]))
                    return true;
            return false;
        }



        public boolean containsAll(Container container) {
            for (String string : container)
                if (!this.contains(string)) {
                    return false;
                }

            return true;
        }


    public void sort()
    {
        boolean isSwapped = false;

        do
        {
            isSwapped = false;

            for(int i = 0; i < array.length-1; i++)
            {
                if(array[i].compareTo(array[i + 1]) > 0)
                {
                    String temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;

                    isSwapped = true;
                }
            }
        }
        while(isSwapped);
    }

}








