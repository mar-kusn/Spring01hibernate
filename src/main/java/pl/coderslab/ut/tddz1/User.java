package pl.coderslab.ut.tddz1;

public class User {
    private int id;
    private String userName;

    public User() {
    }

    // copy constructor
    public User(User otherUser) {
        this.id = otherUser.id;
        this.userName = otherUser.userName;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
