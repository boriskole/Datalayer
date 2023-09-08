package nl.scalda.example.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naam;

    @Column(nullable = false)
    private Double prijs;

    public Product() { }

    public Product(Long id, String naam, Double prijs) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
    }

    public Product(String naam, Double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());

        return result;

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Product p = (Product) obj;

        return Objects.equals(id, p.id);

    }

    @Override
    public String toString() {
        return naam;
    }

}
