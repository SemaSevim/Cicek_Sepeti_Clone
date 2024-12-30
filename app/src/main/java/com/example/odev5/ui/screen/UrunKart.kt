package com.example.odev5.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odev5.R
import org.w3c.dom.Text

@Composable
fun UrunKart(urun: Urun) {
    Column(
        modifier = Modifier
            .padding(2.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .fillMaxWidth()
           // .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))
    ) {
        Box {
        // Ürün Resmi
        Image(
            painter = painterResource(id = urun.resimId),
            contentDescription = urun.ad,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
            contentScale = ContentScale.Crop
        )
        Box (
            modifier = Modifier
                .padding(8.dp)
                .border(1.dp, Color(0xFF2E7D32), shape = RoundedCornerShape(6.dp))
                .background(Color(0xFFE6F4EA), RoundedCornerShape(6.dp))
                .align(Alignment.TopStart)){

        // TASARIM ÇİÇEK Etiketi
        Text(
            text = "TASARIM ÇİÇEK",
            color = Color(0xFF4CAF50),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 4.dp)
                .background(
                    color = Color(0xFFE8F5E9),
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 4.dp, vertical = 2.dp)
        )
        }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
                    .size(20.dp)
                    .background(Color.Transparent, RectangleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favori",
                    tint = Color.Gray
                )
            }


        }
        //Teslimat bilgi
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 8.dp, top = 4.dp)) {
            Icon(painter = painterResource(id = R.drawable.kamyon),
                contentDescription = "Teslimat ikon",
                modifier = Modifier.size(18.dp)
                    .padding(end = 4.dp),
                tint = Color(0xFF4CAF50)
            )
            Text(text = urun.teslimat, fontSize = 12.sp, color = Color(0xFF4CAF50))}
        // Ürün Adı
        Text(
            text = urun.ad,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )


        // Değerlendirme
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(urun.yildiz.toInt()) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFD700), modifier = Modifier.size(16.dp))
                }
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.Gray, // Gri yıldız
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "(${urun.degerlendirmeSayisi})",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

            }
        }

        // Fiyat Bilgisi
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                text = urun.fiyat,
                color = Color(0xFFF44336),
                fontWeight = FontWeight.Bold,

            )

            Row (verticalAlignment = Alignment.CenterVertically){
            urun.eskiFiyat?.let {
                Text(
                    text = it,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.width(4.dp))

            urun.indirim?.let {

                Box(

                    modifier = Modifier
                        .background(Color(0xFFF44336), RoundedCornerShape(8.dp))
                        .padding(horizontal = 6.dp, vertical = 0.dp)
                        .height(IntrinsicSize.Min),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = it,
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxHeight()
                    )
                }

            }
            }
        }


    }
}

val urunler = listOf(
    Urun(
        resimId = R.drawable.pembe,
        ad = "Sarı Saksıda Pembe Güller ve Papatyalar",
        fiyat = "269,00 TL",
        eskiFiyat = "329,00 TL",
        indirim = "%18",
        yildiz = 4.5f,
        degerlendirmeSayisi = 314,
        teslimat = "Bugün / Ücretsiz Teslimat"
    ),
    Urun(
        resimId = R.drawable.urun5,
        ad = "Çizgili Cam Vazoda Kırmızı ve Beyaz Güller",
        fiyat = "449,00 TL",
        eskiFiyat = "599,00 TL",
        indirim = "%25",
        yildiz = 4.2f,
        degerlendirmeSayisi = 2386,
        teslimat = "Bugün / Ücretsiz Teslimat"
    ),
    Urun(
        resimId = R.drawable.urun2,
        ad = "Kraft Bukette Kokina Çiçeği",
        fiyat = "949,00 TL",
        eskiFiyat = "1.049,00 TL",
        indirim = "%10",
        yildiz = 4.2f,
        degerlendirmeSayisi = 2328,
        teslimat = "Bugün / Ücretsiz Teslimat"
    ),
    Urun(
        resimId = R.drawable.urun4,
        ad = "Cam Vazoda Kırmızı Güller & Kalpli Gurme Lezzetler",
        fiyat = "479,00 TL",
        eskiFiyat = "629,00 TL",
        indirim = "%24",
        yildiz = 4.2f,
        degerlendirmeSayisi = 2328,
        teslimat = "Bugün / Ücretsiz Teslimat"
    )

)


@Composable
fun UrunListesi(urunler: List<Urun>) {
    LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(urunler) { urun ->
            UrunKart(urun = urun)
        }
    }
}



