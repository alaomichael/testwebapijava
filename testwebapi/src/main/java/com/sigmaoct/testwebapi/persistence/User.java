package com.sigmaoct.testwebapi.persistence;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "userprofile")

public class User {
    @Id
    @GeneratedValue(generator ="uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
}
