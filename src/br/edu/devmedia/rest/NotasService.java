package br.edu.devmedia.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.NotaDAO;
import br.edu.devmedia.entidade.Nota;

@Path("/notas")
public class NotasService {

	private static final String CHARSET_UTF8 = ";charset=utf-8";

	private NotaDAO notaDAO;

	@PostConstruct
	private void init() {
		notaDAO = new NotaDAO();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<Nota> listarNotas() {
		List<Nota> lista = null;
		try {
			lista = notaDAO.listarNotas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}