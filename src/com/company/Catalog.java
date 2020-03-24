package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog  implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public Document findById(String id) {
        for (Document doc : documents) {
            if (doc.getId().compareTo(id) == 0 ) {
                return doc;
            }
        }
        return null;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", documents=" + documents +
                '}';
    }
}
