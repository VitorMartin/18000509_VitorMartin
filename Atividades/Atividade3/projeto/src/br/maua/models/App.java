package br.maua.models;

import br.maua.api.Jikan;
import br.maua.dao.AnimesDAO;
import br.maua.dao.DAO;
import br.maua.dao.MangasDAO;
import br.maua.models.midia.Anime;
import br.maua.models.midia.Manga;
import br.maua.throwables.EntradaNaoEncontradaException;
import br.maua.throwables.ForaDoRangeException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	private final Scanner sc = new Scanner(System.in);

	public void run(){
		int inp = Menu.INVALIDO;
		String titulo;
		Jikan jikan;
		Anime anime;
		AnimesDAO animesDAO = new AnimesDAO();
		Manga manga;
		MangasDAO mangasDAO = new MangasDAO();

		Menu.saudacao();

		while (inp != Menu.SAIR){
			Menu.inicio();

			inp = pegarInput();

			switch (inp){

				case Menu.ANIME:

					Menu.escolhaAnime();

					titulo = sc.nextLine().toLowerCase();

					try {
						System.out.println(animesDAO.getEntradaPorTitulo(titulo)); // Procurar titulo na DB
					}

					catch (EntradaNaoEncontradaException ignored) { // Se nao encontrar na DB, pesquisar na API
						try {
							jikan = new Jikan(Jikan.BUSCAR_ANIME, titulo);

							Menu.mostrarTitulosEncontrados(jikan.mostrarTitulosEncontrados());

							inp = pegarInput();

							anime = new Anime(
									jikan.getMatches().getJSONObject(inp).getInt(Jikan.ID),
									jikan.getMatches().getJSONObject(inp).getString(Jikan.URL),
									jikan.getMatches().getJSONObject(inp).getString(Jikan.TITULO),
									jikan.getMatches().getJSONObject(inp).getString(Jikan.SINOPSE),
									jikan.getMatches().getJSONObject(inp).getInt(Jikan.EPISODIOS),
									jikan.getMatches().getJSONObject(inp).getDouble(Jikan.NOTA)
							);

							animesDAO.escreverEntrada(anime);
							System.out.println(anime);
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

					titulo = sc.nextLine().toLowerCase();

					try {
						System.out.println(mangasDAO.getEntradaPorTitulo(titulo)); // Procurar titulo na DB
					}

					catch (EntradaNaoEncontradaException ignored) { // Se nao encontrar na DB, pesquisar na API
						try {
							jikan = new Jikan(Jikan.BUSCAR_MANGA, titulo);

							Menu.mostrarTitulosEncontrados(jikan.mostrarTitulosEncontrados());

							inp = pegarInput();

							manga = new Manga(
									jikan.getMatches().getJSONObject(inp).getInt(Jikan.ID),
									jikan.getMatches().getJSONObject(inp).getString(Jikan.URL),
									jikan.getMatches().getJSONObject(inp).getString(Jikan.TITULO),
									jikan.getMatches().getJSONObject(inp).getString(Jikan.SINOPSE),
									jikan.getMatches().getJSONObject(inp).getInt(Jikan.CAPITULOS),
									jikan.getMatches().getJSONObject(inp).getInt(Jikan.VOLUMES),
									jikan.getMatches().getJSONObject(inp).getString(Jikan.TIPO),
									jikan.getMatches().getJSONObject(inp).getDouble(Jikan.NOTA)
							);

							mangasDAO.escreverEntrada(manga);
							System.out.println(manga);
						}

						catch (InterruptedException | IOException e) { // Exception para API
							e.printStackTrace();
							Menu.caracterIlegal();
						}

						catch (SQLException ignored2) { // Exception para animesDAO.escreverEntrada()
						}
					}
					break;

				case 6: // ver DB animes
					animesDAO.getAll().forEach(an -> System.out.println(an + "\n----------"));
					break;

				case 7: // pesquisar na DB animes
					System.out.println("id : ");
					int id = sc.nextInt();
					sc.nextLine();
					for (Anime an : animesDAO.getAll()){
						if (id == an.getId()) {
							System.out.println(an);
							break;
						}
					}
					break;

				case 8: // apagarEntrada entradas na DB animes
					inp = sc.nextInt();
					sc.nextLine();
					try {
						animesDAO.apagarEntrada(animesDAO.getEntradaPorID(inp));
					}
					catch (SQLException throwables) {
						throwables.printStackTrace();
					}
					catch (NullPointerException ignored){
						System.out.println("id nao encontrado");
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

	private int pegarInput(){
		// Aceitar apenas valores entre 0 e 9

		int retorno = Menu.INVALIDO;

		while ( ! entre0e9(retorno) ) {
			try {
				retorno = sc.nextInt();
				if ( ! entre0e9(retorno)) throw new ForaDoRangeException();
			}
			catch (InputMismatchException ignored) {
				Menu.naoENumero();
			}
			catch (ForaDoRangeException ignored){
				Menu.foraDoRange();
			}
			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu
		}

		return retorno;
	}

	private boolean entre0e9(int x){
		return x >= 0 && x <= 9;
	}
}
