package dd.pyrkova.addressbook.model;

import java.util.Objects;

public class UserData {
  private final String id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String emailone;
  private final String emailtwo;
  private final String phonehome;
  private final String phonemobile;
  private final String phonework;
  private final String birthday;
  private final String birthmonth;
  private final String birthyear;
  private String group;

  public UserData(String firstname, String middlename, String lastname, String nickname, String company, String address, String emailone, String emailtwo, String phonehome, String phonemobile, String phonework, String birthday, String birthmonth, String birthyear, String group) {
    this.id = null;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.emailone = emailone;
    this.emailtwo = emailtwo;
    this.phonehome = phonehome;
    this.phonemobile = phonemobile;
    this.phonework = phonework;
    this.birthday = birthday;
    this.birthmonth = birthmonth;
    this.birthyear = birthyear;
    this.group = group;
  }

  public UserData(String id, String firstname, String middlename, String lastname, String nickname, String company, String address, String emailone, String emailtwo, String phonehome, String phonemobile, String phonework, String birthday, String birthmonth, String birthyear, String group) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.emailone = emailone;
    this.emailtwo = emailtwo;
    this.phonehome = phonehome;
    this.phonemobile = phonemobile;
    this.phonework = phonework;
    this.birthday = birthday;
    this.birthmonth = birthmonth;
    this.birthyear = birthyear;
    this.group = group;
  }

  public String getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() { return address; }

  public String getEmailone() {
    return emailone;
  }

  public String getEmailtwo() {
    return emailtwo;
  }

  public String getPhonehome() {
    return phonehome;
  }

  public String getPhonemobile() {
    return phonemobile;
  }

  public String getPhonework() {
    return phonework;
  }

  public String getBirthday() {
    return birthday;
  }

  public String getBirthmonth() {
    return birthmonth;
  }

  public String getBirthyear() {
    return birthyear;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return Objects.equals(id, userData.id) &&
            Objects.equals(firstname, userData.firstname) &&
            Objects.equals(lastname, userData.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}
