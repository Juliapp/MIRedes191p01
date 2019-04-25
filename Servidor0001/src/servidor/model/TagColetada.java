package servidor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author juli
 */
public class TagColetada implements Serializable {
    private String tag;

    /**
     *
     * @param tag
     */
    public TagColetada(String tag) {
        this.tag = tag;
    }

    /**
     *
     * @return
     */
    public String getTag() {
        return tag;
    }
    
}
