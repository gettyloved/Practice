package com.ciru.practice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Screen(navController: NavHostController,){
      NavHost(
          navController = navController,
          startDestination =  MainContent.Boo.route
      ){
          composable(route = MainContent.Boo.route){
              Boo(theViewModel = TheViewModel(),navController = navController)
          }
          composable(route = MainContent.Bae.route){
              Bae(theViewModel = TheViewModel(),navController = navController)
          }
      }
}