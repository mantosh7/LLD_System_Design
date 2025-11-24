package SOLID_Principle.D;

class MySQLDatabase {       // Low-level module
    public void saveToSQL(String data) {
        System.out.println("Executing SQL Query: INSERT INTO users VALUES('"
                + data + "');");
    }
}

class MongoDBDatabase {     // Low-level module
    public void saveToMongo(String data) {
        System.out.println("Executing MongoDB Function: db.users.insert({name: '"
                + data + "'})");
    }
}

class UserService{  // High-level module (Tightly coupled)
    private final MongoDBDatabase mongoDB = new MongoDBDatabase() ;
    private final MySQLDatabase sqlDB = new MySQLDatabase() ;

    public void storeToSQLDB(String user){
        // MySQL-specific code
        sqlDB.saveToSQL(user);
    }

    public void storeToMongoDB(String user){
        // MongoDB-specific code
        mongoDB.saveToMongo(user);
    }
}

public class DIPviolated {
    public static void main(String[] args) {
        UserService service = new UserService() ;
        service.storeToMongoDB("Mantosh");
        service.storeToSQLDB("Amit") ;
    }
}
