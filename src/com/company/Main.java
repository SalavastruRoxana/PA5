package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }
    private void testCreateSave() throws IOException {
        try {
            Catalog catalog = new Catalog("Java Resources", "C:/java_toDelete/catalog.ser");
            Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
            Document doc2 = new Document("java2", "Java Course 2", "https://profs.info.uaic.ro/~acf/java/labs/slides/lab_05.pdf");
            doc.addTag("type", "Slides");
            doc.addTag("title","Advanced Programming Lab 5");
            catalog.add(doc);
            catalog.add(doc2);
            CatalogUtil.save(catalog);
        }
        catch (IOException e)
        {
            System.out.println("Input/Output Exception in testCreateSave method! ");
            e.getCause();
        }
    }

    private void testLoadView() throws InvalidCatalogException {
        try {
            Catalog catalog = CatalogUtil.load("C:/java_toDelete/catalog.ser");
            Document doc = catalog.findById("java1");
            CatalogUtil.view(doc);
        }
        catch (InvalidCatalogException e)
        {
            e.printStackTrace();
        }
    }

}
