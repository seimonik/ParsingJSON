import java.text.SimpleDateFormat;

public class AddressPeriod {
    Address address;
    Period period;
    public AddressPeriod(){}
    public AddressPeriod(Address address, Period period){
        this.address=address;
        this.period=period;
    }
    public String toString() {
        return period + " : " + address;
    }

    public Address getAddress() {
        return address;
    }

    public Period getPeriod() {
        return period;
    }
}
