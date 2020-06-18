package com.personal.web.spring.web.spring.dao;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.personal.web.spring.web.spring.models.Item;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("arngoDB")
public class ItemDaoImpl_arangoDB implements ItemDao {

    static final String dbName = "";
    static final String collectionName = "Items";


    ArangoDB arangoDB = new ArangoDB.Builder().build();

    @Override
    public int insertItem(Item item) {
        BaseDocument myObject = new BaseDocument();
        myObject.setKey(item.getId());
        myObject.addAttribute("name", item.getName());
        myObject.addAttribute("cost", item.getCost());
        myObject.addAttribute("availability", item.isAvailabilite());
        try {
            arangoDB.db(dbName).collection(collectionName).insertDocument(myObject);
            System.out.println("Document created");
        } catch (ArangoDBException e) {
            System.err.println("Failed to create document. " + e.getMessage());
        }
        return 1;
    }

    @Override
    public Item getItem(String id) {

        try {
            BaseDocument myDocument = arangoDB.db(dbName).collection(collectionName).getDocument(id.toString(), BaseDocument.class);
            return new Item(id, myDocument.getAttribute("name").toString(), Integer.parseInt(myDocument.getAttribute("cost").toString()), (Boolean) myDocument.getAttribute("availability"));
        } catch (ArangoDBException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
