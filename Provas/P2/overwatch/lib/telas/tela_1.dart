import 'package:flutter/material.dart';
import 'package:overwatch/models/modelo_ow.dart';
import 'package:overwatch/telas/tela_2.dart';
import 'package:overwatch/utilities/network_helper.dart';

class Tela1 extends StatefulWidget {
  final String title;

  const Tela1({Key key, this.title = 'Home'}) : super(key: key);

  @override
  _Tela1 createState() => _Tela1();
}

class _Tela1 extends State<Tela1> {
  final controlador = TextEditingController();

  ModeloOw dados_modeloow = new ModeloOw();
  CompetitiveStats dados_compstats = new CompetitiveStats();
  CareerStats dados_careerstats = new CareerStats();
  AllHeroes dados_allheroes = new AllHeroes();
  Assists dados_assists = new Assists();
  Best dados_best = new Best();
  Combat dados_combat = new Combat();
  Game dados_game = new Game();
  Games dados_games = new Games();
  Ratings dados_ratings = new Ratings();

  Future fetchImagem() async {
    var requisicao = NetworkHelper(
        url: 'https://ow-api.com/v1/stats/pc/us/${controlador.text}/complete');
    dados_modeloow = ModeloOw.fromJson(await requisicao.getData());
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Column(
          children: [
            SizedBox(
                width: 300,
                height: 300,
                child: Image.network(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Overwatch_circle_logo.svg/1200px-Overwatch_circle_logo.svg.png")),
            //
            TextField(
              controller: controlador,
              decoration: InputDecoration(
                  hintText: "Formato: User-1234 ",
                  labelText: "Informe sua batlletag:",
                  icon: Icon(Icons.drive_file_rename_outline)),
            ),
            //
            RaisedButton(
                color: Colors.grey[500],
                shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(50),
                    side: BorderSide(color: Colors.black)),
                child: Text('Mostrar rank'),
                textColor: Colors.white,
                onPressed: () async {
                  await fetchImagem();
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => Tela2(
                              dadosModeloow: dados_modeloow,
                              dadosCompstats: dados_compstats,
                              dadosCareerstats: dados_careerstats,
                              dadoAllheroes: dados_allheroes,
                              dadosAssists: dados_assists,
                              dadosBest: dados_best,
                              dadosCombat: dados_combat,
                              dadosGame: dados_game,
                              dadosGames: dados_games,
                              dadosRatings: dados_ratings,
                            )),
                  );
                }),
          ],
        ),
      ),
    );
  }
}
