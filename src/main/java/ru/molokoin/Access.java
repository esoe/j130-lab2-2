package ru.molokoin;
public class Access {
    private String link;
    private String login;
    private String password;
    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = "jdbc:MySQL://" + link + ":3306";
    }
    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }
    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

}
