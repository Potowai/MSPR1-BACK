import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'page/home_page.dart'; // Assurez-vous que le chemin d'accès est correct


final _router = GoRouter(routes: [
  GoRoute(path: "/", builder: (_, __) => HomePage(), routes: [])
]);

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      routerConfig: _router,
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
    );
  }
}
