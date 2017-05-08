package ldu.guofeng.news.admin.domain;

import javax.persistence.*;

/**
 * Created by GUOFENG on 2017/4/13.
 */
@Entity
@Table(name = "newstype", schema = "newssystem", catalog = "")
public class NewsTypePO {
    private int typeId;
    private String typeName;

    @Id
    @Column(name = "type_id")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
