
data class Domicilio(val calle: String, val numero: Int) {
    fun dirCompleta(): String {
        return "$calle $numero"
    }
}

data class Cliente(val nombre: String, val domicilio: Domicilio)



data class Compra(val cliente: Cliente, val dia: String, val monto: Double)



class RepositorioCompras {
    private val compras = mutableListOf<Compra>()

    fun agregarCompra(compra: Compra) {
        compras.add(compra)
    }

    fun domicilios(): Set<String> {
        return compras.map { it.cliente.domicilio.dirCompleta() }.toSet()
    }
}

fun main() {
    val domicilio1 = Domicilio("Av. Principal", 123)
    val domicilio2 = Domicilio("Calle Secundaria", 456)
    val cliente1 = Cliente("Juan Pérez", domicilio1)
    val cliente2 = Cliente("María López", domicilio2)
    val cliente3 = Cliente(" FREREGGRE", domicilio1)

    val compra1 = Compra(cliente1, "2025-01-30", 150.0)
    val compra2 = Compra(cliente2, "2025-01-31", 200.0)
    val compra3 = Compra(cliente3, "2025-02-01", 300.0)

    val repo = RepositorioCompras()
    repo.agregarCompra(compra1)
    repo.agregarCompra(compra2)
    repo.agregarCompra(compra3)

    println("Domicilios únicos para facturación:")
    println(repo.domicilios())
}
