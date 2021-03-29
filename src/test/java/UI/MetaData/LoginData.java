package UI.MetaData;

public enum LoginData {

    WEBSITEURL ("https://www.saucedemo.com/"),

    USERNAME ("standard_user"),

    PASSWORD ("secret_sauce");

    private String data;

    LoginData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
