/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

import jakarta.ejb.ApplicationException;

/**
 * @author steph18
 */
@ApplicationException
public class BusinessException extends RuntimeException {

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Exception cause) {
        super(cause);
    }

    public BusinessException(String message, Exception cause) {
        super(message, cause);
    }
}
