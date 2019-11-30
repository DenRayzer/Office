package sample;

public class User {
    private int userId;
    private String password;
    private String login;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getImage() {
        return Image;
    }

    public void setImage(Boolean image) {
        Image = image;
    }

    public static User getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(User ourInstance) {
        User.ourInstance = ourInstance;
    }

    private String role = null;
    private Boolean Image = false;
    private static User ourInstance = new User();

    public static User getInstance() {
        return ourInstance;
    }

    private User() {
    }
}
