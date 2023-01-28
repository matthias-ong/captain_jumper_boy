package com.example.captainjumperboy.game.scripts

import com.example.captainjumperboy.engine.GameThread
import com.example.captainjumperboy.engine.Sprite
import com.example.captainjumperboy.engine.component.Scriptable
import com.example.captainjumperboy.math.Vector2D
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Player : Scriptable() {
    var velocity = Vector2D()
    val jumpInterval = 2L

    val scope = CoroutineScope(Dispatchers.Default)

    override fun start() {
        val platformSpawner = findObject("spawner")
        val spawner = platformSpawner.getScript<PlatformSpawner>() ?: return
        val sprite = gameObject.getComponent<Sprite>() ?: return

        val firstPlatform = spawner.platforms[0]
        transform.position.x = firstPlatform.transform.position.x
        transform.position.y = firstPlatform.transform.position.y - sprite.image.height * transform.scale.y / 2F
    }

    fun jump(){
        velocity.y = -5F;
    }

    override fun update() {
        val dt = GameThread.deltaTime
        transform.position.x += velocity.x
        transform.position.y += velocity.y

//        scope.launch {
//            while (true){
//                jump()
//                delay(jumpInterval * 100000)
//            }
//        }

        velocity.y += 10F
    }
}