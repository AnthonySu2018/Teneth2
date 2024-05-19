package com.anthony.teneth2.screens


import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SettingsScreen(){

    val ipAddress = remember { mutableStateOf("") }
    val portNumber = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val textContent = remember { mutableStateOf(TextFieldValue())}


    Column(modifier = Modifier.fillMaxSize()){
            Spacer(modifier = Modifier.height(60.dp))

                Row( verticalAlignment =Alignment.CenterVertically){
                    Text("服务器IP地址：", fontSize = 30.sp)
                    TextField(
                        value = ipAddress.value,
                        onValueChange = { newValue -> ipAddress.value = newValue },
                        label = { Text("Enter IP Address") }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

            Row( verticalAlignment =Alignment.CenterVertically){
                Text("服务器端口号：", fontSize = 30.sp)
                TextField(
                    value = portNumber.value,
                    onValueChange = { newValue -> portNumber.value = newValue },
                    label = { Text("Enter Port Number") }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row( verticalAlignment =Alignment.CenterVertically){
                Text("用户名：", fontSize = 30.sp)
                Spacer(modifier = Modifier.width(90.dp))
                TextField(
                    value = username.value,
                    onValueChange = { newValue -> username.value = newValue },
                    label = { Text("Enter your username") }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row( verticalAlignment =Alignment.CenterVertically){
                Text("密码：", fontSize = 30.sp)
                Spacer(modifier = Modifier.width(120.dp))
                TextField(
                    value = password.value,
                    onValueChange = { newValue -> password.value = newValue },
                    label = { Text("Enter your password") }
                )
            }
            Spacer(modifier = Modifier.height(50.dp))


            Row( verticalAlignment =Alignment.CenterVertically){
                Spacer(modifier = Modifier.width(100.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text("下载商品数据")
                }
                Spacer(modifier = Modifier.width(100.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text("删除商品数据")
                }

            }
            Spacer(modifier = Modifier.height(50.dp))

            Box(modifier =  Modifier.background(Color.Black).fillMaxWidth(),  contentAlignment = Alignment.Center) {
                BasicTextField(
                    value = textContent.value,
                    onValueChange = { newValue -> textContent.value = newValue },
                    modifier = Modifier.fillMaxSize(),
                    textStyle = TextStyle(color = Color.White),
                    singleLine = false
                )
            }

        }

}