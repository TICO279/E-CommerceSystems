/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author RGAMBOAH
 */
public class ExcepNoCredito extends Exception
{
    private String msg;
    
    public ExcepNoCredito(int id_clte) {
        msg = "El Cliente " + id_clte + " no tiene credito";;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Excepcion:" + msg;
    }
        
}