package com.mygdx.game.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.components.RenderableComponent
import com.mygdx.game.components.Transform2D
import ktx.ashley.allOf
import ktx.ashley.get
import ktx.ashley.mapperFor

class RenderSystem(var batch: SpriteBatch): IteratingSystem(allOf(Transform2D::class, RenderableComponent::class).get()) {
    val tm = mapperFor<Transform2D>()
    val sm = mapperFor<RenderableComponent>()

    override fun processEntity(entity: Entity, deltaTime: Float) {
        val transform = entity[tm]!!
        val renderable = entity[sm]!!

        renderable.renderable?.draw(batch, transform)
    }
}