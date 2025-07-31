package problems.carrentalsystem.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Filter {

    private LocalDateTime startTime, endTime;
    private CarType carType = null;
    private BigDecimal priceStart, priceEnd;
    private DateRange dateRange;

    public Filter(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    public Filter(LocalDateTime startTime, LocalDateTime endTime, CarType carType) {
        this.startTime = startTime;
        this.endTime = endTime;
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
}
