import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.ValueSource


internal class CsvReaderTest {

    private val csvReaderTest: CsvReader = CsvReader()

    @ParameterizedTest
    @ValueSource(strings = ["src/main/resources/ZalandoTechnologies.csv", "src/main/resources/ZalandoTechnologies.txt"])
    fun checkFiles(csvPath: String) {
        csvReaderTest.readCsv(csvPath)
    }

    @Test
    fun checkAmountOfRings() {
        val expected = 4
        val technologies = csvReaderTest.readCsv("src/main/resources/ZalandoTechnologies.csv")
        println("Sprawdzam: "+csvReaderTest.readRingsNumber(technologies))
        assertEquals(expected, csvReaderTest.readRingsNumber(technologies))
    }

    @Test
    fun checkNamesOfRings() {
        val strings = setOf<String>("Assess", "Hold", "Trial", "Adopt")
        val technologies = csvReaderTest.readCsv("src/main/resources/ZalandoTechnologies.csv")
        assertEquals(strings, csvReaderTest.readRings(technologies))
    }

}