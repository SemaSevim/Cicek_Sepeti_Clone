package com.example.odev5.ui.screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.odev5.R


data class Kategori(val ad: String, val resimId: Int, val arkaPlanRenk: Color)

@Composable
fun Anasayfa() {
    Scaffold (bottomBar = { AltNavigasyonBar()
    }){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(vertical = 0.dp)
                .padding(innerPadding)

        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(4.dp))
            AddressSection()
            Spacer(modifier = Modifier.height(4.dp))
            FilterAndSortButtons()
            Spacer(modifier = Modifier.height(4.dp))
            CategorySection(
                kategoriler = listOf(
                    Kategori("Kokina", R.drawable.kokina, Color(0xFFFFF3E0)),
                    Kategori("Kasımpatı", R.drawable.cicek, Color(0xFFE0F7FA)),
                    Kategori("Güller", R.drawable.gul, Color(0xFFE8F5E9)),
                    Kategori("Buket Çiçekler", R.drawable.buket, Color(0xFFFFEBEE)),
                    Kategori("Saksı Bitkileri", R.drawable.saksi, Color(0xFFE0F7FA)),
                )
            )
            UrunListesi(urunler = urunler)

        }



    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF3F3F3), shape = RoundedCornerShape(24.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arama),
            contentDescription = "Arama Icon",
            tint = Color.Gray,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Marka, ürün veya kategori ara",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun AddressSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFEAFCE5), shape = RoundedCornerShape(8.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.konum),
            contentDescription = "Konum Icon",
            tint = Color(0xFF4CAF50),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Alıcı: İstanbul, Türkiye",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
            color = Color(0xFF4CAF50)
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.edit),
            contentDescription = "Edit Icon",
            tint = Color(0xFF4CAF50),
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun FilterAndSortButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .scale(0.9f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            modifier = Modifier.weight(1f).padding(end = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filter",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Filtrele", color = Color.Black)
        }
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            modifier = Modifier.weight(1f).padding(start = 4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.sirala),
                contentDescription = "Sort",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Sırala", color = Color.Black)
        }
    }
}

@Composable
fun CategorySection(kategoriler: List<Kategori>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(kategoriler) { kategori ->
            CategoryItem(kategori)
        }
    }
}

@Composable
fun CategoryItem(kategori: Kategori) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 4.dp)
    ) {
        // renkli çerçeve
        Box(
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape)
                .background(color = kategori.arkaPlanRenk)
        ) {
            Icon(
                painter = painterResource(id = kategori.resimId),
                contentDescription = kategori.ad,
                modifier = Modifier
                    .size(57.dp)
                    .align(Alignment.Center),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        // Görselin altındaki kategori ismi
        Text(
            text = kategori.ad,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }}


@Composable
fun AltNavigasyonBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp).padding(bottom = 6.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AltNavigasyonBarItem(iconRes = R.drawable.cicek_sepeti_image, label = "Anasayfa")
        AltNavigasyonBarItem(iconRes = R.drawable.kategori_arama_image, label = "Kategoriler")
        AltNavigasyonBarItem(iconRes = R.drawable.favorilerim_image, label = "Favorilerim")
        AltNavigasyonBarItem(iconRes = R.drawable.sepetim_image, label = "Sepetim")
        AltNavigasyonBarItem(iconRes = R.drawable.hesabim_image, label = "Hesabım")
    }
}

@Composable
fun AltNavigasyonBarItem(iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = Color.Gray // İkon rengi
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(color = Color.Gray),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

