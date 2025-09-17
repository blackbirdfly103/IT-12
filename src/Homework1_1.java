public class Homework1_1 {
    public static void main(String[] args) {
        Administrator admin = new Administrator("admin01", "password123", "Pending",
                "Alice Johnson", "alice@example.com");

        admin.verifyLogin();
        admin.updateCatalog();

        System.out.println(admin);
    }
}

class User {
    private String userID;
    private String password;
    private String loginStatus;

    public User(String userID, String password, String loginStatus) {
        this.userID = userID;
        this.password = password;
        this.loginStatus = loginStatus;
    }

    public boolean verifyLogin(){
        if (userID != null && !userID.isEmpty() &&
                password != null && !password.isEmpty()) {
            loginStatus = "Success";
            return true;
        }
        loginStatus = "Failed";
        return false;
    }

    @Override
    public String toString() {
        return "User ID: " + userID + ", Login Status: " + loginStatus;
    }

}

class Administrator extends User {
    private String adminName;
    private String email;

    public Administrator(String userId, String password, String loginStatus,
                         String adminName, String email) {
        super(userId, password, loginStatus); // call User constructor
        this.adminName = adminName;
        this.email = email;
    }

    public boolean updateCatalog() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Admin Name: " + adminName + ", Email: " + email;
    }
}

