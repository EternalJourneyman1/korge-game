import com.soywiz.korev.Key
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.*
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

enum class GameStates {
    BEGUN,
    PLAYING,
    ENDED
}

class PlayScene : Scene(
) {
    /** A shortcut to check if a given key is pressed */
    private fun Key.isPressed(): Boolean = stage.views.input.keys[this]

    override suspend fun Container.sceneInit() {
        // initialize variables for game
        var startingPosition = 5
        var playState = GameStates.BEGUN

        val noTagIcon = resourcesVfs["NoTag.png"].readBitmap()
        val gateScene = resourcesVfs["maps/gate.png"].readBitmap()

        var bgImg = noTagIcon

        // Add a help text which explains the rules of the game
        val playingField = roundRect(views.virtualWidth, views.virtualHeight, views.virtualWidth, views.virtualHeight) {
            clear()
            image(bgImg) {
                scaledWidth = views.virtualWidth.toDouble()
                scaledHeight = views.virtualHeight.toDouble()
            }
            addUpdater {
                println("old BG $bgImg")
                if (Key.LEFT.isPressed()) {
                    if (bgImg == noTagIcon) {
                        bgImg = gateScene
                        with(this) {
                            clear()
                            image(bgImg) {
                                scaledWidth = views.virtualWidth.toDouble()
                                scaledHeight = views.virtualHeight.toDouble()
                            }
                        }
                    } else if (bgImg == gateScene) {
                        bgImg = noTagIcon
                        with(this) {
                            clear()
                            image(bgImg) {
                                scaledWidth = views.virtualWidth.toDouble()
                                scaledHeight = views.virtualHeight.toDouble()
                            }
                        }
                    }
                    println("New BG $bgImg")
                }
            }

        }
        val helpText = text("") {
            position(10, 100)
            addUpdater {
                // this text is only visible if the game is not in Playing state
                visible = (playState != GameStates.PLAYING)

                // show a different text if the game is just starting
                if (playState == GameStates.BEGUN) {
                    text = "Welcome to NoTag: Not Another Text Adventure Game!\n\n" +
                            "-- To move use the keys [W], [A], [S] and [D].\n\n" +
                            "-- To pickup items use the key, [P] \n\n" +
                            "-- To go back to Main Menu, use [ESC]\n\n" +
                            "-- To Start the game, use [SPACE]"

                    // show a different text if the game is in Ended state
                } else if (playState == GameStates.ENDED) {
                    text = "Press [SPACE] to leave the forest!"
                }
            }
        }

    }
}