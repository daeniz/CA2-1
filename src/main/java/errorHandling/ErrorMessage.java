/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorHandling;

/**
 *
 * @author edipetres
 */

public class ErrorMessage {

    private String message;
    private int code;
    public ErrorMessage(String msg, int code) {
        this.code = code;
        this.message = msg;        
    }
}
