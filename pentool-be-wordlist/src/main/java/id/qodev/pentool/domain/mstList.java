package id.qodev.pentool.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "mst_list")
public class mstList extends PanacheEntityBase {
    @Id
    @Column(name ="list_id")
    private String listId;
    @Column(name ="list_name")
    private String listName;
    @Column(name ="list_status")
    private Integer listStatus;

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

    public Integer getListStatus() {
        return listStatus;
    }

    public void setListStatus(Integer listStatus) {
        this.listStatus = listStatus;
    }
}
