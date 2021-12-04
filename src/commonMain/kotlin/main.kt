import com.soywiz.korge.*
import com.soywiz.korge.scene.Module
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korma.geom.*

suspend fun main() = Korge(Korge.Config(module = MyFirstModule))

object MyFirstModule: Module() {
	// define the opening scene
	override val mainScene = MenuScene::class

	// define the game configs
	override val title: String = "NoTag"
	override val icon: String = "NoTag.png"
	override val size: SizeInt = SizeInt(800, 600)

	// add the scenes to the module
	override suspend fun AsyncInjector.configure() {
		mapPrototype { MenuScene() }
		mapPrototype { PlayScene() }
		mapPrototype { CreditsScene() }
	}
}
