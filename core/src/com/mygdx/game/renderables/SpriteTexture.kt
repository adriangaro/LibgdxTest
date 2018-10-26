package com.mygdx.game.renderables

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.components.Transform2D

class SpriteTexture(val texture: Texture): Renderable {
    constructor(path: String): this(Texture(path))

    override fun draw(batch: SpriteBatch, transform2D: Transform2D) {
        batch.draw(texture, transform2D.x, transform2D.y)
    }

    override fun reset() {
        texture.dispose()
    }
}