package id.man.hayujek.core.authenticator

import id.man.hayujek.core.Constants
import id.man.hayujek.core.database.entity.UserEntity
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest

/**
 *
 * Created by Lukmanul Hakim on  05/07/22
 * devs.lukman@gmail.com
 */
@EnableWebSecurity
@Configuration
class JwtConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var authenticationFilter: AuthenticationFilter

    override fun configure(http: HttpSecurity) {
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .csrf().disable()
            .addFilterAt(authenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, *postPermit.toTypedArray()).permitAll()
            .antMatchers(HttpMethod.GET, *getPermit.toTypedArray()).permitAll()
            .anyRequest().authenticated()
    }

    companion object {
        val postPermit = listOf(
            "/v1/api/customer/login",
            "/v1/api/customer/register",
            "/v1/api/driver/login",
            "/v1/api/driver/register"
        )
        val getPermit = listOf(
            "/v1/api/hello",
            "/v1/api/customer/hello",
            "/v1/api/driver/hello",
            "/v1/api/location/search",
            "/v1/api/location/reserve",
            "/v1/api/location/routes"
        )

        fun generateToken(entity: UserEntity): String {
            val expired = Date(System.currentTimeMillis() + (60_000 * 60 * 24))
            val granted = AuthorityUtils.commaSeparatedStringToAuthorityList(entity.username)
            val grantedStream = granted.stream().map { it.authority }.collect(Collectors.toList())
            return Jwts.builder()
                .setSubject(entity.id) // subject
                .claim(Constants.CLAIM, grantedStream)
                .setExpiration(expired)
                .signWith(Keys.hmacShaKeyFor(Constants.SECRET.toByteArray()), SignatureAlgorithm.HS256)
                .compact()
        }

        fun isPermit(request: HttpServletRequest): Boolean {
            val path = request.servletPath
            return postPermit.contains(path) or getPermit.contains(path)
        }
    }

}

//fun main(args: Array<String>) {
//    val keys = Keys.secretKeyFor(SignatureAlgorithm.HS256)
//    val secret = Encoders.BASE64.encode(keys.encoded)
//    println("WKWKWK $secret")
//}