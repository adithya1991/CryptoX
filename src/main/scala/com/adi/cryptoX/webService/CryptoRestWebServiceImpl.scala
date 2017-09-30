package src.main.scala.com.adi.cryptoX.webService

import java.time.LocalDateTime
import javax.ws.rs.core.MediaType

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.apache.cxf.jaxrs.client.WebClient
import src.main.scala.com.adi.cryptoX.com.adi.cryptoX.dao.CryptoDaoServiceImpl
import src.main.scala.com.adi.cryptoX.com.adi.cryptoX.service.CryptoServiceImpl
import src.main.scala.com.adi.cryptoX.model.{MarketSummary, MarketSummaryDBEntity, MarketSummaryWrapper}

/**
  * Created by Adithya on 09-07-2017.
  */
class CryptoRestWebServiceImpl extends CryptoRestWebService {
  override def getMarketSummaries: String = {
    "bleh"
  }
}

object CryptoRestWebServiceImpl {

  def main(args: Array[String]): Unit = {
    //TO-DO Use API Key in case Bittrex does rate limiting
    val url = "https://bittrex.com/api/v1.1/public/getmarketsummaries"
    //TO-DO Use Spring for DI
    val cryptoService = new CryptoServiceImpl
    val cryptoDaoService = new CryptoDaoServiceImpl
    val clientBuilder = WebClient.create(url).accept(MediaType.MULTIPART_FORM_DATA)
    val allMarketData = clientBuilder.get(classOf[String])
    val objectMapper = new ObjectMapper() with ScalaObjectMapper
    objectMapper.registerModule(DefaultScalaModule)
    val marketData = objectMapper.readValue(allMarketData, classOf[MarketSummaryWrapper])
    // Filter only the BTC markets which I am interested in
    val filteredMarketData = cryptoService.filterInterestedMarkets(marketData)
    val dbEntities = for (elem <- filteredMarketData) yield {
      constructMarketSummaryDbObj(elem)
    }
    cryptoDaoService.persistToDb(dbEntities)
  }

  def constructMarketSummaryDbObj(marketSummary: MarketSummary): MarketSummaryDBEntity = {
    MarketSummaryDBEntity(marketSummary.marketName, LocalDateTime.parse(marketSummary.timeOfQuery), currentPosition = None, marketSummary)
  }

}
