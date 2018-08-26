package br.edu.devmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.devmedia.config.BDConfig;
import br.edu.devmedia.entidade.Nota;

public class NotaDAO {
	public List<Nota> listarNotas() throws ClassNotFoundException, SQLException {
		List<Nota> lista = new ArrayList<>();		
	
		String sql = "Select * from TB_NOTA";
		
		Connection con = BDConfig.getConnection();
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Nota nota = new Nota();
			nota.setId(rs.getInt("ID"));
			nota.setTitulo(rs.getString("TITULO"));
			nota.setDescricao(rs.getString("DESCRICAO"));
			lista.add(nota);
		}		
		
		return lista;
	}
}
