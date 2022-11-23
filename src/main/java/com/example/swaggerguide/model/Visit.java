package com.example.swaggerguide.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "date")
    private OffsetDateTime date;

    @Column(name = "complete")
    private Boolean complete;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Pet getPet() {return pet;}

    public void setPet(Pet pet) {this.pet = pet;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public OffsetDateTime getDate() {return date;}

    public void setDate(OffsetDateTime date) {this.date = date;}

    public Boolean getComplete() {return complete;}

    public void setComplete(Boolean complete) {this.complete = complete;}

}