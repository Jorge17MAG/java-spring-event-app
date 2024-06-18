package com.idat.events.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_event", nullable=false)
    private Long id;

    @Column(nullable=false, length=30, unique=true)
    private String name;

    @Column(nullable=false, length=100)
    private String location;

    private Date date;

    @Column(nullable=false)
    private Boolean available = true;

    @ManyToOne
    @JoinColumn(name="id_user")
    @JsonIgnore
    private User user;
}
