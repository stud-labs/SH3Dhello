package org.isu.sweethome3d.plugin.wpft;

import javax.persistence.*;
import java.awt.color.ColorSpace;
import java.io.Serializable;

/**
 * Created by Katya on 06.06.2018.
 */
@Entity
public class Article implements Serializable  {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String Colors; // ???? ???? ????????. ?????? ??? ?? ?????.

        private String PatternType;

        private String name;

        // @Temporal(TemporalType.TIMESTAMP)

        public Long getId () {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setColors(String Colors) {
        this.Colors = Colors;
    }

    public void setPatternType(String PatternType) {
        this.PatternType = PatternType;
    }

    @ManyToOne
    private Collection collection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollection(Collection col) {
        collection = col;
    }

    public Collection getCollection() {
        return collection;
    }

    public String toString() {
        String s = name+" ";
        if (collection.getName()!="default") {
            s+="/"+collection.getName()+" ";
        }
        return s+"/"+collection.getProducer().getName();
    }
}
