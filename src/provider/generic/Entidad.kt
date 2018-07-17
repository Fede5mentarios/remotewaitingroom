package provider.generic

import java.io.Serializable

interface Entidad<ID : Serializable> {
    val id: ID
}
