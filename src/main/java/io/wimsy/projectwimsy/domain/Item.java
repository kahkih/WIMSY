package io.wimsy.projectwimsy.domain;

import javax.persistence.*;

@Entity
public class Item {
	
	public Item() {}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long itemId;

    @Column(nullable=false)
    private String itemName;

    @Column(nullable=false)
    private String itemDescription;

    public long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

}