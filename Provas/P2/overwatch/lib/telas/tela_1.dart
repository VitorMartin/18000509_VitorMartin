import 'package:flutter/material.dart';

class Tela1 extends StatefulWidget {
  final String title;

  const Tela1({Key key, this.title = 'Home'}) : super(key: key);

  @override
  _Tela1 createState() => _Tela1();
}

class _Tela1 extends State<Tela1> {
  final controlador = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Column(),
      ),
    );
  }
}
