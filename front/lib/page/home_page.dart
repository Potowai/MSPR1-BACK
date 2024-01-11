import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Arossa-Te'),
        centerTitle: true,
        backgroundColor: Colors.green[800],
      ),
      body: Container(
        padding: const EdgeInsets.all(20.0),
        color: Colors.green[100],
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'Connexion',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 80),
            TextFormField(
              decoration: const InputDecoration(
                icon: Icon(Icons.mail),
                labelText: 'Adresse mail',
              ),
            ),
            const SizedBox(height: 20),
            TextFormField(
              decoration: const InputDecoration(
                icon: Icon(Icons.lock),
                labelText: 'Mot de passe',
              ),
              obscureText: true,
            ),
            const SizedBox(height: 40),
            ElevatedButton(
              onPressed: () {
                // Ajoutez votre logique de connexion ici
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.green[700],
                minimumSize: const Size.fromHeight(50),
              ),
              child: const Text('Se connecter'),
            ),
            TextButton(
              onPressed: () {
                // Ajoutez votre logique pour mot de passe oublié ici
              },
              child: const Text('Mot de passe oublié ?'),
            ),
            const Divider(color: Colors.black),
            TextButton(
              onPressed: () {
                // Ajoutez votre logique pour créer un compte ici
              },
              child: const Text('Créer un compte'),
            ),
          ],
        ),
      ),
    );
  }
}

