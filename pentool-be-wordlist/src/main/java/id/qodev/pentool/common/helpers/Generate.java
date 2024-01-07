package id.qodev.pentool.common.helpers;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.text.*;
import java.util.Date;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class Generate {
    public String typeId(){
        return "TYP-" + date();
    }

    public String listId(){
        return "LID-" + date();
    }

    public String wordlistId(){
        return "WLI-" + date();
    }

    private String date(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
}
