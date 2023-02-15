package com.example.captainjumperboy.game.scripts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.captainjumperboy.engine.Camera
import com.example.captainjumperboy.engine.Scene
import com.example.captainjumperboy.engine.Sprite
import com.example.captainjumperboy.engine.SpriteSheet
import com.example.captainjumperboy.engine.component.Scriptable
import com.example.captainjumperboy.ui.GameView

class Gameover : Scriptable() {
    private lateinit var scene: Scene
    private var initialPosition = 0.0f
    fun setScene(s: Scene)
    {
        this.scene=s
    }
    override fun start() {
        val Width= GameView.windowWidth.toFloat()
        val Height= GameView.windowHeight.toFloat()

        transform.position.x = Width/2.0f
        transform.position.y = Height/2.0f
        transform.scale.x =Width/100.0f
        transform.scale.y = Height/100.0f
        transform.rotation = 0F
        initialPosition = transform.position.y
        val sprite = gameObject.getComponent<Sprite>() ?: return
        sprite.image.Alpha=0
    }

    override fun update() {
        /*
         Camera.transform.position.y += 1
         transform.position.y += 1
         */

        // Does not work well because camera is tied to players position, and that
        // is not the center of the screen

        transform.position.y = Camera.transform.position.y+initialPosition-5//magic number
    }
}