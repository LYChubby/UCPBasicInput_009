package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview(showBackground = true)
@Composable
fun FormTiket(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth()
            .background(color = Color.Blue)
            .padding(top = 15.dp),) {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.rrq),
                    contentDescription = " ",
                    modifier = Modifier.size(100.dp)
                        .clip(CircleShape)
                )
                Text(text = "Fauzi Taufik", color = Color.White)
                Text(text = "Kabupaten Tangerang", color = Color.White)

                }

            }
        Box(modifier = Modifier.fillMaxSize() .background(color = Color.White),) {
            Column(modifier = Modifier.fillMaxSize()  .padding(15.dp) .clip(AbsoluteRoundedCornerShape(5.dp))){
                var asal by remember { mutableStateOf("")}
                var departure by remember { mutableStateOf("")}
                var arrival by remember { mutableStateOf("")}
                var choose by remember { mutableStateOf("")}

                var asalsv by remember { mutableStateOf("") }
                var departuresv by remember { mutableStateOf("") }
                var arrivalsv by remember { mutableStateOf("") }
                var choosesv by remember { mutableStateOf("") }

                val pilihan = listOf("Bus", "Ship", "Train", "Plane")

                Text(text = "Plan Your Adventures")
                Text(text = "Let's plan an exquisite adventure")

                Spacer(Modifier.padding(10.dp))


                TextField(
                    value = asal,
                    onValueChange = {asal = it},
                    label = { Text("Origin")},
                    placeholder = { Text("Masukkan Asal Anda")},
                    modifier = Modifier.clip(AbsoluteRoundedCornerShape(30.dp))
                )

                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    TextField(
                        value = departure,
                        onValueChange = {departure = it},
                        label = { Text("Departure")},
                        placeholder = { Text("Masukkan Departure")},
                        modifier = Modifier.clip(AbsoluteRoundedCornerShape(30.dp))
                    )
                    TextField(
                        value = arrival,
                        onValueChange = {arrival = it},
                        label = { Text("arrival")},
                        placeholder = { Text("Masukkan Arrival")},
                        modifier = Modifier.clip(AbsoluteRoundedCornerShape(30.dp))
                    )
                }

                Spacer(modifier.padding(20.dp))
                Column(modifier = Modifier.fillMaxWidth() .background(color = Color.Blue)
                    .clip(AbsoluteRoundedCornerShape(10.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Choose transportation")

                    Row {
                        pilihan.forEach { item ->
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
//                                RadioButton(
//                                   selected = pilihan == item,
//                                   onClick = {
//                                       pilihan = item
//                                    }
//                                )

                                Text(item)
                            }
                        }
                    }

                }

                Button(onClick = {
                    asalsv = asal
                    departuresv = departure
                    arrivalsv = arrival
                    choosesv = choose
                }) {
                    Text(text = "Submit")
                }

                ElevatedCard(
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    DetailIsi(judul = "Origin", isi = asalsv)
                    DetailIsi(judul = "Departure", isi = departuresv)
                }

                ElevatedCard(
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    DetailIsi(judul = "Arrival", isi = arrivalsv)
                    DetailIsi(judul = "Trnasport", isi = choosesv)
                }


            }
        }
        }


    }

@Composable
fun DetailIsi(
    judul: String, isi: String
) {


    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)

    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isi,
            modifier = Modifier.weight(2f))
    }
}