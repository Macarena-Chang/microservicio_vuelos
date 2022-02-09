package dao;

import java.util.List;

import model.Vuelo;

public interface VuelosDao {
	
	public List <Vuelo> devolverVuelos(); //devolver vuelos existentes
	
	public Vuelo devolverVuelo( int idvuelo);//devolver vuelos x identificador
	
	public void actualizarVuelo(Vuelo vuelo); //actualizar determinadovuelo

}
