package SOLID_Principle.D;

// Abstraction (Interface)
interface Database{
    void saveToDb(String data) ;
}

// MongoDB implementation (Low-level module)
class SQLDatabase implements Database{

    @Override
    public void saveToDb(String data){
        System.out.println("Executing MongoDB Function: db.users.insert({'" + data + "'})");
    }
}

// MySQL implementation (Low-level module)
class MongoDatabase implements Database{
    
    @Override
    public void saveToDb(String data){
        System.out.println("Executing SQL Query: INSERT INTO users VALUES('" + data + "')");
    }
}

// High-level module (Now loosely coupled via Dependency Injection)
class UserService1{
    private final Database db;

    public UserService1(Database db){
        this.db = db ;
    }

    public void storeToDB(String user){
        db.saveToDb(user);
    }
}


public class DIPfollowed {
    public static void main(String[] args) {
        Database sql = new SQLDatabase() ;
        Database mongo = new MongoDatabase() ;

        UserService1 serviceSql = new UserService1(sql) ;
        UserService1 serviceMongo = new UserService1(mongo) ;

        serviceSql.storeToDB("Mantosh");
        serviceMongo.storeToDB("Santosh");
    }
}
