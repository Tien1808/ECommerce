package Objects;

public class User {
    private String Username;
    private String Password;
    private String Keyword;

    public User(String username, String password,String keyword) {
        Username = username;
        Password = password;
        Keyword = keyword;
    }

    public String getUsername() {

        return Username;
    }

    public void setUsername(String username) {

        Username = username;
    }

    public String getPassword() {

        return Password;
    }

    public void setPassword(String password) {

        Password = password;
    }

    public String getKeyword(){

        return Keyword;
    }

    public void setKeyword(String keyword){
        Keyword =keyword;
    }
}
