package id.man.hayujek.api.repository

import com.mongodb.client.MongoCollection
import id.man.hayujek.api.entity.customer.CustomerEntity
import id.man.hayujek.api.entity.driver.DriverEntity
import id.man.hayujek.database.DatabaseComponent
import id.man.hayujek.exception.MainException
import id.man.hayujek.extentions.toResult
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 *
 * Created by Lukmanul Hakim on  01/07/22
 * devs.lukman@gmail.com
 */

@Repository
class MainRepositoryImpl(
    @Autowired
    private val databaseComponent: DatabaseComponent
) : MainRepository {

    // region Initialize


    private fun driverCollection(): MongoCollection<DriverEntity> =
        databaseComponent.database.getDatabase("driver").getCollection()

    private fun customerCollection(): MongoCollection<CustomerEntity> =
        databaseComponent.database.getDatabase("customer").getCollection()

    // endregion

    // region Driver

    override fun loginDriver(request: Any): Result<Any> {
        return Result.success("")
    }

    override fun registerDriver(request: Any): Result<Any> {
        return Result.success("")
    }

    override fun getDriver(request: Any): Result<Any> {
        return Result.success("")
    }

    // endregion

    // region Customer

    override fun loginCustomer(request: Any): Result<Any> {
        return Result.success("")
    }

    override fun registerCustomer(customerEntity: CustomerEntity): Result<Boolean> {
        val isExistingUser = getCustomerByUserName(customerEntity.username)
        return if (isExistingUser.isSuccess) {
            throw MainException("Customer Exist!")
        } else {
            customerCollection().insertOne(customerEntity).wasAcknowledged().toResult()
        }
    }

    override fun getCustomerById(id: String): Result<CustomerEntity> {
        return customerCollection().findOne(CustomerEntity::id eq id).toResult()
    }

    override fun getCustomerByUserName(userName: String): Result<CustomerEntity> {
        return customerCollection().findOne(CustomerEntity::username eq userName)
            .toResult("Customer with name $userName not found!")
    }

    // endregion
}