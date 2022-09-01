package com.ciru.practice

sealed class MainContent(val route:String){
    object Boo:MainContent(route = "boo")
    object Bae:MainContent(route = "bae")
}
