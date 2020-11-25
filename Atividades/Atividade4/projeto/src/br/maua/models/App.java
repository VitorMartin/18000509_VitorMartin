package br.maua.models;

import br.maua.api.Jikan;
import br.maua.dao.AnimesDAO;
import br.maua.dao.MangasDAO;
import br.maua.models.cli.Input;
import br.maua.models.cli.Menu;
import br.maua.models.midia.Anime;
import br.maua.models.midia.Manga;
import br.maua.throwables.EntradaNaoEncontradaException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Classe principal para a aplicação. Interfaceia a apicação para o usuário com inputs e outputs.
 */
public class App {
	public void run(){
		Input inp = new Input();

		Jikan jikan;

		Anime anime;
		AnimesDAO animesDAO = new AnimesDAO();

		Manga manga;
		MangasDAO mangasDAO = new MangasDAO();

		Menu.saudacao();

		while (inp.getMenu() != Menu.SAIR){
			Menu.inicio();

			inp.setMenu();

			switch (inp.getMenu()){

				case Menu.ANIME:

					Menu.escolhaAnime();

					inp.setTitulo();

					try {
						System.out.println(animesDAO.getEntradaPorTitulo(inp.getTitulo())); // Procurar titulo na DB
					}

					catch (EntradaNaoEncontradaException ignored) { // Se nao encontrar na DB, pesquisar na API
						try {
							jikan = new Jikan(Jikan.BUSCAR_ANIME, inp.getTitulo());

							Menu.mostrarTitulosEncontrados(jikan.mostrarTitulosEncontrados());

							inp.setMenu();

							anime = new Anime(
									jikan.getMatches().getJSONObject(inp.getMenu()).getInt(Jikan.ID),
									jikan.getMatches().getJSONObject(inp.getMenu()).getString(Jikan.URL),
									jikan.getMatches().getJSONObject(inp.getMenu()).getString(Jikan.TITULO),
									jikan.getMatches().getJSONObject(inp.getMenu()).getString(Jikan.SINOPSE),
									jikan.getMatches().getJSONObject(inp.getMenu()).getInt(Jikan.EPISODIOS),
									jikan.getMatches().getJSONObject(inp.getMenu()).getDouble(Jikan.NOTA)
							);

							System.out.println(anime);
							animesDAO.escreverEntrada(anime);
						}

						catch (InterruptedException | IOException e) { // Exception para API
							e.printStackTrace();
							Menu.caracterIlegal();
						}

						catch (SQLException ignored2) { // Exception para animesDAO.escreverEntrada()
						}
					}
					break;

				case Menu.MANGA:

					Menu.escolhaManga();

					inp.setTitulo();

					try {
						System.out.println(mangasDAO.getEntradaPorTitulo(inp.getTitulo())); // Procurar titulo na DB
					}

					catch (EntradaNaoEncontradaException ignored) { // Se nao encontrar na DB, pesquisar na API
						try {
							jikan = new Jikan(Jikan.BUSCAR_MANGA, inp.getTitulo());

							Menu.mostrarTitulosEncontrados(jikan.mostrarTitulosEncontrados());

							inp.setMenu();

							manga = new Manga(
									jikan.getMatches().getJSONObject(inp.getMenu()).getInt(Jikan.ID),
									jikan.getMatches().getJSONObject(inp.getMenu()).getString(Jikan.URL),
									jikan.getMatches().getJSONObject(inp.getMenu()).getString(Jikan.TITULO),
									jikan.getMatches().getJSONObject(inp.getMenu()).getString(Jikan.SINOPSE),
									jikan.getMatches().getJSONObject(inp.getMenu()).getInt(Jikan.CAPITULOS),
									jikan.getMatches().getJSONObject(inp.getMenu()).getInt(Jikan.VOLUMES),
									jikan.getMatches().getJSONObject(inp.getMenu()).getString(Jikan.TIPO),
									jikan.getMatches().getJSONObject(inp.getMenu()).getDouble(Jikan.NOTA)
							);

							System.out.println(manga);
							mangasDAO.escreverEntrada(manga);
						}

						catch (InterruptedException | IOException e) { // Exception para API
							e.printStackTrace();
							Menu.caracterIlegal();
						}

						catch (SQLException ignored2) { // Exception para animesDAO.escreverEntrada()
						}
					}
					break;

				case Menu.EXIBIR:
					Menu.escolherDB();
					inp.setDB();
					System.out.println(inp.getDB() == Menu.USAR_ANIME ? animesDAO : mangasDAO);
					break;

				case Menu.PESQUISAR:
					Menu.escolherDB();
					inp.setDB(); // Anime ou Manga

					Menu.escolherPesquisa();
					inp.setPesquisa(); // ID ou Titulo

					if (inp.getPesquisa() == Menu.PESQUISAR_ID) {
						Menu.digiteId();
						inp.setID();
					}
					else {
						Menu.digiteTitulo();
						inp.setTitulo();
					}

					try {
						if (inp.getDB() == Menu.USAR_ANIME) {
							if (inp.getPesquisa() == Menu.PESQUISAR_ID) {
								System.out.println(animesDAO.getEntradaPorID(inp.getID()));
							} else {
								System.out.println(animesDAO.getEntradaPorTitulo(inp.getTitulo()));
							}
						} else {
							if (inp.getPesquisa() == Menu.PESQUISAR_ID) {
								System.out.println(mangasDAO.getEntradaPorID(inp.getID()));
							} else {
								System.out.println(mangasDAO.getEntradaPorTitulo(inp.getTitulo()));
							}
						}
					}
					catch (EntradaNaoEncontradaException ignored) {
						Menu.entradaNaoEncontrada();
					}

					break;

				case Menu.APAGAR:
					Menu.escolherDB();
					inp.setDB();

					Menu.escolherPesquisa();
					inp.setPesquisa();

					if (inp.getPesquisa() == Menu.PESQUISAR_ID) {
						Menu.digiteId();
						inp.setID();
					}
					else {
						Menu.digiteTitulo();
						inp.setTitulo();
					}

					try {
						if (inp.getDB() == Menu.USAR_ANIME) {
							if (inp.getPesquisa() == Menu.PESQUISAR_ID) {
								anime = animesDAO.getEntradaPorID(inp.getID());
							}
							else {
								anime = animesDAO.getEntradaPorTitulo(inp.getTitulo());
							}

							System.out.println(anime);
							Menu.confirmarApagar();
							inp.setApagar();
							if (inp.getApagar() == Menu.SIM) animesDAO.apagarEntrada(anime);
						}
						else {
							if (inp.getPesquisa() == Menu.PESQUISAR_ID) {
								manga = mangasDAO.getEntradaPorID(inp.getID());
							}
							else {
								manga = mangasDAO.getEntradaPorTitulo(inp.getTitulo());
							}

							System.out.println(manga);
							Menu.confirmarApagar();
							inp.setApagar();
							if (inp.getApagar() == Menu.SIM) mangasDAO.apagarEntrada(manga);
						}
					}
					catch (EntradaNaoEncontradaException ignored) {
						Menu.entradaNaoEncontrada();
					}
					catch (SQLException ignored2) {
						Menu.falhaAoApagar();
					}
					break;

				case Menu.SAIR:
					Menu.despedida();
					break;

				default:
					Menu.opcaoInvalida();
					break;
			}
		}
	}
}
