package br.maua.models;

import br.maua.dao.PersonagensDAO;
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

		PersonagensDAO dbPersonagensDAO = new PersonagensDAO();

		Personagem personagem;

		Menu.saudacao();

		while (inp.getMenu() != Menu.SAIR){
			Menu.inicio();

			inp.setMenu();

			switch (inp.getMenu()){

				case Menu.CRIAR:
					Menu.criarNome();
					inp.setNome();
					try {
						System.out.println(dbPersonagensDAO.getEntradaPorNome(inp.getNome())); // Procurar titulo na DB
						Menu.entradaJaExiste();
					}

					catch (EntradaNaoEncontradaException ignored) { // Se nao encontrar na DB, criarNome entrada
						try {
							inp.setPersonagem();
							personagem = new Personagem(inp.getPersonagem());
							System.out.println(personagem);
							dbPersonagensDAO.escreverEntrada(personagem);
						}

						catch (SQLException ignored2) { // Exception para dbPersonagensDAO.escreverEntrada()
						}
					}
					break;

				case Menu.EXIBIR:
					System.out.println(dbPersonagensDAO);
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
						inp.setNome();
					}

					try {
						if (inp.getDB() == Menu.USAR_ANIME) {
							if (inp.getPesquisa() == Menu.PESQUISAR_ID) {
								System.out.println(dbPersonagensDAO.getEntradaPorID(inp.getID()));
							} else {
								System.out.println(dbPersonagensDAO.getEntradaPorNome(inp.getNome()));
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
						inp.setNome();
					}

					try {
						if (inp.getDB() == Menu.USAR_ANIME) {
							if (inp.getPesquisa() == Menu.PESQUISAR_ID) {
								personagem = dbPersonagensDAO.getEntradaPorID(inp.getID());
							}
							else {
								personagem = dbPersonagensDAO.getEntradaPorNome(inp.getNome());
							}

							System.out.println(personagem);
							Menu.confirmarApagar();
							inp.setApagar();
							if (inp.getApagar() == Menu.SIM) dbPersonagensDAO.apagarEntrada(personagem);
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
