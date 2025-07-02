package com.joselira.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joselira.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Card()
                }
            }
        }
    }
}

@Composable
fun PersonalInformationCard(name: String, positionJob: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = name,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.SansSerif,
            fontSize = 60.sp,
            modifier = Modifier
                .padding(top = 10.dp)
        )
        Text(
            text = positionJob,
            color = colorResource(R.color.text_color),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

@Composable
fun ContactCard(textContact: String, icon: ImageVector, description: String, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
    ){
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = colorResource(R.color.text_color)
        )
        Spacer(modifier = Modifier.width(25.dp))
        Text(
            text = textContact,
            fontSize = 18.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun Card(){
    Column(Modifier.fillMaxSize().background(colorResource(R.color.background))){
        PersonalInformationCard(
            name = stringResource(R.string.my_name),
            positionJob = stringResource(R.string.position),
            Modifier.weight(3f)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 120.dp)
        ){
            ContactCard(
                textContact = stringResource(R.string.phone_number),
                icon = Icons.Rounded.Call,
                description = "Phone Icon"
            )
            ContactCard(
                textContact = "@${stringResource(R.string.share)}",
                icon = Icons.Rounded.Share,
                description = "Share Icon"
            )
            ContactCard(
                textContact = stringResource(R.string.email),
                icon = Icons.Rounded.Email,
                description = "Mail Icon"
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card()
    }
}