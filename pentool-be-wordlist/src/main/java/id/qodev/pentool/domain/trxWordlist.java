package id.qodev.pentool.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_wordlist")
public class trxWordlist extends PanacheEntityBase {
    @Id
    @Column(name ="wordlist_id")
    private String wordlistId;
    @Column(name ="list_id")
    private String listId;
    @Column(name ="type_id")
    private String typeId;
    @Column(name ="status", length = 1)
    private Integer status;
    @Column(name ="created_at")
    private Date createdAt;
    @Column(name ="created_by")
    private String createdBy;
    @Column(name ="updated_at")
    private Date updatedAt;
    @Column(name ="updated_by")
    private String updatedBy;

    public String getWordlistId() {
        return wordlistId;
    }

    public void setWordlistId(String wordlistId) {
        this.wordlistId = wordlistId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
