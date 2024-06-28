package Scaler.DesignPatterns.Prototype.User;

public class User implements ClonableObject<User> {
    private long userId;

    private String username;
    private String email;
    private String displayName;
    private int age;
    private UserType type;

    public User(long userId, String username, String email, String displayName, int age, UserType type) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.age = age;
        this.type = type;
    }

    public User(User other) {
        this.userId = other.userId;
        this.username = other.username;
        this.email = other.email;
        this.displayName = other.displayName;
        this.age = other.age;
        this.type = other.type;
    }
    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAge() {
        return age;
    }

    public UserType getType() {
        return type;
    }

    public User cloneObject() {
        return new User(this);
    }
}