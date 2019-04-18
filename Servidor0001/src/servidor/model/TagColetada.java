package servidor.model;

import java.util.Date;
import java.util.logging.Logger;

public class TagColetada {
    private String tag;
    private Date time;

    public TagColetada(String tag, Date time) {
        this.tag = tag;
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
}
