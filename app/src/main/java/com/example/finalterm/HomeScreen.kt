package com.example.finalterm

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalterm.ui.theme.maskColor
import com.example.finalterm.ui.theme.primaryColor
import com.example.finalterm.ui.theme.secondryColor
import com.example.finalterm.ui.theme.sendFlowerFamily


@Composable
fun HomeScreen() {
    Surface(
        color = Color(0xFFEEECEC),
        modifier = Modifier.fillMaxSize()
    )
    {
        Canvas(modifier = Modifier.fillMaxSize()) {
            translate(left = -500f, top = -700f) {
                drawCircle(Color(0xFFFFB3B3), radius = 200.dp.toPx())
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
        {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_menu),
                    contentDescription ="menu",
                    tint = Color(0xFF2A2E3B),
                    modifier = Modifier
                        .size(40.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "Hi", fontSize = 20.sp,)
                    Text(
                        text = "Nadeem",
                        fontSize = 28.sp,
                        fontFamily = sendFlowerFamily,
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                // profile image
                Image(
                    painterResource(id = R.drawable.background_app),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(57.dp)
                        .clip(CircleShape)
                )

            }
            // title card
            Box(
                modifier = Modifier
                    .height(138.dp)
                    .padding(top = 6.dp, bottom = 6.dp)
                    .fillMaxWidth()
                    .background(
                        color = primaryColor,
                        shape = MaterialTheme.shapes.large
                    )
            )
            {
                Column(
                    modifier = Modifier.padding(top = 14.dp, bottom = 12.dp, start = 12.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = stringResource(id = R.string.title),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .width(178.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    // discount
                    Text(
                        text = "Get upto 50% off",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .width(141.dp)
                            .height(50.dp)
                            .background(color = secondryColor, shape = MaterialTheme.shapes.medium)
                    )
                }

            }

            // categories
            val categories: List<String> = listOf("Hair Style", "Hair Spa", "Shampoo", "Hair Dryer",
                "Facial", "makeup")
            Text(text = "Categories", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
            var i = 1
            val totalCategories = categories.size
            for (j in 0 until 2 )
            {
                var flag = true

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    while ( flag && i <= totalCategories)
                    {
                        if ( i % 3 == 0)
                        {
                            flag = false
                        }
                        CategoryCard(title = categories[i - 1])
                        i++
                    }
                }

            }

            val hairSpecialists:List<String> = listOf("Lucy", "Doe John", "Laila")
            Text(text = "Hair Specialists", fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(bottom = 8.dp))
            LazyRow(
                content = {
                    items(hairSpecialists) { specialist: String ->
                        CardItem(name  = specialist)
                    }
                }
            )
        }
    }
}


@Composable
fun CategoryCard(title:String)
{
    Surface(
        modifier = Modifier
            .width(110.dp)
            .height(85.dp)
            .padding(bottom = 8.dp),
        shape = MaterialTheme.shapes.small,
        color = Color.White
    )
    {
        Image(
            painterResource(id = R.drawable.background_app),
            contentDescription = "",
            colorFilter = ColorFilter.tint(maskColor, blendMode = BlendMode.Screen),
            contentScale = ContentScale.FillBounds,
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, fontSize = 18.sp,)
        }
    }
}

@Composable
fun CardItem(name: String) {
    Surface(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .width(130.dp)
            .height(135.dp),
        shape = MaterialTheme.shapes.extraSmall,
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        ) {
            Image(
                painterResource(id = R.drawable.background_app),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(90.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
            )
            Text(text = name)
            Text( text = "Contact",)
        }
        
    }
}
