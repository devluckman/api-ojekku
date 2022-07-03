package id.man.hayujek.database

import com.mongodb.client.MongoClient
import org.springframework.stereotype.Component
import org.litote.kmongo.KMongo

/**
 *
 * Created by Lukmanul Hakim on  02/07/22
 * devs.lukman@gmail.com
 */
@Component
object DatabaseComponent {

    private val databaseURL = System.getenv("DATABASE_URL")
    val  database : MongoClient = KMongo.createClient(databaseURL)

}