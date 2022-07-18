class Technology(val id: Int, val ring: String, val technologyType: String, val technologyName: String) {

    override fun toString(): String {
        return "$id, $ring, $technologyType, $technologyName"
    }
}