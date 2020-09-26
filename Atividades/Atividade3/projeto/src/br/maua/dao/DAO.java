package br.maua.dao;

import br.maua.throwables.EntradaNaoEncontradaException;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface de <i>Data Access Object (DAO)</i>. Declara todos os métodos que a aplicação necessita para manusear a DB.
 *
 * @param <T> Objeto genérico.
 */
public interface DAO <T> {

	String DBFileName = "res/otakuDB.db";

	String ID = "id";
	String URL = "url";
	String TITULO = "titulo";
	String SINOPSE = "sinopse";
	String NOTA = "nota";

	String EPISODIOS = "episodios";

	String CAPITULOS = "capitulos";
	String VOLUMES = "volumes";
	String TIPO = "tipo";

	/**
	 * @return Todas as entradas da DB
	 */
	List<T> getAll();

	/**
	 * Escreve uma entrada nova na DB.
	 *
	 * @param t Objeto a ser escrito.
	 * @throws SQLException
	 */
	void escreverEntrada(T t) throws SQLException;

	/**
	 * Apaga uma entrada da DB.
	 *
	 * @param t Objeto a ser apagado.
	 * @throws SQLException
	 */
	void apagarEntrada(T t) throws SQLException;

	/**
	 * @param id Primary Key a ser procurado.
	 * @return Entrada que possui o ID procurado.
	 * @throws EntradaNaoEncontradaException
	 */
	T getEntradaPorID(int id) throws EntradaNaoEncontradaException;

	/**
	 *
	 * @param titulo Título a ser procurado.
	 * @return Entrada que possui o título procurado. Apenas matches exatos, desconsiderando letras
	 * maiúsculas e minúsculas.
	 * @throws EntradaNaoEncontradaException
	 */
	T getEntradaPorTitulo(String titulo) throws EntradaNaoEncontradaException;
}
