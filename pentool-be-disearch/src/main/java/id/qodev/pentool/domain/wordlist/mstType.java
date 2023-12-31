package id.qodev.pentool.domain.wordlist;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "mst_type", schema = "public")
public class mstType extends PanacheEntityBase {
    @Id
    @Column(name ="type_id")
    private String typeId;
    @Column(name ="type_name")
    private String typeName;

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
}
