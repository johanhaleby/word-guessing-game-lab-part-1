package se.parkster.occurrent.lab.wordguessinggame

import com.mongodb.ConnectionString
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import se.parkster.occurrent.lab.wordguessinggame.support.FlushMongoDBExtension


@SpringBootTest
@Testcontainers
class WordGuessingGameIntegrationTest {

    companion object {
        @JvmField
        @Container
        var mongoDBContainer: MongoDBContainer = MongoDBContainer("mongo:4.2.8").apply {
            portBindings = listOf("27017:27017")
        }

        @JvmField
        @RegisterExtension
        val flushMongoDBExtension : FlushMongoDBExtension = FlushMongoDBExtension(ConnectionString("mongodb://localhost:27017/test"))
    }


    @Test
    fun `start write awesome tests`() {

    }
}
