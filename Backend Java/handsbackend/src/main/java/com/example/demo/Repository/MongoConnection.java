package com.example.demo.Repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    private static MongoConnection instance;
    private static MongoClientURI uri = new MongoClientURI(
            "mongodb://faelzanin:26101992rah@cluster0-shard-00-00-n0hjr.mongodb.net:27017,cluster0-shard-00-01-n0hjr.mongodb.net:27017,cluster0-shard-00-02-n0hjr.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
    private static MongoClient mongoClient;

    public static MongoConnection getInstance() {
        if(instance == null) {
            instance = new MongoConnection();
        }
        if(mongoClient == null || mongoClient.isLocked()) {
            mongoClient = new MongoClient(uri);
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return mongoClient.getDatabase("test");
    }

    public void close() {
        mongoClient.close();
    }
}
