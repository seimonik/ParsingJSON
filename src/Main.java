import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        List<Employee> employeeList = new ArrayList<>();

        // 1 работник
        HashMap<String, Period> post = new HashMap<>();
        Period periods = new Period(new GregorianCalendar(2023,01,10),
                new GregorianCalendar(2002,11,10));
        post.put("C# разработчик", periods);

        List<AddressPeriod> address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Саратов", "Московская", "77", 7),
                new Period(new GregorianCalendar(2019,01,10),
                new GregorianCalendar(2023,11,10))));

        HashMap<String, PhoneType> phoneList = new HashMap<>();
        phoneList.put("+8777578204", PhoneType.MobilePhone);
        employeeList.add(new Employee(1, 780053, "Никифоров", "Семен", "Алексеевич",
                        new GregorianCalendar(2002,10,11),
                new Address("Россия", "Саратов", "Московская", "77", 7),
                "6257 959547", new GregorianCalendar(2022,10,11),
                "777-555", post, address, phoneList));

        // 2 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2010,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("Java разработчик (junior)", periods);
        periods = new Period(new GregorianCalendar(2015,05,15),
                new GregorianCalendar(2016,11,10));
        post.put("Java разработчик (junior)", periods);
        periods = new Period(new GregorianCalendar(2010,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("Android разработчик", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Вологда", "Ручейная", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));
        address.add(new AddressPeriod(new Address("Россия", "Вологда", "Абрикосовая", "55", 252),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8778578204", PhoneType.MobilePhone);
        phoneList.put("+8654132554", PhoneType.WorkPhone);
        phoneList.put("52-79-44", PhoneType.HomePhone);
        employeeList.add(new Employee(2, 312891, "Ургант", "Иван", "Андреевич",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Вологда", "Московская", "12", 458),
                "68570 465125", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 3 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2011,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("IOS разработчик (junior)", periods);
        periods = new Period(new GregorianCalendar(2016,05,15),
                new GregorianCalendar(2018,11,10));
        post.put("IOS разработчик (junior)", periods);
        periods = new Period(new GregorianCalendar(2012,05,15),
                new GregorianCalendar(2014,11,10));
        post.put("Android разработчик", periods);
        periods = new Period(new GregorianCalendar(2014,05,15),
                new GregorianCalendar(2016,11,10));
        post.put("Frontend-разработчик", periods);
        periods = new Period(new GregorianCalendar(2018,05,15),
                new GregorianCalendar(2023,11,10));
        post.put("Frontend-разработчик", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Самара", "Тортовая", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));
        address.add(new AddressPeriod(new Address("Россия", "Вологда", "Единорожья", "55", 252),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8775228204", PhoneType.MobilePhone);
        phoneList.put("+8654132554", PhoneType.WorkPhone);
        phoneList.put("52-79-44", PhoneType.HomePhone);
        employeeList.add(new Employee(3, 925172, "Иванов", "Григорий", "Алексеевия",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Самара", "Московская", "12", 458),
                "8521 467725", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 4 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2011,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("Fullstack-разработчик", periods);
        periods = new Period(new GregorianCalendar(2016,05,15),
                new GregorianCalendar(2018,11,10));
        post.put("Fullstack-разработчик", periods);
        periods = new Period(new GregorianCalendar(2012,05,15),
                new GregorianCalendar(2014,11,10));
        post.put("Аналитик данных", periods);
        periods = new Period(new GregorianCalendar(2014,05,15),
                new GregorianCalendar(2016,11,10));
        post.put("Data Scientist", periods);
        periods = new Period(new GregorianCalendar(2018,05,15),
                new GregorianCalendar(2023,11,10));
        post.put("Data Scientist", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Екатеринбург", "Тортовая", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));
        address.add(new AddressPeriod(new Address("Россия", "Саранск", "Сливовая", "55", 252),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8775228204", PhoneType.MobilePhone);
        phoneList.put("+8654132554", PhoneType.WorkPhone);
        phoneList.put("52-79-44", PhoneType.HomePhone);
        employeeList.add(new Employee(4, 520245, "Соломник", "Петр", "Владиславович",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Самара", "Московская", "12", 458),
                "8521 852414", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 5 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2011,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("DevOps-инженер", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Екатеринбург", "Тортовая", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8654132554", PhoneType.WorkPhone);
        employeeList.add(new Employee(5, 520245, "Важная", "Ирина", "Владимировна",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Самара", "Московская", "12", 458),
                "8521 852414", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 6 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2010,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("Java разработчик (junior)", periods);
        periods = new Period(new GregorianCalendar(2010,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("Android разработчик", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Вологда", "Ручейная", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));
        address.add(new AddressPeriod(new Address("Россия", "Вологда", "Абрикосовая", "55", 252),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8778578204", PhoneType.MobilePhone);
        phoneList.put("+8654132554", PhoneType.WorkPhone);
        phoneList.put("52-79-44", PhoneType.HomePhone);
        employeeList.add(new Employee(6, 360904, "Дусмухаметов", "Вячеслав", "Зарлыканович",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Вологда", "Московская", "13", 258),
                "68570 465125", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 7 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2023,01,10),
                new GregorianCalendar(2002,11,10));
        post.put("C# разработчик", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Саратов", "Московская", "77", 7),
                new Period(new GregorianCalendar(2019,01,10),
                        new GregorianCalendar(2023,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8777578204", PhoneType.MobilePhone);
        employeeList.add(new Employee(7, 305173, "Щербакова", "Анна", "Станиславовна",
                new GregorianCalendar(2002,10,10),
                new Address("Россия", "Саратов", "Московская", "77", 7),
                "6257 959547", new GregorianCalendar(2022,10,11),
                "777-555", post, address, phoneList));

        // 8 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2011,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("Fullstack-разработчик", periods);
        periods = new Period(new GregorianCalendar(2016,05,15),
                new GregorianCalendar(2018,11,10));
        post.put("Fullstack-разработчик", periods);
        periods = new Period(new GregorianCalendar(2012,05,15),
                new GregorianCalendar(2014,11,10));
        post.put("Аналитик данных", periods);
        periods = new Period(new GregorianCalendar(2014,05,15),
                new GregorianCalendar(2016,11,10));
        post.put("Data Scientist", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Екатеринбург", "Тортовая", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));
        address.add(new AddressPeriod(new Address("Россия", "Саранск", "Сливовая", "55", 252),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8775228204", PhoneType.MobilePhone);
        phoneList.put("+8654132554", PhoneType.WorkPhone);
        phoneList.put("52-79-44", PhoneType.HomePhone);
        employeeList.add(new Employee(8, 520245, "Соломник", "Петр", "Владиславович",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Самара", "Московская", "12", 458),
                "8521 852414", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 9 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2011,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("DevOps-инженер", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Екатеринбург", "Тортовая", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8654132554", PhoneType.WorkPhone);
        employeeList.add(new Employee(5, 520245, "Асташова", "Алина", "Владимировна",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Самара", "Московская", "12", 458),
                "8521 852414", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 10 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2011,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("IOS разработчик (junior)", periods);
        periods = new Period(new GregorianCalendar(2012,05,15),
                new GregorianCalendar(2014,11,10));
        post.put("Android разработчик", periods);
        periods = new Period(new GregorianCalendar(2014,05,15),
                new GregorianCalendar(2016,11,10));
        post.put("Frontend-разработчик", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Самара", "Тортовая", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));
        address.add(new AddressPeriod(new Address("Россия", "Вологда", "Единорожья", "55", 252),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8775228204", PhoneType.MobilePhone);
        phoneList.put("+8654132554", PhoneType.WorkPhone);
        phoneList.put("52-79-44", PhoneType.HomePhone);
        employeeList.add(new Employee(10, 861681, "Тарелков", "Леонид", "Степанович",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Самара", "Московская", "12", 458),
                "8521 467725", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 11 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2011,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("Дата-инженер", periods);
        periods = new Period(new GregorianCalendar(2016,05,15),
                new GregorianCalendar(2018,11,10));
        post.put("Дата-инженер", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Самара", "Тортовая", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("52-79-44", PhoneType.HomePhone);
        employeeList.add(new Employee(11, 861681, "Тарелков", "Федор", "Степанович",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Самара", "Московская", "12", 458),
                "8521 467725", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // 12 работник
        post = new HashMap<>();
        periods = new Period(new GregorianCalendar(2011,05,15),
                new GregorianCalendar(2012,11,10));
        post.put("Системный администратор", periods);
        periods = new Period(new GregorianCalendar(2016,05,15),
                new GregorianCalendar(2018,11,10));
        post.put("Системный администратор", periods);
        periods = new Period(new GregorianCalendar(2012,05,15),
                new GregorianCalendar(2014,11,10));
        post.put("Fullstack-разработчик", periods);

        address = new ArrayList<>();
        address.add(new AddressPeriod(new Address("Россия", "Самара", "Тортовая", "32/9", 67),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));
        address.add(new AddressPeriod(new Address("Россия", "Вологда", "Единорожья", "55", 252),
                new Period(new GregorianCalendar(2011,01,10),
                        new GregorianCalendar(2022,11,10))));

        phoneList = new HashMap<>();
        phoneList.put("+8775228204", PhoneType.MobilePhone);
        employeeList.add(new Employee(12, 861681, "Баринова", "Елена", "Викторовна",
                new GregorianCalendar(1978,5,14),
                new Address("Россия", "Самара", "Московская", "12", 458),
                "8521 467725", new GregorianCalendar(2012,10,11),
                "852-745", post, address, phoneList));

        // <--------------------------------------------------------------------->

        ObjectMapper objectMapper = new ObjectMapper();
        // для обнаружения всех полей, независимо от их видимости
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("employees.json"), employeeList);

        // <--------------------------------------------------------------------->

        byte[] jsonData = Files.readAllBytes(Paths.get("employees.json"));
        ObjectMapper mapperBack = new ObjectMapper();
        Employee[] resultBack = mapperBack.readValue(jsonData, Employee[].class);
        for (Employee employee : resultBack)
            System.out.println(employee + "\n");
    }
}