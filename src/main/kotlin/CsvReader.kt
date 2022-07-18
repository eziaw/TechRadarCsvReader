import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class CsvReader {

    var technologies: ArrayList<Technology> = ArrayList()

    fun readCsv(csvPath: String): ArrayList<Technology> {
        val csvFile = File(csvPath)
        BufferedReader(FileReader(csvFile)).use { br ->
            br.readLine()
            var line: String?
            while (br.readLine().also { line = it } != null) {
                val row = line?.split(";")
                row?.get(0)?.let {
                    Technology(
                        id = it.toInt(),
                        ring = row.get(1),
                        technologyType = row.get(2),
                        technologyName = row.get(3)
                    )
                }?.let { technologies.add(it) }
            }
        }
        /*
        for (i in 0 until technologies.size) {
            println(technologies.get(i).toString())
        }
         */
        return technologies
    }

    fun readRingsNumber(technologies: ArrayList<Technology>): Int {
        var rings = mutableSetOf<String>()
        for (i in 0 until technologies.size) {
            rings.add(technologies.get(i).ring)
        }
        return rings.size
    }

    fun readRings(technologies: ArrayList<Technology>): Set<String> {
        var rings = mutableSetOf<String>()
        for (i in 0 until technologies.size) {
            rings.add(technologies.get(i).ring)
        }
        return rings
    }

}