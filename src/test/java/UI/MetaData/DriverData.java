package UI.MetaData;

public enum DriverData {

    WEBDRIVERKEY ("webdriver.chrome.driver"),

    WEBDRIVERVALUE ("chromedriver.exe");

    private String data;

    DriverData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
