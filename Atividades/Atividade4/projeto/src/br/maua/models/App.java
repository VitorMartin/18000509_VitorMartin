package br.maua.models;

import br.maua.dao.Personagens;
import br.maua.models.cli.Input;
import br.maua.models.cli.Menu;
import br.maua.models.midia.Personagem;
import br.maua.throwables.EntradaNaoEncontradaException;

import java.sql.SQLException;

/**
 * Classe principal para a aplicação. Interfaceia a apicação para o usuário com inputs e outputs.
 */
public class App {
	public void run(){
		Input inp = new Input();

		Personagens dbPersonagens = new Personagens();

		Personagem personagem;

		Menu.saudacao();

		while (inp.getMenu() != Menu.SAIR){
			Menu.inicio();

			inp.setMenu();

			switch (inp.getMenu()){

				case Menu.CRIAR:

					Menu.criar();

					inp.setTitulo();

					try {
						System.out.println(dbPersonagens.getEntradaPorNome(inp.getTitulo())); // Procurar titulo na DB
					}

					catch (EntradaNaoEncontradaException ignored) { // Se nao encontrar na DB, pesquisar na API
						try {
							inp.setMenu();

//							anime = new Anime(							);

//							System.out.println(anime);
//							dbPersonagens.escreverEntrada(anime);
						}

						catch (Exception e/*InterruptedException | IOException e*/) { // Exception para API
							e.printStackTrace();
							Menu.caracterIlegal();
						}

//						catch (SQLException ignored2) { // Exception para dbPersonagens.escreverEntrada()
//						}
					}
					break;

				case Menu.EXIBIR:
					Menu.escolherDB();
					inp.setDB();
					System.out.println(inp.getDB() == Menu.USAR_ANIME ? dbPersonagens : "out");
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
								System.out.println(dbPersonagens.getEntradaPorID(inp.getID()));
							} else {
								System.out.println(dbPersonagens.getEntradaPorNome(inp.getTitulo()));
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
								personagem = dbPersonagens.getEntradaPorID(inp.getID());
							}
							else {
								personagem = dbPersonagens.getEntradaPorNome(inp.getTitulo());
							}

							System.out.println(personagem);
							Menu.confirmarApagar();
							inp.setApagar();
							if (inp.getApagar() == Menu.SIM) dbPersonagens.apagarEntrada(personagem);
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
