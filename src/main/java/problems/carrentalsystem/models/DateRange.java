package problems.carrentalsystem.models;

import java.time.LocalDateTime;

public class DateRange {

    private LocalDateTime startTime, endTime;

    public DateRange(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDays() {
        return endTime.compareTo(startTime);
    }

    public boolean isColliding(DateRange other) {
        return !this.endTime.isBefore(other.startTime) && !other.endTime.isBefore(this.startTime);
    }
}
