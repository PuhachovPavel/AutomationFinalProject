package UI.MetaData;

public enum YourInformationData {

    FIRSTNAME ("Pavel"),

    LASTNAME ("P"),

    POSTALCODE ("12345");

    private String data;

    YourInformationData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
