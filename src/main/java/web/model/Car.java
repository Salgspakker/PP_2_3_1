package web.model;

public class Car {
    private int vin;
    private String firm;
    private String model;

    public Car() {

    }
    public Car(int vin, String firm, String model) {
        this.vin = vin;
        this.firm = firm;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }
}
