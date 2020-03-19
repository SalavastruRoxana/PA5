package com.company;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
                oos.writeObject(catalog);
                //oos.flush();
        }
        catch(NullPointerException e)
        {
            System.out.println("Null pointer exception!");
        }
        catch (IOException e)
        {
            System.out.println("IOException");
            e.getCause();
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException {

        Catalog catalog = null;
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {
            fin = new FileInputStream(path);
            ois = new ObjectInputStream(fin);
            catalog = (Catalog) ois.readObject();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(fin!=null)
            {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
        return catalog;
    }
        public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        //… browse or open, depending of the location type
    }

}
