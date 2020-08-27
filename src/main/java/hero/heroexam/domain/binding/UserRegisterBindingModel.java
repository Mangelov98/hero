package hero.heroexam.domain.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserRegisterBindingModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String country;

    public UserRegisterBindingModel() {
    }

    @Length(min = 2, message = "Username length must be more than two characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Email(message = " Enter valid email!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min = 2, message = "Password length must be more than two characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Length(min = 2, message = "Country length must be more than two characters!")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
