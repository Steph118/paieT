/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;


/**
 * @author steph18
 */
public class FileNotFoundException extends BusinessException {

    public FileNotFoundException() {
    }

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(Exception cause) {
        super(cause);
    }

    public FileNotFoundException(String message, Exception cause) {
        super(message, cause);
    }
}
