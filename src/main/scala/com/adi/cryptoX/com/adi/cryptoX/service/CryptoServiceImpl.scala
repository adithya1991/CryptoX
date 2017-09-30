package src.main.scala.com.adi.cryptoX.com.adi.cryptoX.service

import src.main.scala.com.adi.cryptoX.model.{MarketSummary, MarketSummaryWrapper}

/**
  * Created by Adithya on 07-08-2017.
  */
class CryptoServiceImpl extends CryptoService {
  override def filterInterestedMarkets(marketData: MarketSummaryWrapper): List[MarketSummary] = {
    marketData.result.filter(_.marketName.contains("BTC")).toList
  }
}
