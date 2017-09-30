package src.main.scala.com.adi.cryptoX.model

import java.time.LocalDateTime

import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.MongoClient
import org.mongodb.scala.bson.ObjectId

/*
A case class which will be used to enrich what we receive from exchange
and persist onto the database
 Classic decorator
 */
case class MarketSummaryDBEntity(_id: ObjectId = new ObjectId(),
                                 coinName: String,
                                 timeStamp: LocalDateTime,
                                 // This is based on the sorted order retrieved from Bittrex
                                 currentPosition: Option[Int],
                                 marketSummaryInfo: MarketSummary
                                ) {

 val codecRegistry = fromRegistries(fromProviders(classOf[MarketSummaryDBEntity]),MongoClient.DEFAULT_CODEC_REGISTRY)
}
