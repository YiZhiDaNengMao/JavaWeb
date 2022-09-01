package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String realname;
    private String gender;
    private Date birthday;

    public User() {
    }

    public User(int id, String username, String password, String email,
                String realname, String gender, Date birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.realname = realname;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = null;
        try {
            date = sdf.parse(birthday);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.birthday = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(realname, user.realname) && Objects.equals(gender, user.gender) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, realname, gender, birthday);
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
