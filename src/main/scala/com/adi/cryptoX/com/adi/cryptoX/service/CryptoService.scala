package src.main.scala.com.adi.cryptoX.com.adi.cryptoX.service

import src.main.scala.com.adi.cryptoX.model.{MarketSummary, MarketSummaryWrapper}

/**
  * Created by Adithyah on 07-08-2017.
  */
trait CryptoService {

  def filterInterestedMarkets(marketSummaryWrapper: MarketSummaryWrapper) : List[MarketSummary]
}
