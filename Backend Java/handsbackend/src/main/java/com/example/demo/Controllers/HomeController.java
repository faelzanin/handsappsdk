package com.example.demo.Controllers;

import com.example.demo.Repository.MongoConnection;
import com.example.demo.Utils.RestUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexModel;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @RequestMapping("/users/list")
    public Map<String,Object> getListUsers(@RequestParam(value="limit", defaultValue="20") int limit) {

        MongoCollection<Document> devices =  MongoConnection.getInstance().getDatabase().getCollection("devices");

        BasicDBObject query = new BasicDBObject();
        FindIterable<Document> findResult = devices.find(query).limit(limit);
        List<String> results = new ArrayList<>();
        for (Document document : findResult) {
            results.add(document.get("euid").toString());
        }


        return new RestUtil().createResponseObject(200, results);
    }

    @RequestMapping("/users/detail")
    public Map<String,Object> getUser(@RequestParam(value="userId", defaultValue="") String userId) {

        MongoCollection<Document> devices =  MongoConnection.getInstance().getDatabase().getCollection("devices");

        BasicDBObject query = new BasicDBObject();
        //query.put("euid", "0c4233dc-a24a-4671-8b52-8753f1b1df0b");
        query.put("euid", userId);

        FindIterable<Document> findResult = devices.find(query);
        List<Document> results = new ArrayList<>();
        for (Document document : findResult) {
            results.add(document);
        }

        return new RestUtil().createResponseObject(200, results);
    }

   
}