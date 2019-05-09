package com.test.mongo;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.tomtom.places.model.ClusterState;

public class App {

    private static final String DELTA_FILE_PATH_PREFIX = "src/main/resources/";
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(CharSequence.class, new CharSequenceAdapter()).create();
    private static final File jsonDeltaFile = new File(DELTA_FILE_PATH_PREFIX + "86df464a-0873-4562-b00b-6ee1efcef832.json");

    // 86df464a-0873-4562-b00b-6ee1efcef832.json
    private static ClusterState getClusterState(String jsonFileName) {
        ClusterState state = null;
        try {
            File jsonDeltaFile = new File(DELTA_FILE_PATH_PREFIX + jsonFileName);
            if (jsonDeltaFile.exists()) {
                String stateJsonString = FileUtils.readFileToString(jsonDeltaFile);
                return gson.fromJson(stateJsonString, ClusterState.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }

    private static String getJsonAsString() {
        try {
            if (jsonDeltaFile.exists()) {
                return FileUtils.readFileToString(jsonDeltaFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {

            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

            /*
             * MongoClient mongo = new MongoClient("localhost", 27017); MongoDatabase db = mongo.getDatabase("test");
             * MongoCollection<Document> collection = db.getCollection("test"); String jsonAsString = getJsonAsString(); BasicDBObject
             * basicDBObject = new BasicDBObject("ClusterPlace", jsonAsString); collection.insertOne(basicDBObject); BasicDBObject document
             * = new BasicDBObject(); document.put("name", "mkyong"); document.put("age", 30); document.put("createdDate", new Date());
             * table.insert(document); String[] myStringArray = new String[] {"a", "b", "c"}; collection.insert(myStringArray); //
             * Compilation error at this line saying that "The method insert(DBObject...) in the type // DBCollection is not applicable for
             * the arguments (String[])" MongoDatabase database = MongoClient.getDatabase("yourDB"); MongoCollection<Document> collection =
             * database.getCollection("yourCollection"); collection.insertMany(yourDocumentList); DBObject document1 = new BasicDBObject();
             * document1.put("name", "Kiran"); document1.put("age", 20); DBObject document2 = new BasicDBObject(); document2.put("name",
             * "John"); List<DBObject> documents = new ArrayList<DBObject>(); documents.add(document1); documents.add(document2);
             * collection.insert(documents);
             */
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}