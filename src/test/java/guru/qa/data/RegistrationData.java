package guru.qa.data;


import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.*;

import static guru.qa.util.RandomUtils.*;

public class RegistrationData {

    private String
            firstName, lastName,
            gender,
            number,
            email,
            address,
            birthYear, birthMonth, birthDay,
            state, city,
            fileURL = "picture.jpg";

    private ArrayList<String>
            hobbies,
            subjects;

    //Пустой конструктор генерирует рандомные значения полей_______________

    public RegistrationData() {

        fillStatesAndCities();
        Faker faker = new Faker();
        Random random = new Random();
        LocalDate birthDate = getRandomBirthday();
        String[] randomStateCity = getMapRandomCouple(STATESxCITIES);

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        gender = GENDERS[random.nextInt(GENDERS.length)];
        number = faker.regexify("[0-9]{10}");
        birthYear = String.valueOf(birthDate.getYear());
        birthMonth = birthDate.getMonth().toString();
        birthDay = String.valueOf(birthDate.getDayOfMonth());
        address = faker.address().cityName() + ", "
                + faker.address().streetAddress() + ", "
                + faker.address().buildingNumber();
        hobbies = getRandomSubArray(HOBBIES);
        subjects = getRandomSubArray(SUBJECTS);
        state = randomStateCity[0];
        city = randomStateCity[1];
    }
    //_________________________________________________________________

    // Все доступные значения форм с выбором из списка_______________
    private static String[]
            GENDERS = {"Male", "Female", "Other"},
            HOBBIES = {"Sports", "Reading", "Music"},
            SUBJECTS = {
                    "Maths", "Accounting", "Arts",
                    "Social Studies", "Biology", "Physics",
                    "Chemistry", "Computer Science",
                    "Commerce", "Economics", "Civics",
                    "Hindi", "English", "History"};

    private static HashMap<String, String[]> STATESxCITIES = new HashMap<>();

    private static void fillStatesAndCities() {
        STATESxCITIES.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        STATESxCITIES.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        STATESxCITIES.put("Haryana", new String[]{"Karnal", "Panipat"});
        STATESxCITIES.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    //_______________________________________________________________


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        birthMonth = birthMonth.replace(birthMonth.substring(0, 1), birthMonth.substring(0, 1).toUpperCase());
        birthMonth = birthMonth.replace(birthMonth.substring(1), birthMonth.substring(1).toLowerCase());
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        if (birthDay.length() == 1) birthDay = "0" + birthDay;
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public String getFileURL() {
        return this.fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }
}
