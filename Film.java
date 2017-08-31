import java.util.Arrays;
import java.util.List;

public class Film {
    private String filmName;
    private int[] showingDays;
    private List<Time> showingTimes;

    public Film(String filmName, int[] showingDays, List<Time> showingTimes)
    {
        this.filmName = filmName;
        this.showingDays = showingDays;
        this.showingTimes = showingTimes;
    }
    public Film(String filmName, int[] showingDays)
    {
        this(filmName, showingDays, Arrays.asList(new Time(8,0),new Time(12,30),new Time(17,0)));
    }
    public Film(String filmName)
    {
        this(filmName,new int[] {1,1,1,1,1,1,1});
    }
    public String getFilmName()
    {
        return this.filmName;
    }
    public int[] getShowingDays()
    {
        return this.showingDays;
    }
    public List<Time> getShowingTimes()
    {
        return this.showingTimes;
    }
    public String toString() {
        return this.filmName;
    }
}
