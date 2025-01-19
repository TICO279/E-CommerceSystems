/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solicita_servicio;

/**
 *
 * @author eduar
 */
public interface ISolicitaServicio {
    public void prepara(long quienSoy, String host);
    public long solicitaServicio(int vez); //Cambiar a float para estadisticas
    public void cierra();
    
}
