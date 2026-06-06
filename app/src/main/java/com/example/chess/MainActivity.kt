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

data class Piece(val resId: Int, val name: String)

@Composable
fun Chess(name: String, modifier: Modifier = Modifier) {
    var selectedSquare by remember { mutableStateOf<Pair<Int, Int>?>(null) }

    var boardState by remember {
        mutableStateOf(
            arrayOf(
                arrayOf(Piece(R.drawable.black_rook, "Black Rook"), Piece(R.drawable.black_knight, "Black Knight"), Piece(R.drawable.black_bishop, "Black Bishop"), Piece(R.drawable.black_queen, "Black Queen"), Piece(R.drawable.black_king, "Black King"), Piece(R.drawable.black_bishop, "Black Bishop"), Piece(R.drawable.black_knight, "Black Knight"), Piece(R.drawable.black_rook, "Black Rook")),
                arrayOf(Piece(R.drawable.black_pawn, "Black Pawn"), Piece(R.drawable.black_pawn, "Black Pawn"), Piece(R.drawable.black_pawn, "Black Pawn"), Piece(R.drawable.black_pawn, "Black Pawn"), Piece(R.drawable.black_pawn, "Black Pawn"), Piece(R.drawable.black_pawn, "Black Pawn"), Piece(R.drawable.black_pawn, "Black Pawn"), Piece(R.drawable.black_pawn, "Black Pawn")),
                arrayOf(Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank")),
                arrayOf(Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank")),
                arrayOf(Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank")),
                arrayOf(Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank"), Piece(R.drawable.pic, "Blank")),
                arrayOf(Piece(R.drawable.white_pawn, "White Pawn"), Piece(R.drawable.white_pawn, "White Pawn"), Piece(R.drawable.white_pawn, "White Pawn"), Piece(R.drawable.white_pawn, "White Pawn"), Piece(R.drawable.white_pawn, "White Pawn"), Piece(R.drawable.white_pawn, "White Pawn"), Piece(R.drawable.white_pawn, "White Pawn"), Piece(R.drawable.white_pawn, "White Pawn")),
                arrayOf(Piece(R.drawable.white_rook, "White Rook"), Piece(R.drawable.white_knight, "White Knight"), Piece(R.drawable.white_bishop, "White Bishop"), Piece(R.drawable.white_queen, "White Queen"), Piece(R.drawable.white_king, "White King"), Piece(R.drawable.white_bishop, "White Bishop"), Piece(R.drawable.white_knight, "White Knight"), Piece(R.drawable.white_rook, "White Rook"))
            )
        )
    }

    Row(modifier = modifier) {
        for (col in 0..7) {
            Column(modifier = Modifier.weight(1f)) {
                for (row in 0..7) {
                    val isWhiteSquare = (row + col) % 2 == 0
                    val isSelected = selectedSquare == Pair(row, col)
                    val piece = boardState[row][col]

                    Image(
                        painter = painterResource(piece.resId),
                        contentDescription = piece.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .background(
                                if (isSelected) Color.Yellow.copy(alpha = 0.5f)
                                else if (isWhiteSquare) Color.White
                                else Color.Black
                            )
                            .border(
                                width = if (isSelected) 2.dp else 0.dp,
                                color = if (isSelected) Color.Yellow else Color.Transparent
                            )
                            .clickable {
                                val currentSelection = selectedSquare
                                if (currentSelection == null) {
                                    // Select a piece if it's not a blank square
                                    if (piece.name != "Blank") {
                                        selectedSquare = Pair(row, col)
                                    }
                                } else {
                                    // If we click the same square, deselect it
                                    if (currentSelection == Pair(row, col)) {
                                        selectedSquare = null
                                    } else {
                                        // Move piece
                                        val newBoard = boardState.map { it.clone() }.toTypedArray()
                                        newBoard[row][col] = newBoard[currentSelection.first][currentSelection.second]
                                        newBoard[currentSelection.first][currentSelection.second] = Piece(R.drawable.pic, "Blank")
                                        boardState = newBoard
                                        selectedSquare = null
                                    }
                                }
                            }
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