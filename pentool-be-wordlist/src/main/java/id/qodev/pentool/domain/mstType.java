package id.qodev.pentool.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "mst_type")
public class mstType extends PanacheEntityBase {
    @Id
    @Column(name ="type_id")
    private String typeId;
    @Column(name ="type_name")
    private String typeName;
;
    @Column(name ="type_status")
    private Integer status;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
