package problems.onlinestockbrokeragesystem.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Stock {

    private String stockId;
    private String name;
    private BigDecimal price;

    public Stock(String stockId, String name, BigDecimal price) {
        this.stockId = stockId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getStockId() {
        return stockId;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
