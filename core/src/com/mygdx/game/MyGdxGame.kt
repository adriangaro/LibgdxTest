package com.mygdx.game

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.components.RenderableComponent
import com.mygdx.game.components.Transform2D
import com.mygdx.game.renderables.SpriteTexture
import com.mygdx.game.systems.RenderSystem
import ktx.ashley.entity
import ktx.graphics.use

class MyGdxGame : ApplicationAdapter() {
    val engine by lazy {
        PooledEngine()
    }

    val batch by lazy {
        SpriteBatch()
    }

    override fun create() {
        engine.entity {
            with<Transform2D> {
                x = 100f
                y = 100f
            }

            with<RenderableComponent> {
                renderable = SpriteTexture("badlogic.jpg")
            }
        }

        engine.entity {
            with<Transform2D> {
                x = 300f
                y = 300f
            }

            with<RenderableComponent> {
                renderable = SpriteTexture("badlogic.jpg")
            }
        }


        engine.addSystem(RenderSystem(batch))
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.use {
            engine.update(16f)
        }
    }

    override fun dispose() {
        batch.dispose()
        engine.clearPools()
    }
}
