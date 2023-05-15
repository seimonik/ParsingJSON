import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Period {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Calendar start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Calendar finish;
    public Period(){}
    public Period(Calendar start, Calendar finish){
        this.start=start;
        this.finish=finish;
    }
    public String toString() {
        return new SimpleDateFormat("dd.MM.yyyy").format(start.getTime()) + " - " + new SimpleDateFormat("dd.MM.yyyy").format(finish.getTime());
    }

    public Calendar getStart() {
        return start;
    }

    public Calendar getFinish() {
        return finish;
    }
}
