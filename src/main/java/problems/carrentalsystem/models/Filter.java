package problems.carrentalsystem.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Filter {

    private CarType carType = null;
    private BigDecimal priceStart, priceEnd;
    private DateRange dateRange;

    public Filter(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    public Filter(DateRange dateRange, CarType carType) {
        this.carType = carType;
    }

    public void setPriceRange(BigDecimal priceStart, BigDecimal priceEnd) {
        this.priceStart = priceStart;
        this.priceEnd= priceEnd;
    }

    public BigDecimal getPriceStart() {
        return priceStart;
    }

    public BigDecimal getPriceEnd() {
        return priceEnd;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public CarType getCarType() {
        return carType;
    }

    public boolean isPriceInRange(BigDecimal price) {
        if((priceStart != null && price.compareTo(priceStart)>0) ||
                (priceEnd != null && price.compareTo(priceEnd) < 0)) {
            return false;
        }
        return true;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }
}
