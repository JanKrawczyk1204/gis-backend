package com.template.productservice.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "kebab")
@NoArgsConstructor
@Getter
@Setter
public class KebabEntity extends Kebab {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kebab_id_seq")
    @SequenceGenerator(name = "kebab_id_seq", sequenceName = "kebab_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "uid")
    private String uid;
    @Column(name = "kebab_name")
    private String name;
    @Column(name = "location_x")
    private float locationX;
    @Column(name = "location_y")
    private float locationY;
    @Column(name = "rating")
    private float rating;
    @Column(name = "hours")
    private String hours;
    @Column(name = "address")
    private String address;
    public KebabEntity(long id, String uid, String name, float locationX, float locationY, float rating, String hours, String address) {
        super(uid, name, locationX, locationY,rating, hours, address);
        this.id = id;
    }
}
