public class Standard extends Ticket {
    public Standard(String filmName, String showingDay, Time showingTime)
    {//gets ticket of type Standard costing £8.00
        super("Standard",8.00, filmName, showingDay, showingTime);
    }
}
