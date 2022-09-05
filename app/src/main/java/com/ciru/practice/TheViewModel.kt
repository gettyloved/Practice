package com.ciru.practice



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class  TheViewModel : ViewModel(){
//    state
     var _email by mutableStateOf("")
     var _username by mutableStateOf("")
     var _password by mutableStateOf("")

     private val _stateProject = MutableStateFlow<StateProject>(Empty)
     private val _UserName = MutableStateFlow<String>("")
     private val _Email = MutableStateFlow<String>("")

     val stateProject : StateFlow<StateProject> get() = _stateProject
     val UserName : StateFlow<String> get() = _UserName
     val Email : StateFlow<String> get() = _Email

     fun setCapturedEmail(email:String){
         _Email.value = email
     }
     fun setCapturedUserName(userName:String){
         _UserName.value = userName
     }

     fun login(email:String, userName: String) = viewModelScope.launch {
      _stateProject.value = Loading
      if(email.isNotBlank() &&
       userName.isNotBlank() &&
       _password.contentEquals("food")) _stateProject.value = Success(email = email, username = userName)
      else _stateProject.value = Error(errorMessage = "Wrong Credentials")
     }

}







































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
//}