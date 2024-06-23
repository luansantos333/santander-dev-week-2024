package me.dio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_user")

public class User {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String userName;
    @OneToOne (cascade = CascadeType.ALL)
    private Account accountUser;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> featureList;
    @OneToOne (cascade = CascadeType.ALL)
    private Card userCard;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> newsList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(Account accountUser) {
        this.accountUser = accountUser;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public Card getUserCard() {
        return userCard;
    }

    public void setUserCard(Card userCard) {
        this.userCard = userCard;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
