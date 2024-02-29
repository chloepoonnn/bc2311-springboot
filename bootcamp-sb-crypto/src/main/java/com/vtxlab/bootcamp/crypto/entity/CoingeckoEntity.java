// package com.vtxlab.bootcamp.crypto.entity;

// import java.time.LocalDateTime;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.Setter;

// @Entity
// @Getter
// @AllArgsConstructor
// @Builder
// @Setter
// public class CoingeckoEntity {
//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Long id;
//   private String coinId;
//   private String symbol;
//   private String name;
//   private String image;
//   @Column(name = "current_price")
//   private double currentPrice;

//   @Column(name = "cap")
//   private long marketCap;

//   @Column(name = "market_cap_rank")
//   private long marketCapRank;

//   @Column(name = "fully_diluted_valuation")
//   private long fullyDilutedValuation;

//   @Column(name = "total_volume")
//   private long totalVolume;

//   @Column(name = "high_24h")
//   private double high24h;

//   @Column(name = "low_24h")
//   private double low24h;

//   @Column(name = "price_change_24h")
//   private double priceChange24h;

//   @Column(name = "price_change_percentage_24h")
//   private double priceChangePercentage24h;

//   @Column(name = "market_cap_change_24h")
//   private long marketCapChange24h;

//   @Column(name = "market_cap_change_percentage_24h")
//   private double marketCapChangePercentage24h;

//   @Column(name = "circulating_supply")
//   private long circulatingSupply;

//   @Column(name = "total_supply")
//   private long totalSupply;

//   @Column(name = "max_supply")
//   private long maxSupply;

//   private long ath;
//   @Column(name = "ath_change_percentage")
//   private double athChangePercentage;

//   @Column(name = "ath_date")
//   private LocalDateTime athDate;
//   private double atl;
//   @Column(name = "atl_change_percentage")
//   private double atlChangePercentage;

//   @Column(name = "atl_date")
//   private LocalDateTime atlDate;

//   @Column(name = "last_updated")
//   private LocalDateTime lastUpdated;

//   private double times;

//   private String currency;

//   private double percentage;
// }
