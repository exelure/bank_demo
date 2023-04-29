package denis.nesterov.demo.microservices.gateway.configuration.security

import org.springframework.core.convert.converter.Converter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt


class KeyCloakJwtRoleConverter : Converter<Jwt, Collection<GrantedAuthority>> {

    override fun convert(jwt: Jwt): Collection<GrantedAuthority>? {
        val realmAccess = jwt.claims["realm_access"] as Map<*, *>

        return if (realmAccess.isEmpty()) {
            emptyList()
        } else {
            val roles = realmAccess["roles"] as List<*>
            if (roles.isEmpty()) {
                emptyList()
            } else {
                roles.map { role -> SimpleGrantedAuthority("ROLE_$role") }
            }
        }
    }
}
