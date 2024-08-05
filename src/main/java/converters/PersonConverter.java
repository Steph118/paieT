/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converters;

import bean.MemberBean;
import entities.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author steph18
 */
@Named
@ApplicationScoped
@FacesConverter(value = "personConverter", managed = true)
public class PersonConverter implements Converter<Person> {

    @Inject
    private MemberBean memberBean;

    @Override
    public Person getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return this.getPersonsMap().get(Integer.valueOf(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid country."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Person value) {
        if (value != null) {
            return String.valueOf(value.getId());
        } else {
            return null;
        }
    }

    private Map<Integer, Person> getPersonsMap() {
        return memberBean.getPersons().stream().collect(Collectors.toMap(Person::getId, p -> p));
    }
}
