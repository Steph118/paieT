/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enumeration;

import java.util.List;

/**
 *
 * @author steph18
 */
public enum EmailProvider {

    GMAIL;

    public static List<EmailProvider> getListProvider() {
        return List.of(EmailProvider.values());
    }
}
