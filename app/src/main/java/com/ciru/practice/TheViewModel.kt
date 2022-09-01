package com.ciru.practice



import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class  TheViewModel : ViewModel(){
//    state
//    var count  by mutableStateOf(0)
    var name  = MutableStateFlow("")
    var email  = MutableStateFlow("")

//    connect
    val _name:StateFlow<String>
    get() = name

    val _email:StateFlow<String>
    get() = email

//    event
    fun setName(newString: String){ name.value = newString }
    fun setEmail(newString: String){email.value = newString}









//    class ViewModelA:ViewModel(){
//        private val _data = MutableStateFlow("")
//        val data:StateFlow<String>
//            get() = _data
//        fun setData(newData:String){
//            // or you can use _data.update{ }
//            _data.value = newData
//        }
//    }
//    // inject your view model instance into your composables in your activitiy's onCreate
//    @Composable
//    fun ScreenB(sharedViewModel:ViewModel){
//        val data = sharedViewModel.data.collectAsState(initial="")
//        // do something with it
//    }
//    @Composable
//    fun ScreenA(sharedViewModel:ViewModel){
//        sharedViewModel.setData("data")
//    }
}