package ua.nure.koval.SummaryTask3.entity;

import java.math.BigDecimal;

public class Package {

    protected String packageType;
    protected int amount;
    protected BigDecimal price;

    public Package(String packageType, int amount, BigDecimal price) {
        this.packageType = packageType;
        this.amount = amount;
        this.price = price;
    }

    public Package() {
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String value) {
        packageType = value;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int value) {
        amount = value;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal value) {
        price = value;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageType='" + packageType + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
