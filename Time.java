public class Time {
    private int hour;
    private int minute;
    public Time(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
    }
    public String toString() {
        return String.format("%02d",hour) + ":" + String.format("%02d",minute);
    }
}
