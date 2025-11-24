package SOLID_Principle.L.LSPRules.MethodRules;

// A Precondition must be statisfied before a method can be executed.
// Sub classes can weaken the precondition but cannot strengthen it.

class User{
    // Precondition: Password must be at least 8 characters long
    public void setPassword(String password){
        if(password.length() < 8){
            throw new IllegalArgumentException("Password must be at least 8 characters long!");
        }
        System.out.println("User: Password set successfully.");
    }
}

class AdmiUser extends User{
    // Precondition: Password must be at least 6 characters
    @Override
    public void setPassword(String passowrd){
        if(passowrd.length() < 6){
            throw new IllegalArgumentException("Password must be at least 6 characters long!");
        }
        System.out.println("AdminUser: Password set successfully.");
    }
}

public class PreConditions {
    public static void main(String[] args) {
        User user = new User() ;
        user.setPassword("qwerty123");

        User adminUser = new AdmiUser();
        adminUser.setPassword("Admin1");  // Works fine: AdminUser allows shorter passwords
    }
}
