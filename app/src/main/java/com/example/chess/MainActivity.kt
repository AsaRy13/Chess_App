package com.example.chess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chess.ui.theme.ChessTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Chess(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Chess(name: String, modifier: Modifier = Modifier) {
    var pieceLocations = arrayOf(
        arrayOf(painterResource(R.drawable.black_rook), painterResource(R.drawable.black_knight), painterResource(R.drawable.black_bishop), painterResource(R.drawable.black_queen), painterResource(R.drawable.black_king), painterResource(R.drawable.black_bishop), painterResource(R.drawable.black_knight), painterResource(R.drawable.black_rook)),
        arrayOf(painterResource(R.drawable.black_pawn), painterResource(R.drawable.black_pawn), painterResource(R.drawable.black_pawn), painterResource(R.drawable.black_pawn), painterResource(R.drawable.black_pawn), painterResource(R.drawable.black_pawn), painterResource(R.drawable.black_pawn), painterResource(R.drawable.black_pawn)),
        arrayOf(painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic)),
        arrayOf(painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic)),
        arrayOf(painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic)),
        arrayOf(painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic), painterResource(R.drawable.pic)),
        arrayOf(painterResource(R.drawable.white_pawn), painterResource(R.drawable.white_pawn), painterResource(R.drawable.white_pawn), painterResource(R.drawable.white_pawn), painterResource(R.drawable.white_pawn), painterResource(R.drawable.white_pawn), painterResource(R.drawable.white_pawn), painterResource(R.drawable.white_pawn)),
        arrayOf(painterResource(R.drawable.white_rook), painterResource(R.drawable.white_knight), painterResource(R.drawable.white_bishop), painterResource(R.drawable.white_queen), painterResource(R.drawable.white_king), painterResource(R.drawable.white_bishop), painterResource(R.drawable.white_knight), painterResource(R.drawable.white_rook))
    )
    var pieceNameLocations = arrayOf(
        arrayOf("Black Rook", "Black Knight", "Black Bishop", "Black Queen", "Black King", "Black Bishop", "Black Knight", "Black Rook"),
        arrayOf("Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn", "Black Pawn"),
        arrayOf("Blank", "Blank", "Blank", "Blank", "Blank", "Blank", "Blank", "Blank"),
        arrayOf("Blank", "Blank", "Blank", "Blank", "Blank", "Blank", "Blank", "Blank"),
        arrayOf("Blank", "Blank", "Blank", "Blank", "Blank", "Blank", "Blank", "Blank"),
        arrayOf("Blank", "Blank", "Blank", "Blank", "Blank", "Blank", "Blank", "Blank"),
        arrayOf("White Pawn", "White Pawn", "White Pawn", "White Pawn", "White Pawn", "White Pawn", "White Pawn", "White Pawn"),
        arrayOf("White Rook", "White Knight", "White Bishop", "White Queen", "White King", "White Bishop", "White Knight", "White Rook")
    )

    //AI helped me realize that I needed to put modifier = modifier here so the tiles wouldn't inherit the scaffold padding.
    Row(modifier = modifier) {
        // I'm still new at Jetpack Compose, so at first this code block was just a bunch of
        // repetitive code. Then I asked AI for help with a different issue and one of the things
        // it recommended was to condense all of my repetitive code into these for loops.
        for (col in 0..7) {
            Column(modifier = Modifier.weight(1f)) {
                for (row in 0..7) {
                    val isWhiteSquare = (row + col) % 2 == 0
                    Image(
                        painter = pieceLocations[row][col],
                        contentDescription = pieceNameLocations[row][col],
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .background(if (isWhiteSquare) Color.White else Color.Black)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChessPreview() {
    ChessTheme {
        Chess("Android")
    }
}