package src.main.scala.com.adi.cryptoX.model

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

@JsonIgnoreProperties(Array("Created"))
case class MarketSummary(@JsonProperty("MarketName")
                         marketName: String,
                         @JsonProperty("High")
                         highPrice: BigDecimal,
                         @JsonProperty("Low")
                         lowPrice: BigDecimal,
                         @JsonProperty("Volume")
                         volume: BigDecimal,
                         @JsonProperty("Last")
                         lastPrice: BigDecimal,
                         @JsonProperty("BaseVolume")
                         baseVolume: BigDecimal,
                         @JsonProperty("TimeStamp")
                         timeOfQuery: String,
                         @JsonProperty("Bid")
                         lastBid: BigDecimal,
                         @JsonProperty("Ask")
                         lastAsk: BigDecimal,
                         @JsonProperty("OpenBuyOrders")
                         currentOpenBuyOrders: Int,
                         @JsonProperty("OpenSellOrders")
                         currentOpenSellOrders: Int,
                         @JsonProperty("PrevDay")
                         prevDay: BigDecimal) {
  // TO-DO
  // Have an implicit function which handles the precision of Big Decimal
}
