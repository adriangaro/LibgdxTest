package com.mygdx.game.renderables

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Pool
import com.mygdx.game.components.Transform2D

interface Renderable: Pool.Poolable {
    fun draw(batch: SpriteBatch, transform2D: Transform2D)
}