# Overview

Recently I wanted to learn more about how mobile apps are created, so I looked it up and found out that I could make apps using Kotlin. I then thought that maybe I could slightly reconfigure my chess program to turn it into an app. I then realized that it wouldn't be a simple reconfiguration because my chess program was written using the Java Swing libraries, but android apps only work with the Jetpack Compose libraries. I eventually got to the same point in the app that I was at in the initial program.

Right now this app has all the chess pieces in the starting position, but none of them can move. I did ask AI for some help with my code, and all the times it helped me are listed in the code. There was also a point where I asked the AI how it would write code to make the pieces move and the code it generated for that is found in the modified_by_ai branch.

The reason why I created this app was so I could learn a little bit more about what the app making process looks like.

Also, I made a video demoing my version of the app and the AI version where the pieces can move:

[Software Demo Video](http://youtube.link.goes.here)

# Development Environment

## Tools
+ Android Studio
+ Smartphone with Android 16.0 ("Baklava") | arm64

## Programming Language and Libraries
+ Kotlin
+ Jetpack Compose Libraries Including:
  + android.os.Bundle
  + androidx.activity.ComponentActivity
  + androidx.activity.compose.setContent
  + androidx.activity.enableEdgeToEdge
  + androidx.compose.foundation.Image
  + androidx.compose.foundation.background
  + androidx.compose.foundation.border
  + androidx.compose.foundation.clickable
  + androidx.compose.foundation.layout.Column
  + androidx.compose.foundation.layout.Row
  + androidx.compose.foundation.layout.aspectRatio
  + androidx.compose.foundation.layout.fillMaxSize
  + androidx.compose.foundation.layout.fillMaxWidth
  + androidx.compose.foundation.layout.padding
  + androidx.compose.material3.Scaffold
  + androidx.compose.material3.Text
  + androidx.compose.runtime.Composable
  + androidx.compose.runtime.getValue
  + androidx.compose.runtime.mutableStateOf
  + androidx.compose.runtime.remember
  + androidx.compose.runtime.setValue
  + androidx.compose.ui.Modifier
  + androidx.compose.ui.graphics.Color
  + androidx.compose.ui.res.painterResource
  + androidx.compose.ui.tooling.preview.Preview
  + androidx.compose.ui.unit.dp
  + com.example.chess.ui.theme.ChessTheme

# Useful Websites

* [Official Android Developer Courses](https://developer.android.com/courses)
* [Android Studio Official Download](https://developer.android.com/studio)

# Future Work

* Make pieces move and capture properly.
* Add castling
* Add en passant