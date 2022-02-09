package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService {
	@Autowired
	VuelosDao dao;

	@Override
	public List<Vuelo> recuperarVuelosDisponibles(int plazas) {
		return dao.devolverVuelos().stream().filter(t -> t.getPlazas() >= plazas).collect(Collectors.toList());
		// filtrado para que devuelva lista con valor de "plaza" mayor o igual al valor
		// pasado por parametro
	}

	@Override
	public void actualizarPlazas(int id, int plazas) {
		Vuelo vuelo = dao.devolverVuelo(id); //devuelve el vuelo con ese id
		if (vuelo != null) {
			vuelo.setPlazas(vuelo.getPlazas() - plazas); //modificamos las plazas
			dao.actualizarVuelo(vuelo); //llamamos a actualizarVuelos
		}

	}

}
