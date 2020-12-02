import 'package:flutter/material.dart';
import 'package:overwatch/telas/tela_1.dart';
import 'package:overwatch/telas/tela_2.dart';

void main() {
  runApp(
    MaterialApp(
      initialRoute: 'Page1',


      routes: {
        'Page1': (context) => Tela1(),
        'Page2': (context) => Tela2(),
      },
    ),
  );
}
