package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.utils.Pool
import com.mygdx.game.renderables.Renderable

class RenderableComponent(var renderable: Renderable? = null) : Component, Pool.Poolable {
    override fun reset() {
        renderable?.reset()
    }

}

