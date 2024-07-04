package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("CD")
@NamedQuery(name="Cd.getAllCdsFromArtist",query = "select c from Cd c where LOWER(c.artist)=LOWER(:artist)")
public class Cd extends Product{
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "productNumber=" + getProductNumber() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
