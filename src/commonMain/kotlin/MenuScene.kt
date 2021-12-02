import com.soywiz.korge.input.onClick
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.ui.uiTextButton
import com.soywiz.korge.view.*
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class MenuScene : Scene() {
    override suspend fun Container.sceneInit() {
        //set BG color
//        views.clearColor = Colors.BLACK
        val POSITION_OFFSET = 128

        val noTagIcon = resourcesVfs["NoTag.png"].readBitmap()

        roundRect(100, 100, views.virtualWidth / 2 - POSITION_OFFSET, views.virtualWidth / 2 - POSITION_OFFSET) {
            image(noTagIcon) {
                scaledWidth = views.virtualWidth.toDouble()
                scaledHeight = views.virtualHeight.toDouble()
            }
        }
        // Add text to show name of game
        text("NoTag: Not Another Text Adventure Game") {
            position(views.virtualWidth / 2 - (POSITION_OFFSET + 30), views.virtualHeight / 2 - POSITION_OFFSET)
            textSize = 20.00
//            color = RGBA(255, 0, 0, 0)
        }

        uiTextButton(256.0, 32.0) {
            text = "Enter the Forest"
            position(views.virtualWidth / 2 - POSITION_OFFSET, views.virtualHeight / 2 - (POSITION_OFFSET / 2))
            onClick {
                sceneContainer.changeTo<PlayScene>()
            }
        }

        uiTextButton(256.0, 32.0) {
            text = "Run to Safety"
            position(views.virtualWidth / 2 - POSITION_OFFSET, views.virtualHeight / 2)
            onClick {
                views.gameWindow.close()
            }
        }
    }
}