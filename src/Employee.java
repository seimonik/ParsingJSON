import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Comparable <Employee>{
    int id;
    int passNumber;
    String surname;
    String name;
    String patronymic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Calendar birthdate;
    Address birthplace;
    String passportNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Calendar whenIssued;
    String divisionCode;
    HashMap<String, Period> post;
    List<AddressPeriod> placesOfLiving;
    HashMap<String, PhoneType> phoneList;
    public Employee(){}
    public Employee(int id, int passNumber, String surname, String name, String patronymic, Calendar birthdate,
                    Address birthplace, String passportNumber, Calendar whenIssued, String divisionCode,
                    HashMap<String, Period> post, List<AddressPeriod> placesOfLiving, HashMap<String, PhoneType> phoneList){
        this.id = id;
        this.passNumber=passNumber;
        this.surname=surname;
        this.name=name;
        this.patronymic=patronymic;
        this.birthdate=birthdate;
        this.birthplace=birthplace;
        this.passportNumber=passportNumber;
        this.whenIssued=whenIssued;
        this.divisionCode=divisionCode;
        this.post=post;
        this.placesOfLiving=placesOfLiving;
        this.phoneList=phoneList;
    }
//    public Employee(int id, int passNumber, String surname, String name, String patronymic, Calendar birthdate,
//                    Address birthplace, String passportNumber, Calendar whenIssued, String divisionCode){
//        this.id = id;
//        this.passNumber=passNumber;
//        this.surname=surname;
//        this.name=name;
//        this.patronymic=patronymic;
//        this.birthdate=birthdate;
//        this.birthplace=birthplace;
//        this.passportNumber=passportNumber;
//        this.whenIssued=whenIssued;
//        this.divisionCode=divisionCode;
//    }

    public String toString() {
        return "<Сотрудник " + id + ": \n" +
                "Номер пропуска: " + passNumber + "\n"+
                "ФИО: " + surname +" "+name+" "+patronymic+"\n"+
                "Дата рождения: " + new SimpleDateFormat("dd.MM.yyyy").format(birthdate.getTime()) + "\n"+
                "Место рождения: " + birthplace + "\n"+
                "Номер паспорта: "+passportNumber + "\n"+
                "Когда выдан: "+new SimpleDateFormat("dd.MM.yyyy").format(whenIssued.getTime())+"\n"+
                "Код подразделения: "+divisionCode+"\n"+
                "Занимаемые должности: "+post+"\n"+
                "Адреса проживания: "+placesOfLiving+"\n"+
                "Телефоны: "+phoneList;
    }

        public int maxYearsPosition(){
        int max = 0;
        for (Map.Entry<String, Period> entry :
                post.entrySet()) {
            int curPeriod = entry.getValue().finish.get(Calendar.YEAR) - entry.getValue().start.get(Calendar.YEAR);
            if(curPeriod > max){
                max = curPeriod;
            }
        }
        return max;
    }
    public int GeneralExperience(){
        int experience = 0;
        for (Map.Entry<String, Period> entry :
                post.entrySet()) {
            int curPeriod = entry.getValue().finish.get(Calendar.YEAR) - entry.getValue().start.get(Calendar.YEAR);
            experience += curPeriod;
        }
        return experience;
    }
    @Override
    public int compareTo(Employee other) {
        if (GeneralExperience() > other.GeneralExperience()) return 1;
        else if (GeneralExperience() < other.GeneralExperience()) return -1;
        else return 0;
    }
    public int getPassNumber() {
        return passNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public Address getBirthplace() {
        return birthplace;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Calendar getWhenIssued() {
        return whenIssued;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public HashMap<String, Period> getPost() {
        return post;
    }

    public List<AddressPeriod> getPlacesOfLiving() {
        return placesOfLiving;
    }

    public HashMap<String, PhoneType> getPhoneList() {
        return phoneList;
    }

    public int getId() {
        return id;
    }
}
