package br.maua.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T> {

	String ID = "id";
	String URL = "url";
	String TITULO = "titulo";
	String SINOPSE = "sinopse";
	String EPISODIOS = "episodios";
	String CAPITULOS = "capitulos";
	String VOLUMES = "volumes";
	String TIPO = "tipo";
	String NOTA = "nota";

	List<T> getAll();
	int escreverEntrada(T t) throws SQLException;
	int apagarEntrada(T t) throws SQLException;
	T getEntradaPorID(int id);
}
