package com.openclassrooms.datalayer.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categorie_id")
    private int categoryId;

    @Column(name="nom")
    private String name;

    @ManyToMany(
            fetch = FetchType.LAZY, // à la récupération de la catégorie, les produits ne sont pas récupérés
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE // nous ne voulons pas un CascadeType.ALL qui impliquerait une cascade dans le cas de la suppression.
                    // Je spécifie donc uniquement PERSIST et MERGE, la cascade s’applique donc tant en création qu’en modification.
            }
    )
    @JoinTable(
            name = "categorie_produit", // nom de la table de jointure en base de données
            joinColumns = @JoinColumn(name = "categorie_id"), // clé étrangère dans la table de jointure
            inverseJoinColumns = @JoinColumn(name = "produit_id") // clé étrangère dans la table de jointure de la seconde entité concernée par la relation
    )
    private List<Product> products = new ArrayList<>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
