import java.io.File
import java.io.FileInputStream
import java.util.*

object GradleFunctions {
    fun getProps(path: String): Properties {
        val props = Properties()
        props.load(FileInputStream(File(path)))
        return props
    }
}