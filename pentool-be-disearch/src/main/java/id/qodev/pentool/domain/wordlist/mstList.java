package id.qodev.pentool.domain.wordlist;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "mst_list", schema = "public")
public class mstList extends PanacheEntityBase {
    @Id
    @Column(name ="list_id")
    private String listId;
    @Column(name ="list_name")
    private String listName;

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
