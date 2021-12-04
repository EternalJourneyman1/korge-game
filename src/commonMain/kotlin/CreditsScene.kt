import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.position
import com.soywiz.korge.view.text

class CreditsScene() : Scene() {
    override suspend fun Container.sceneInit() {
        text("Developed by: \n EternalJourneyman1") {
            position(views.virtualWidth / 2 - this.width.toInt(), views.virtualHeight / 2 - POSITION_OFFSET )
            textSize = 20.00
//            color = RGBA(255, 0, 0, 0)
        }


    }
}
