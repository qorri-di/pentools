package id.qodev.pentool.common.helpers;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.text.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    public List<String> getList(String keyword){
        List<String> word = new ArrayList<>();
        String[] input = keyword.replaceAll(" ","").split("\n");
        Collections.addAll(word, input);
        word.sort((String::compareToIgnoreCase));
        return word;
    }
}
