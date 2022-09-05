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
//     not necessary
//      var _email by mutableStateOf("")
//      var _username by mutableStateOf("")
//      var _password by mutableStateOf("")

     private val _stateProject = MutableStateFlow<StateProject>(Empty)
     private val _UserName = MutableStateFlow<String>("")
     private val _Email = MutableStateFlow<String>("")
     // expose non editable state to be observed in composables
     val stateProject : StateFlow<StateProject> get() = _stateProject
     // this is what you will use to get current username and email in screenB or whatever screen you want to fetch/view the username and email just do
     // val username by viewModel.UserName.collectAsState(initial="")
     // val email by viewModel.Email.collectAsState(initial="")
     // do something with the username and email maybe log them or display them that is upto you.
     val UserName : StateFlow<String> get() = _UserName
     val Email : StateFlow<String> get() = _Email

     fun setCapturedEmail(email:String){
         _Email.value = email
     }
     fun setCapturedUserName(userName:String){
         _UserName.value = userName
     }
    
     // so just do
     fun login()=viewModelScope.launch{
      _stateProject.value = Loading
      // instead of _Email.value you can collect the flow in this coroutine scope eg _Email.collect{email-> } etc.   
      var email:String = _Email.value
      var username:String=_Username.value
       
      if(email.isNotBlank() && username.isNotBlank()
     && username.contentEquals("food") && email.contentEquals("password"){
        _stateProject.value = Success(email,username)
      }else{
       _stateProject.value = Error(errorMessage="wrong credentials;try again.") 
      }
     }
     
 // not necessary since you are internally setting the values inputted by the user via _Email and _Username implement login logic as shown above.
//      fun login(email:String, userName: String) = viewModelScope.launch {
//       _stateProject.value = Loading
//       if(email.isNotBlank() &&
//        userName.isNotBlank() &&
//        _password.contentEquals("food")) _stateProject.value = Success(email = email, username = userName)
//       else _stateProject.value = Error(errorMessage = "Wrong Credentials")
//      }

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
