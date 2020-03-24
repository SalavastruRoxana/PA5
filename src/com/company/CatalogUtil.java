package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(catalog.getPath());
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(catalog);
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception!");
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul cu path-ul \"" + catalog.getPath() + "\" nu a putut fi gasit!");
        } catch (IOException e) {
            System.out.println("S-a produs o exceptie in CatalogUtil, save method ");
            e.printStackTrace();
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
            System.out.println("a fost aruncata exceptia pathul \"" + path + "\" nu exista");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally { // executes whether or not an exception is thrown
            if (fin != null) {
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
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(doc.getLocation()));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + doc.getLocation());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
