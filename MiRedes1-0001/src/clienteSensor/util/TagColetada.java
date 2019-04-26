
package clienteSensor.util;

import java.io.Serializable;

public class TagColetada implements Serializable {
    private String tag;
    private Time time;

    /**
     *
     * @param tag
     */
    public TagColetada(String tag, Time time){
        this.tag = tag;
        this.time = time;
    }

    /**
     *
     * @return
     */
    public String getTag() {
        return tag;
    }

    /**
     *
     * @return
     */
    
    public Time getTime() {
        return time;
    }
    
}