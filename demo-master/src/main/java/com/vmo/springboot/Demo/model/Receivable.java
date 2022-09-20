package com.vmo.springboot.Demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Table(name = ("Receivable"))
@Builder
public class Receivable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receivable_id")
    private int id;
    private String name;
    private int payment;
    private Date create_at;
    private Date update_at;
    private int status;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "electricbill_id")
    ElectricBill electricBill;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "waterbill_id")
    WaterBill waterBill;

    @ManyToOne()
    @JoinColumn(name = "leases_id")
    Leases leases;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "receivable_service",
            joinColumns = @JoinColumn(name = "receivable_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<ServiceOther> service = new HashSet<>();
    public Receivable() {
    }


}
