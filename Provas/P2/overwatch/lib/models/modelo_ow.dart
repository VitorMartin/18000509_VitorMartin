class ModeloOw {
  CompetitiveStats _competitiveStats;
  int _gamesWon;
  String _icon;
  int _level;
  int _prestige;
  int _rating;
  String _ratingIcon;
  List<Ratings> _ratings;

  ModeloOw(
      {CompetitiveStats competitiveStats,
      int gamesWon,
      String icon,
      int level,
      int prestige,
      int rating,
      String ratingIcon,
      List<Ratings> ratings}) {
    this._competitiveStats = competitiveStats;
    this._gamesWon = gamesWon;
    this._icon = icon;
    this._level = level;
    this._prestige = prestige;
    this._rating = rating;
    this._ratingIcon = ratingIcon;
    this._ratings = ratings;
  }

  CompetitiveStats get competitiveStats => _competitiveStats;
  set competitiveStats(CompetitiveStats competitiveStats) =>
      _competitiveStats = competitiveStats;
  int get gamesWon => _gamesWon;
  set gamesWon(int gamesWon) => _gamesWon = gamesWon;
  String get icon => _icon;
  set icon(String icon) => _icon = icon;
  int get level => _level;
  set level(int level) => _level = level;
  int get prestige => _prestige;
  set prestige(int prestige) => _prestige = prestige;
  int get rating => _rating;
  set rating(int rating) => _rating = rating;
  String get ratingIcon => _ratingIcon;
  set ratingIcon(String ratingIcon) => _ratingIcon = ratingIcon;
  List<Ratings> get ratings => _ratings;
  set ratings(List<Ratings> ratings) => _ratings = ratings;

  ModeloOw.fromJson(Map<String, dynamic> json) {
    _competitiveStats = json['competitiveStats'] != null
        ? new CompetitiveStats.fromJson(json['competitiveStats'])
        : null;
    _gamesWon = json['gamesWon'];
    _icon = json['icon'];
    _level = json['level'];
    _prestige = json['prestige'];
    _rating = json['rating'];
    _ratingIcon = json['ratingIcon'];
    if (json['ratings'] != null) {
      _ratings = new List<Ratings>();
      json['ratings'].forEach((v) {
        _ratings.add(new Ratings.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._competitiveStats != null) {
      data['competitiveStats'] = this._competitiveStats.toJson();
    }
    data['gamesWon'] = this._gamesWon;
    data['icon'] = this._icon;
    data['level'] = this._level;
    data['prestige'] = this._prestige;
    data['rating'] = this._rating;
    data['ratingIcon'] = this._ratingIcon;
    if (this._ratings != null) {
      data['ratings'] = this._ratings.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class CompetitiveStats {
  CareerStats _careerStats;
  Games _games;

  CompetitiveStats({CareerStats careerStats, Games games}) {
    this._careerStats = careerStats;
    this._games = games;
  }

  CareerStats get careerStats => _careerStats;
  set careerStats(CareerStats careerStats) => _careerStats = careerStats;
  Games get games => _games;
  set games(Games games) => _games = games;

  CompetitiveStats.fromJson(Map<String, dynamic> json) {
    _careerStats = json['careerStats'] != null
        ? new CareerStats.fromJson(json['careerStats'])
        : null;
    _games = json['games'] != null ? new Games.fromJson(json['games']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._careerStats != null) {
      data['careerStats'] = this._careerStats.toJson();
    }
    if (this._games != null) {
      data['games'] = this._games.toJson();
    }
    return data;
  }
}

class CareerStats {
  AllHeroes _allHeroes;

  CareerStats({AllHeroes allHeroes}) {
    this._allHeroes = allHeroes;
  }

  AllHeroes get allHeroes => _allHeroes;
  set allHeroes(AllHeroes allHeroes) => _allHeroes = allHeroes;

  CareerStats.fromJson(Map<String, dynamic> json) {
    _allHeroes = json['allHeroes'] != null
        ? new AllHeroes.fromJson(json['allHeroes'])
        : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._allHeroes != null) {
      data['allHeroes'] = this._allHeroes.toJson();
    }
    return data;
  }
}

class AllHeroes {
  Assists _assists;
  Best _best;
  Combat _combat;
  Game _game;

  AllHeroes({Assists assists, Best best, Combat combat, Game game}) {
    this._assists = assists;
    this._best = best;
    this._combat = combat;
    this._game = game;
  }

  Assists get assists => _assists;
  set assists(Assists assists) => _assists = assists;
  Best get best => _best;
  set best(Best best) => _best = best;
  Combat get combat => _combat;
  set combat(Combat combat) => _combat = combat;
  Game get game => _game;
  set game(Game game) => _game = game;

  AllHeroes.fromJson(Map<String, dynamic> json) {
    _assists =
        json['assists'] != null ? new Assists.fromJson(json['assists']) : null;
    _best = json['best'] != null ? new Best.fromJson(json['best']) : null;
    _combat =
        json['combat'] != null ? new Combat.fromJson(json['combat']) : null;
    _game = json['game'] != null ? new Game.fromJson(json['game']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._assists != null) {
      data['assists'] = this._assists.toJson();
    }
    if (this._best != null) {
      data['best'] = this._best.toJson();
    }
    if (this._combat != null) {
      data['combat'] = this._combat.toJson();
    }
    if (this._game != null) {
      data['game'] = this._game.toJson();
    }
    return data;
  }
}

class Assists {
  int _healingDone;

  Assists({int healingDone}) {
    this._healingDone = healingDone;
  }

  int get healingDone => _healingDone;
  set healingDone(int healingDone) => _healingDone = healingDone;

  Assists.fromJson(Map<String, dynamic> json) {
    _healingDone = json['healingDone'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['healingDone'] = this._healingDone;
    return data;
  }
}

class Best {
  int _allDamageDoneMostInGame;
  int _barrierDamageDoneMostInGame;
  int _eliminationsMostInGame;
  int _healingDoneMostInGame;
  int _heroDamageDoneMostInGame;
  int _meleeFinalBlowsMostInGame;

  Best(
      {int allDamageDoneMostInGame,
      int barrierDamageDoneMostInGame,
      int eliminationsMostInGame,
      int healingDoneMostInGame,
      int heroDamageDoneMostInGame,
      int meleeFinalBlowsMostInGame}) {
    this._allDamageDoneMostInGame = allDamageDoneMostInGame;
    this._barrierDamageDoneMostInGame = barrierDamageDoneMostInGame;
    this._eliminationsMostInGame = eliminationsMostInGame;
    this._healingDoneMostInGame = healingDoneMostInGame;
    this._heroDamageDoneMostInGame = heroDamageDoneMostInGame;
    this._meleeFinalBlowsMostInGame = meleeFinalBlowsMostInGame;
  }

  int get allDamageDoneMostInGame => _allDamageDoneMostInGame;
  set allDamageDoneMostInGame(int allDamageDoneMostInGame) =>
      _allDamageDoneMostInGame = allDamageDoneMostInGame;
  int get barrierDamageDoneMostInGame => _barrierDamageDoneMostInGame;
  set barrierDamageDoneMostInGame(int barrierDamageDoneMostInGame) =>
      _barrierDamageDoneMostInGame = barrierDamageDoneMostInGame;
  int get eliminationsMostInGame => _eliminationsMostInGame;
  set eliminationsMostInGame(int eliminationsMostInGame) =>
      _eliminationsMostInGame = eliminationsMostInGame;
  int get healingDoneMostInGame => _healingDoneMostInGame;
  set healingDoneMostInGame(int healingDoneMostInGame) =>
      _healingDoneMostInGame = healingDoneMostInGame;
  int get heroDamageDoneMostInGame => _heroDamageDoneMostInGame;
  set heroDamageDoneMostInGame(int heroDamageDoneMostInGame) =>
      _heroDamageDoneMostInGame = heroDamageDoneMostInGame;
  int get meleeFinalBlowsMostInGame => _meleeFinalBlowsMostInGame;
  set meleeFinalBlowsMostInGame(int meleeFinalBlowsMostInGame) =>
      _meleeFinalBlowsMostInGame = meleeFinalBlowsMostInGame;

  Best.fromJson(Map<String, dynamic> json) {
    _allDamageDoneMostInGame = json['allDamageDoneMostInGame'];
    _barrierDamageDoneMostInGame = json['barrierDamageDoneMostInGame'];
    _eliminationsMostInGame = json['eliminationsMostInGame'];
    _healingDoneMostInGame = json['healingDoneMostInGame'];
    _heroDamageDoneMostInGame = json['heroDamageDoneMostInGame'];
    _meleeFinalBlowsMostInGame = json['meleeFinalBlowsMostInGame'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['allDamageDoneMostInGame'] = this._allDamageDoneMostInGame;
    data['barrierDamageDoneMostInGame'] = this._barrierDamageDoneMostInGame;
    data['eliminationsMostInGame'] = this._eliminationsMostInGame;
    data['healingDoneMostInGame'] = this._healingDoneMostInGame;
    data['heroDamageDoneMostInGame'] = this._heroDamageDoneMostInGame;
    data['meleeFinalBlowsMostInGame'] = this._meleeFinalBlowsMostInGame;
    return data;
  }
}

class Combat {
  int _barrierDamageDone;
  int _damageDone;
  int _deaths;
  int _eliminations;
  int _heroDamageDone;
  int _meleeFinalBlows;

  Combat(
      {int barrierDamageDone,
      int damageDone,
      int deaths,
      int eliminations,
      int heroDamageDone,
      int meleeFinalBlows}) {
    this._barrierDamageDone = barrierDamageDone;
    this._damageDone = damageDone;
    this._deaths = deaths;
    this._eliminations = eliminations;
    this._heroDamageDone = heroDamageDone;
    this._meleeFinalBlows = _meleeFinalBlows;
  }

  int get barrierDamageDone => _barrierDamageDone;
  set barrierDamageDone(int barrierDamageDone) =>
      _barrierDamageDone = barrierDamageDone;
  int get damageDone => _damageDone;
  set damageDone(int damageDone) => _damageDone = damageDone;
  int get deaths => _deaths;
  set deaths(int deaths) => _deaths = deaths;
  int get eliminations => _eliminations;
  set eliminations(int eliminations) => _eliminations = eliminations;
  int get heroDamageDone => _heroDamageDone;
  set heroDamageDone(int heroDamageDone) => _heroDamageDone = heroDamageDone;
  int get meleeFinalBlows => _meleeFinalBlows;
  set meleeFinalBlows(int meleeFinalBlows) =>
      _meleeFinalBlows = meleeFinalBlows;

  Combat.fromJson(Map<String, dynamic> json) {
    _barrierDamageDone = json['barrierDamageDone'];
    _damageDone = json['damageDone'];
    _deaths = json['deaths'];
    _eliminations = json['eliminations'];
    _heroDamageDone = json['heroDamageDone'];
    _meleeFinalBlows = json['meleeFinalBlows'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['barrierDamageDone'] = this._barrierDamageDone;
    data['damageDone'] = this._damageDone;
    data['deaths'] = this._deaths;
    data['eliminations'] = this._eliminations;
    data['heroDamageDone'] = this._heroDamageDone;
    data['meleeFinalBlows'] = this._meleeFinalBlows;
    return data;
  }
}

class Game {
  int _gamesPlayed;
  int _gamesWon;
  String _timePlayed;

  Game({int gamesPlayed, int gamesWon, String timePlayed}) {
    this._gamesPlayed = gamesPlayed;
    this._gamesWon = gamesWon;
    this._timePlayed = timePlayed;
  }

  int get gamesPlayed => _gamesPlayed;
  set gamesPlayed(int gamesPlayed) => _gamesPlayed = gamesPlayed;
  int get gamesWon => _gamesWon;
  set gamesWon(int gamesWon) => _gamesWon = gamesWon;
  String get timePlayed => _timePlayed;
  set timePlayed(String timePlayed) => _timePlayed = timePlayed;

  Game.fromJson(Map<String, dynamic> json) {
    _gamesPlayed = json['gamesPlayed'];
    _gamesWon = json['gamesWon'];
    _timePlayed = json['timePlayed'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['gamesPlayed'] = this._gamesPlayed;
    data['gamesWon'] = this._gamesWon;
    data['timePlayed'] = this._timePlayed;
    return data;
  }
}

class Games {
  int _played;
  int _won;

  Games({int played, int won}) {
    this._played = played;
    this._won = won;
  }

  int get played => _played;
  set played(int played) => _played = played;
  int get won => _won;
  set won(int won) => _won = won;

  Games.fromJson(Map<String, dynamic> json) {
    _played = json['played'];
    _won = json['won'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['played'] = this._played;
    data['won'] = this._won;
    return data;
  }
}

class Ratings {
  int _level;
  String _role;
  String _rankIcon;

  Ratings({int level, String role, String rankIcon}) {
    this._level = level;
    this._role = role;
    this._rankIcon = rankIcon;
  }

  int get level => _level;
  set level(int level) => _level = level;
  String get role => _role;
  set role(String role) => _role = role;
  String get rankIcon => _rankIcon;
  set rankIcon(String rankIcon) => _rankIcon = rankIcon;

  Ratings.fromJson(Map<String, dynamic> json) {
    _level = json['level'];
    _role = json['role'];
    _rankIcon = json['rankIcon'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['level'] = this._level;
    data['role'] = this._role;
    data['rankIcon'] = this._rankIcon;
    return data;
  }
}
