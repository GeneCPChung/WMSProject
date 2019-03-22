package practice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class InventoryItem {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String barcode;
    private int quantity;
    private LocalDate date;
    private String unit;
    private String location;
    private double price;
    private String description;

    public InventoryItem() {
    }

    public InventoryItem(String barcode, int quantity, LocalDate date, String name, String unit, String location,
                         double price, String description) {
        this.barcode = barcode;
        this.quantity = quantity;
        this.date = date;
        this.name = name;
        this.unit = unit;
        this.location = location;
        this.price = price;
        this.description = description;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpirationDate() {
        return date;
    }

    public String getUnit() {
        return unit;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExpireDateFromToday() {
        return getExpirationDate().compareTo(LocalDate.now());
    }

    public Boolean isExpired() {
        return getExpireDateFromToday() < 0;
    }

    public Boolean isExpiringTomorrow() {
        return getExpireDateFromToday() == 0;
    }

    public Boolean isSoonToExpire() {
        return getExpireDateFromToday() == 1;
    }

    public Boolean isOnWarningList() {
        return isExpiringTomorrow() || isSoonToExpire() || isExpired();
    }
}