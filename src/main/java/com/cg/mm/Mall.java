package com.cg.mm;

import jakarta.persistence.*;


@Entity
@Table(name = "malls") // This annotation specifies the table name in the database
public class Mall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically handle the generation of IDs
    private Long id;

    @Column(name = "name", nullable = false, length = 200) // Specifies the column details in the database
    private String name;

    @Column(name = "location", nullable = true, length = 255) // Optional field for location
    private String location;

    // Constructors
    public Mall() {
    }

    public Mall(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Mall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
