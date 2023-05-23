package ru.molokoin;
public class Access {
    private String link;
    private String host;
    private String port;
    private String driver;
    private String login;
    private String password;
    /**
     * @param link the link to set
     */
    public void setLink() {
        this.link = driver + "://" + host + ":"+port;
        
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
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    
    

}
