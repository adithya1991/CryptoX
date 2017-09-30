package src.main.scala.com.adi.cryptoX.com.adi.cryptoX.dao

import src.main.scala.com.adi.cryptoX.model.MarketSummaryDBEntity

import scala.util.{Success, Try}

/**
  * Created by Adithya on 07-08-2017.
  */
trait CryptoDaoService {

  def persistToDb(dbObjects: List[MarketSummaryDBEntity]): Try[Unit]
}
