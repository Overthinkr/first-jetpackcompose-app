package com.example.mybusinesscard

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.layout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(modifier = Modifier
        .background(Color.Green)
        .padding(all = 13.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Introduction(
            logo = painterResource(id = R.drawable.android_logo),
            name = stringResource(R.string.name),
            designation = stringResource(R.string.desig)
        )
        ContactInfo(
            phno = stringResource(R.string.phno),
            email = stringResource(R.string.email),
            twitter = stringResource(R.string.twitter),
            linkedin = stringResource(R.string.linkedin)
        )
    }
}

@Composable
fun Introduction(
    logo : Painter,
    name : String,
    designation : String
    ){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center ) {
        Image(painter = logo, contentDescription = null, modifier = Modifier
            .width(150.dp)
            .height(150.dp))
        Text(text = name, fontSize = 32.sp, modifier = Modifier.padding(6.dp), fontWeight = FontWeight.ExtraBold)
        Text(text = designation, fontSize = 28.sp)
    }
}

@Composable
fun ContactInfo(
    phno : String,
    email: String,
    twitter : String,
    linkedin : String
){
    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
        Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.Start) {
            Icon(Icons.Filled.Call, contentDescription = null, modifier = Modifier.border(1.dp, color = Color.White).size(40.dp))
            Text(text = phno, fontSize = 30.sp, modifier = Modifier.border(1.dp, color = Color.White)
                .fillMaxWidth())
        }
        Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.Start){
            Icon(Icons.Filled.Email, contentDescription = null, modifier = Modifier.border(1.dp, color = Color.White).size(40.dp))
            Text(text = email, fontSize = 28.sp, modifier = Modifier.border(1.dp, color = Color.White)
                .fillMaxWidth())
        }
        Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.Start) {
            Icon(Icons.Filled.Share, contentDescription = null, modifier = Modifier.border(1.dp, color = Color.White).size(40.dp))
            Text(text = twitter, fontSize = 30.sp, modifier = Modifier.border(1.dp, color = Color.White)
                .fillMaxWidth())
        }
        Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.Start ) {
            Icon(Icons.Filled.Info, contentDescription = null, modifier = Modifier.border(1.dp, color = Color.White).size(40.dp))
            Text(text = linkedin, fontSize = 29.sp, modifier = Modifier.border(1.dp, color = Color.White)
                .fillMaxWidth())
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyBusinessCardTheme {
        BusinessCardApp()
    }
}