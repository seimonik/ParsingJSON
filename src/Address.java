import java.text.SimpleDateFormat;

public class Address {
    String country;
    String city;
    String street;
    String house;
    Integer flat;
    public Address(){}
    public Address(String country, String city, String street, String house, Integer flat){
        this.country=country;
        this.city=city;
        this.street=street;
        this.house=house;
        this.flat=flat;
    }
    public Address(String country, String city, String street, String house){
        this.country=country;
        this.city=city;
        this.street=street;
        this.house=house;
        this.flat=null;
    }
    public String toString() {
        if (flat != null){
            return "с. " + country+", г. "+city+", ул. "+street+", д. "+house;
        }
        else {
            return "с. " + country+", г. "+city+", ул. "+street+", д. "+house+", кв. " +flat;
        }
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public Integer getFlat() {
        return flat;
    }
}
