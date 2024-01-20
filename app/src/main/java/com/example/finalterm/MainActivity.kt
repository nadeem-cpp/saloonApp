package com.example.finalterm

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalterm.ui.theme.navigationColor
import com.example.finalterm.ui.theme.primaryColor

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appointmentIcon = ImageVector.vectorResource(id = R.drawable.calendar_month_24px)
            var selectedItemIndex by rememberSaveable {
                mutableIntStateOf(0)
            }
            val bottomItems = listOf(
                BottomNavigationItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                ),
                BottomNavigationItem(
                    title = "Calender",
                    selectedIcon = appointmentIcon,
                    unselectedIcon = appointmentIcon,
                ),
                BottomNavigationItem(
                    title = "Profile",
                    selectedIcon = Icons.Filled.AccountCircle,
                    unselectedIcon = Icons.Outlined.AccountCircle,
                )
            )
            Surface(
                modifier = Modifier.fillMaxSize(),
            )
            {
                Scaffold (
                    bottomBar = {
                        NavigationBar(
                            modifier = Modifier.height(55.dp),
                            containerColor = navigationColor
                        ) {
                            bottomItems.forEachIndexed { index, item -> NavigationBarItem(
                                selected = selectedItemIndex == index ,
                                onClick = { /*TODO*/ },
//                                label = { Text(text = item.title) },
                                icon = {
                                    Icon(imageVector = if(index == selectedItemIndex){item.selectedIcon} else item.unselectedIcon,
                                        contentDescription = item.title ,
                                        modifier = Modifier
                                            .size(35.dp)
                                    )
                                }
                            )
                            }
                        }
                    }
                )
                {
//                    Navigation()
//                    SettingScreen()
//                    HomeScreen()
                    ProfileScreen()

                }
//                HomeScreen()
//                Navigation()
            }
        }
    }
}

@Composable
fun Button(color: Color, radius: Int = 20, label: String, textColor: Color,
           width:Int = 141, height:Int =53)
{
    TextButton(
        onClick = {

        },
        modifier = Modifier
            .background(color = color, shape = MaterialTheme.shapes.extraLarge)
            .width(width.dp)
            .height(height.dp)
    )
    {
        Text(text = label, color=textColor,  fontSize = 20.sp,)
    }
}




