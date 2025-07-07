/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.interfaces;

import entities.EmailConfig;
import enumeration.EmailProvider;
import java.util.Optional;

/**
 * @author steph18
 */
public interface EmailConfigServiceLocal extends GenericServiceLocal<EmailConfig, Long> {

    Optional<EmailConfig> findByActiveAndProvider(EmailProvider provider);

}
