package br.com.caelum.exemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

class Transacoes {
	private final Connection connection;

	public Transacoes(Connection connection) {
		this.connection = connection;
	}

	public List<Transacao> ultimas(int quantidade) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select valor from Transacao limit ?");
			ps.setInt(1, quantidade);
			ResultSet rs = ps.executeQuery();
			ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
			while (rs.next()) {
				transacoes.add(new Transacao(rs.getDouble("valor")));
			}
			return transacoes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
