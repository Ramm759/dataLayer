package com.openclassrooms.datalayer.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produit")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    private int productId;

    @Column(name = "nom")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cout")
    private int cost;

    @OneToMany(
            cascade = CascadeType.ALL, // toutes les actions sur l’entité Produit seront propagées sur l’entité Commentaires.
                                        // Exemple : si on supprime le produit, les commentaires associés seront également supprimés.
            orphanRemoval = true, // true permet d’activer un mécanisme qui garantit la non-existence de commentaire orphelin de son produit.
                                    // Si on supprime un commentaire de la liste des commentaires du Product, alors le commentaire devient orphelin,
                                    // et il est supprimé de la base de données.
            fetch = FetchType.EAGER // Récupération auto des tables liées
    )
    @JoinColumn(name = "produit_id") // champ de la table commentaire
    List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
