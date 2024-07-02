package view;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.context.PrimeApplicationContext;

import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class App implements Serializable {

    private String theme = "saga";
    private boolean darkMode = false;
    private String inputStyle = "outlined";
    private Locale locale = Locale.US;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public String getInputStyle() {
        return inputStyle;
    }

    public void setInputStyle(String inputStyle) {
        this.inputStyle = inputStyle;
    }

    public String getInputStyleClass() {
        return "filled".equals(this.inputStyle) ? "ui-input-filled" : "";
    }

    public void changeTheme(String theme, boolean darkMode) {
        this.theme = theme;
        this.darkMode = darkMode;
    }

    public String getThemeImage() {
        String result = getTheme();
        switch (result) {
            case "nova-light" -> result = "nova.png";
            case "nova-colored" -> result = "nova-accent.png";
            case "nova-dark" -> result = "nova-alt.png";
            case "bootstrap4-blue-light" -> result = "bootstrap4-light-blue.svg";
            case "bootstrap4-blue-dark" -> result = "bootstrap4-dark-blue.svg";
            case "bootstrap4-purple-light" -> result = "bootstrap4-light-purple.svg";
            case "bootstrap4-purple-dark" -> result = "bootstrap4-dark-purple.svg";
            default -> result += ".png";
        }
        return result;
    }

    public String getPrimeFacesVersion() {
        return PrimeApplicationContext.getCurrentInstance(FacesContext.getCurrentInstance()).getEnvironment().getBuildVersion();
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
