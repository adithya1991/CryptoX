package src.main.scala.com.adi.cryptoX.com.adi.cryptoX.dao

import org.mongodb.scala.MongoClient
import src.main.scala.com.adi.cryptoX.model.MarketSummaryDBEntity

import scala.util.{Success, Try}

/**
  * Created by Adithya on 07-08-2017.
  */
class CryptoDaoServiceImpl extends CryptoDaoService {
  override def persistToDb(dbObjects: List[MarketSummaryDBEntity]): Try[Unit] = {
    val mongoClient : MongoClient = MongoClient("mongodb://localhost")
    val database = mongoClient.getDatabase("cryptex")
    val allCurrencies = database.getCollection("marketSummaryInfo")

    allCurrencies.insertOne()


    Success(Unit)
  }
}
