package br.maua.models;

import br.maua.api.Jikan;
import br.maua.dao.AnimesDAO;
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
		int inpMenu = Menu.INVALIDO;
		int escolhaDB;
		int escolhaPesquisa;
		int idProcurado = 0;
		String tituloProcurado = "";
		Jikan jikan;
		Anime anime = null;
		AnimesDAO animesDAO = new AnimesDAO();
		Manga manga = null;
		MangasDAO mangasDAO = new MangasDAO();

		Menu.saudacao();

		while (inpMenu != Menu.SAIR){
			Menu.inicio();

			inpMenu = pegarInputEntre0e9();

			switch (inpMenu){

				case Menu.ANIME:

					Menu.escolhaAnime();

					tituloProcurado = sc.nextLine().toLowerCase();

					try {
						System.out.println(animesDAO.getEntradaPorTitulo(tituloProcurado)); // Procurar titulo na DB
					}

					catch (EntradaNaoEncontradaException ignored) { // Se nao encontrar na DB, pesquisar na API
						try {
							jikan = new Jikan(Jikan.BUSCAR_ANIME, tituloProcurado);

							Menu.mostrarTitulosEncontrados(jikan.mostrarTitulosEncontrados());

							inpMenu = pegarInputEntre0e9();

							anime = new Anime(
									jikan.getMatches().getJSONObject(inpMenu).getInt(Jikan.ID),
									jikan.getMatches().getJSONObject(inpMenu).getString(Jikan.URL),
									jikan.getMatches().getJSONObject(inpMenu).getString(Jikan.TITULO),
									jikan.getMatches().getJSONObject(inpMenu).getString(Jikan.SINOPSE),
									jikan.getMatches().getJSONObject(inpMenu).getInt(Jikan.EPISODIOS),
									jikan.getMatches().getJSONObject(inpMenu).getDouble(Jikan.NOTA)
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

					tituloProcurado = sc.nextLine().toLowerCase();

					try {
						System.out.println(mangasDAO.getEntradaPorTitulo(tituloProcurado)); // Procurar titulo na DB
					}

					catch (EntradaNaoEncontradaException ignored) { // Se nao encontrar na DB, pesquisar na API
						try {
							jikan = new Jikan(Jikan.BUSCAR_MANGA, tituloProcurado);

							Menu.mostrarTitulosEncontrados(jikan.mostrarTitulosEncontrados());

							inpMenu = pegarInputEntre0e9();

							manga = new Manga(
									jikan.getMatches().getJSONObject(inpMenu).getInt(Jikan.ID),
									jikan.getMatches().getJSONObject(inpMenu).getString(Jikan.URL),
									jikan.getMatches().getJSONObject(inpMenu).getString(Jikan.TITULO),
									jikan.getMatches().getJSONObject(inpMenu).getString(Jikan.SINOPSE),
									jikan.getMatches().getJSONObject(inpMenu).getInt(Jikan.CAPITULOS),
									jikan.getMatches().getJSONObject(inpMenu).getInt(Jikan.VOLUMES),
									jikan.getMatches().getJSONObject(inpMenu).getString(Jikan.TIPO),
									jikan.getMatches().getJSONObject(inpMenu).getDouble(Jikan.NOTA)
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

				case Menu.EXIBIR:
					Menu.escolherDB();
					inpMenu = pegarInputEntre1e2();
					System.out.println(inpMenu == Menu.USAR_ANIME ? animesDAO : mangasDAO);
					break;

				case Menu.PESQUISAR:
					Menu.escolherDB();
					escolhaDB = pegarInputEntre1e2(); // Anime ou Manga

					Menu.escolherPesquisa();
					escolhaPesquisa = pegarInputEntre1e2(); // ID ou Titulo

					if (escolhaPesquisa == Menu.PESQUISAR_ID) {
						Menu.digiteId();
						idProcurado = pegarInputPositivo();
					}
					else {
						Menu.digiteTitulo();
						tituloProcurado = sc.nextLine().toLowerCase();
					}

					try {
						if (escolhaDB == Menu.USAR_ANIME) {
							if (escolhaPesquisa == Menu.PESQUISAR_ID) {
								System.out.println(animesDAO.getEntradaPorID(idProcurado));
							} else {
								System.out.println(animesDAO.getEntradaPorTitulo(tituloProcurado));
							}
						} else {
							if (escolhaPesquisa == Menu.PESQUISAR_ID) {
								System.out.println(mangasDAO.getEntradaPorID(idProcurado));
							} else {
								System.out.println(mangasDAO.getEntradaPorTitulo(tituloProcurado));
							}
						}
					}
					catch (EntradaNaoEncontradaException ignored) {
						Menu.entradaNaoEncontrada();
					}

					break;

				case Menu.APAGAR:
					Menu.escolherDB();
					escolhaDB = pegarInputEntre1e2();

					Menu.escolherPesquisa();
					escolhaPesquisa = pegarInputEntre1e2();

					if (escolhaPesquisa == Menu.PESQUISAR_ID) {
						Menu.digiteId();
						idProcurado = pegarInputPositivo();
					}
					else {
						Menu.digiteTitulo();
						tituloProcurado = sc.nextLine().toLowerCase();
					}

					try {
						if (escolhaDB == Menu.USAR_ANIME) {
							if (escolhaPesquisa == Menu.PESQUISAR_ID) {
								anime = animesDAO.getEntradaPorID(idProcurado);
							}
							else {
								anime = animesDAO.getEntradaPorTitulo(tituloProcurado);
							}

							System.out.println(anime + "\n-----------");
							Menu.confirmarApagar();
							inpMenu = pegarInputEntre1e2();
							if (inpMenu == Menu.SIM) animesDAO.apagarEntrada(anime);
						}
						else {
							if (escolhaPesquisa == Menu.PESQUISAR_ID) {
								manga = mangasDAO.getEntradaPorID(idProcurado);
							}
							else {
								manga = mangasDAO.getEntradaPorTitulo(tituloProcurado);
							}

							System.out.println(manga + "\n-----------");
							Menu.confirmarApagar();
							inpMenu = pegarInputEntre1e2();
							if (inpMenu == Menu.SIM) mangasDAO.apagarEntrada(manga);
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

	private int pegarInputPositivo(){
		int retorno = Menu.INVALIDO;

		while ( retorno <= 0 ) {
			try {
				retorno = sc.nextInt();
				if ( retorno <= 0 ) throw new ForaDoRangeException();
			}
			catch (InputMismatchException ignored) {
				Menu.naoENumero();
			}
			catch (ForaDoRangeException ignored){
				Menu.foraDoRange(0, null);
			}
			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu
		}

		return retorno;
	}

	private int pegarInputEntre0e9(){
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
				Menu.foraDoRange(0, 9);
			}
			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu
		}

		return retorno;
	}

	private int pegarInputEntre1e2(){
		int retorno = Menu.INVALIDO;

		while ( ! entre1e2(retorno) ) {
			try {
				retorno = sc.nextInt();
				if ( ! entre1e2(retorno)) throw new ForaDoRangeException();
			}
			catch (InputMismatchException ignored) {
				Menu.naoENumero();
			}
			catch (ForaDoRangeException ignored){
				Menu.foraDoRange(1, 2);
			}
			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu
		}

		return retorno;
	}

	private boolean entre0e9(int x){
		return x >= 0 && x <= 9;
	}

	private boolean entre1e2(int x){
		return x >= 1 && x <= 2;
	}
}
